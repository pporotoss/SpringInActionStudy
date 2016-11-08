package spittr.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class HomeControllerTest {

	@Test
	public void testHomePage() throws Exception {
		HomeController controller = new HomeController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();	// controller 의 mock 객체 생성.
		
		mockMvc.perform(get("/"))	// get형식으로 '/' 요청 수행.
					.andExpect(view().name("home"));	// 요청 수행 후 반환 예상되는 뷰의 이름이 home 
		
		mockMvc.perform(get("/homepage"))	// get형식으로 '/homepage' 요청 수행.
		.andExpect(view().name("home"));	// 요청후 반환 예상되는 뷰의 이름이 home 
	}
}
