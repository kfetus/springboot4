package base.biz.sign;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import base.comm.data.JsonResModel;
import base.comm.property.MessagePropertyService;
import base.comm.property.SystemPropertyService;
import base.comm.util.DateUtil;
/**
 * 캔바스 사인 테스트
 * @author naru
 *
 */
@RequestMapping(value = "/sign")
@Controller
public class SignByCanvasController {

	protected Logger log = LogManager.getLogger(this.getClass());

	@Autowired
	private SystemPropertyService sysProperties;
	
	@Autowired
	private MessagePropertyService messProperties;
	
	@Autowired
	private SignByCanvasService signByCanvasService;
	
	@RequestMapping(value = "/canvasView")
	public ModelAndView canvasView(@RequestParam Map<String,Object> map) throws Exception {
		log.debug("############## START canvasView ##############");
		log.debug(sysProperties.getTest());
		log.debug(messProperties.getTest());
		
		log.debug(DateUtil.getToday());
		
		ModelAndView mv = new ModelAndView();
/*		
		Properties properties = System.getProperties();
		for(Entry<Object, Object> entry : properties.entrySet()) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
*/		
		mv.addObject("pageTitle", "사인 테스트" );
		mv.setViewName("biz/sign/canvasView.tiles");
		log.debug("############## END canvasView ##############");
		return mv;
	}

	
	@RequestMapping(value = "/canvasInsert")
	@ResponseBody
	public JsonResModel canvasInsert(@RequestBody HashMap<String,String> map) throws Exception {
		log.debug("############## START canvasInsert ##############"+map);
		
		String signKey = System.currentTimeMillis()/1000+ map.get("id");
		log.debug("@@@@@@ signKey @@@@@@"+signKey);

		signByCanvasService.insertSign(signKey, map.get("dataUrl"));
		
		JsonResModel jsonModel = new JsonResModel();
		jsonModel.setData(map);

		log.debug("############## END canvasInsert ##############");
		return jsonModel;
	}

	@RequestMapping(value = "/jsonRequestBody")
	@ResponseBody
	public JsonResModel jsonRequestBody(@RequestBody Map<String,String> map) throws Exception {
		log.debug("############## START jsonRequestBody ##############" + map);
		
		JsonResModel jsonModel = new JsonResModel();
		
		log.debug("############## END jsonRequestBody ##############");
		return jsonModel;
	}
	
	@RequestMapping(value = "/jsonRequestParam")
	@ResponseBody
	public JsonResModel jsonRequestParam(@RequestParam Map<String,String> map) throws Exception {
		log.debug("############## START jsonRequestParam ##############"+map);
		
		JsonResModel jsonModel = new JsonResModel();
		
		log.debug("############## END jsonRequestParam ##############");
		return jsonModel;
	}
	
	@RequestMapping(value = "/jsonServletRequest")
	@ResponseBody
	public JsonResModel jsonServletRequest(HttpServletRequest request) throws Exception {
		log.debug("############## START jsonServletRequest ##############");
        Enumeration<?> en = request.getParameterNames();
        while(en.hasMoreElements()) {
        	String paramKey = (String) en.nextElement();            	
        	log.debug("key : " + paramKey +";value="+request.getParameter(paramKey));
        }
		
		JsonResModel jsonModel = new JsonResModel();
		
		log.debug("############## END jsonServletRequest ##############");
		return jsonModel;
	}	
}
