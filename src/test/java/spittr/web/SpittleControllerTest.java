package spittr.web;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import spittr.Spittle;
import spittr.data.SpittleRepository;

public class SpittleControllerTest {
	
	@Test
	public void shouldShowRecentSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository mockRepository = mock(SpittleRepository.class);	// SpittleRepository 인터페이스의 목객체 생성.
		when(mockRepository.findSpittles(Long.MAX_VALUE, 20))	// mock 객체에 조건과 해당 조건시 반환할 값 설정.
			.thenReturn(expectedSpittles);
		
		SpittleController controller = new SpittleController(mockRepository);	// 컨트롤러에 테스트를 위해 목객체 주입.
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)	// controller 단독으로 목객체 생성.
																.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
																.build();	// MockMvc 객체 생성.
		mockMvc.perform(get("/spittles"))	// get 방식으로 /spittles 요청을 수행.
					.andExpect(view().name("spittles"))	// 요청 수행후 반환이 예상되는 뷰의 이름이 spittles인지 확인. 
					.andExpect(model().attributeExists("spittleList"))	// 모델객체에 spittleList 라는 이름의 키값이 있는지 확인.
					.andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));	// 모델에 있는 spittleList에 아이템이 존재하는지 확인.
																			// hamcrest의 hasItems()매처는 List를 배열로 바꿔줘야 검사 가능.
	}

	@Test
	public void shouldShowPagedSpittles() throws Exception {
			List<Spittle> expectedSpittles = createSpittleList(50);
			SpittleRepository mockRepository = mock(SpittleRepository.class);
			when(mockRepository.findSpittles(238900, 50))
				.thenReturn(expectedSpittles);
			
			SpittleController controller = new SpittleController(mockRepository);
			
			MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
																.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
																.build();
			mockMvc.perform(get("/spittles?max=238900&count=50"))
						.andExpect(view().name("spittles"))
						.andExpect(model().attributeExists("spittleList"))
						.andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
			
	}
	
	@Test
	public void testSpittle() throws Exception {
		Spittle expectedSpittle = new Spittle("Hello", new Date());
		SpittleRepository mockRepository = mock(SpittleRepository.class);
		when(mockRepository.findOne(12345))
			.thenReturn(expectedSpittle);
		
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spittles/12345"))
					.andExpect(view().name("spittle"))
					.andExpect(model().attributeExists("spittle"))
					.andExpect(model().attribute("spittle", expectedSpittle));
	}
	
	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle "+i, new Date()));
		}
		return spittles;
	}
}
