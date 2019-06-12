package base.work.home;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	protected Logger log = LogManager.getLogger(HomeController.class);
	 
	@RequestMapping(value = "/base.do")
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.");
		log.debug("한글 로그 테스트"+model);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

}
