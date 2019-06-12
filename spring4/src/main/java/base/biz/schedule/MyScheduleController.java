package base.biz.schedule;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/schedule")
@Controller
public class MyScheduleController {

	protected Logger log = LogManager.getLogger(this.getClass());
	
	@Resource(name="myScheduleService")
	private MyScheduleService myScheduleService;
	
	@RequestMapping(value = "/scheduleList.do")
	public ModelAndView scheduleList(@RequestParam Map<String,Object> map) throws Exception {
		log.info("Welcome home! The client locale is {}.",Locale.KOREA);
		log.debug("한글 로그 테스트"+map);
		
		ModelAndView mv = new ModelAndView("biz/schedule/scheduleList");
		List<Map<String,Object>> returnList = myScheduleService.selectScheduleList(map); 
		mv.addObject("list", returnList );
		mv.addAllObjects(map);
		log.debug("##############"+returnList);
		return mv;
	}

	@RequestMapping(value = "/scheduleInsertView.do")
	public String scheduleInsertView(@RequestParam Map<String,Object> map, Model model) throws Exception {
		log.debug("등록 화면 이동"+map);
		
		model.addAllAttributes(map);

		return "biz/schedule/scheduleInsert";
	}

	@RequestMapping(value = "/scheduleInsert.do")
	public String scheduleInsert(@RequestParam Map<String,Object> map) throws Exception {
		log.debug("등록 테스트"+map);
		
		myScheduleService.insertSchedule(map);

//		return "forward:/schedule/scheduleList.do"; request,response 공유
		return "redirect:/schedule/scheduleList.do"; //새로운 request,response 생성
	}

	@RequestMapping(value = "/scheduleView.do")
	public String scheduleView(@RequestParam Map<String,Object> map, Model model) throws Exception {
		log.debug("view start="+map);
		
		String pk = (String) map.get("pk");
		List<Map<String,Object>> returnList = myScheduleService.selectScheduleView(pk); 
		model.addAttribute("list", returnList );
		
		log.debug("model="+model);

		return "biz/schedule/scheduleView";
	}
	
	@RequestMapping(value = "/scheduleUpdate.do")
	@ResponseBody
	public Map<String,Object> scheduleUpdate(@RequestParam Map<String,Object> map, Model model) throws Exception {
		log.debug("수정 테스트"+map);
		myScheduleService.updateSchedule(map);
		map.put("U_status", "ok");
		return map;
	}

	@RequestMapping(value = "/scheduleDelete.do")
	public String scheduleDelete(@RequestParam Map<String,Object> map, Model model) throws Exception {
		log.debug("수정 테스트"+map);
		myScheduleService.deleteSchedule(map);
		model.addAttribute("status", "ok");
		return "jsonView";
	}
	
}