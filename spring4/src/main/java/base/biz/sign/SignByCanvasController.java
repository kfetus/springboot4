package base.biz.sign;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import base.comm.data.JsonResModel;

@RequestMapping(value = "/sign")
@Controller
public class SignByCanvasController {

	protected Logger log = LogManager.getLogger(this.getClass());
	
	@RequestMapping(value = "/canvasView")
	public ModelAndView canvasView(@RequestParam Map<String,Object> map) throws Exception {
		log.debug("############## START canvasView ############## ");
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("pageTitle", "사인 테스트" );
		mv.setViewName("biz/sign/canvasView.tiles");
		log.debug("############## END canvasView ############## ");
		return mv;
	}

	
	@RequestMapping(value = "/canvasInsert")
	@ResponseBody
	public JsonResModel canvasInsert(@RequestParam Map<String,Object> map) throws Exception {
		log.debug("############## START canvasInsert ############## "+map);
		
		JsonResModel jsonModel = new JsonResModel();
		
		
		
		log.debug("############## END canvasInsert ############## ");
		return jsonModel;
	}
	
}
