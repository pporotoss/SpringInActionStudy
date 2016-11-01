package concert;

import org.springframework.stereotype.Component;

@Component(value="performance")
public class SuccessPerformance implements Performance{

	@Override
	public void perform() {
		System.out.println("Performace.....");
	}

}
