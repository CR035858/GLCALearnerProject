package dom.session.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/greet")
public class WelcomeController {
	
	@RequestMapping("/sayHello")
	public String sayHello()
	{
		return "hello";
	}

}
