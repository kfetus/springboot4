package base.biz.sign;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private Properties properties;
	
	@RequestMapping(value = "/canvasView")
	public ModelAndView canvasView(@RequestParam Map<String,Object> map) throws Exception {
		log.debug("############## START canvasView ############## ");
		log.debug(properties.getProperty("test"));
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("pageTitle", "사인 테스트" );
		mv.setViewName("biz/sign/canvasView.tiles");
		log.debug("############## END canvasView ############## ");
		return mv;
	}

	
	@RequestMapping(value = "/canvasInsert")
	@ResponseBody
	public JsonResModel canvasInsert(@RequestParam Map<String,String> map) throws Exception {
		log.debug("############## START canvasInsert ############## "+map);
		
		JsonResModel jsonModel = new JsonResModel();

		log.debug("############## END canvasInsert ############## ");
		return jsonModel;
	}

	@RequestMapping(value = "/jsonTest")
	@ResponseBody
	public JsonResModel jsonTest(HttpServletRequest request) throws Exception {
		log.debug("############## START jsonTest ############## ");
		
        Enumeration<?> en = request.getParameterNames();
        while(en.hasMoreElements()) {
        	String paramKey = (String) en.nextElement();            	
        	log.debug("key : " + paramKey +";value="+request.getParameter(paramKey));
        }
		
		JsonResModel jsonModel = new JsonResModel();
		
		log.debug("############## END jsonTest ############## ");
		return jsonModel;
	}
	
	
}
