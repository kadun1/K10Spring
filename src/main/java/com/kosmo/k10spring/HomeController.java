package com.kosmo.k10spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/*
	Step2: 요청명을 통해 컨트롤러를 찾아 매핑된 메소드를 호출한다.
		컨트롤러에서는 매핑명을 통해 메소드를 호출하므로 메소드명은
		중복되지 않는 정도의 이름을 사용하면 된다.
	 */
	@RequestMapping("/home/helloSpring")
	public String helloSpring(Model model) {
		
		/*
		Spring에서는 4가지 영역과 비슷한 model객체를 사용해서 속성을
		저장한다. 사용법은 거의 비슷하다.
		 */
		String firstMessage = "My First SPRING MVC 컨트롤러";
		model.addAttribute("firstMessage", firstMessage);
		
		/*
		View의 이름을 반환한다. 해당 뷰의 이름은 ViewResolver가 조립하여
		최종적으로 뷰를 웹브라우저에 출력한다.
		 */
		return "HelloSpring";
	}
	
	/*
	폼값받기4] @PathVariable 어노테이션으로 폼값받기
	요청명뒤에 경로처럼 붙은값이 실제 사용가능한 파라미터가된다.
	파라미터를 마치 경로명처럼 사용하게되고, 이때 주의해야 할점은
	웹브라우저는 요청명을 경로로 인식하므로 리소스를 사용할때 경로를
	주의해야 한다. 또한 파라미터의 갯수가 틀려지면 404에러가 발생된다.
	 */
	@RequestMapping("/form/{memberId}/{memberName}")
	public String pathVariable(Model model,
			@PathVariable String memberId,
			@PathVariable String memberName) {
		
		model.addAttribute("memberId", memberId);
		model.addAttribute("memberName", memberName);
		
		return "01Form/pathVariable";
	}
	
	
	
	
	
}
