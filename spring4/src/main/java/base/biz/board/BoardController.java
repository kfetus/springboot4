package base.biz.board;

import java.util.HashMap;
import java.util.List;

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

/**
 * 간단 게시판
 * @author naru
 *
 */
@RequestMapping(value = "/board")
@Controller
public class BoardController {

	protected Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/boardList")
	public ModelAndView boardList(@RequestParam HashMap<String,String> map) throws Exception {
		log.debug("############## START boardList ##############");
		
		List<HashMap<String, String>> list = boardService.selectBoardList(map);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("reqMap", map );
		mv.addObject("list", list );
		mv.addObject("pageTitle", "게시판 목록" );
		
		mv.setViewName("biz/board/boardList.tiles");
		log.debug("############## END boardList ##############"+list);
		return mv;
	}

	@RequestMapping(value = "/boardInsert")
	@ResponseBody
	public JsonResModel boardInsert(@RequestBody HashMap<String,String> map) throws Exception {
		log.debug("############## START boardInsert ##############"+map);
		
		boardService.insertBoard(map);
		
		JsonResModel jsonModel = new JsonResModel();
		jsonModel.setMsg("등록되었습니다.");

		log.debug("############## END boardInsert ##############");
		return jsonModel;
	}
	

	@RequestMapping(value = "/boardDelete")
	public String boardDelete(@RequestParam HashMap<String,String> map) throws Exception {
		log.debug("############## START boardDelete ##############");
		String seq = map.get("seq");
		
		boardService.deleteBoard(seq);
		
		log.debug("############## END boardDelete ##############");
		return "redirect:/board/boardList";
	}	
	
	@RequestMapping(value = "/boardSearch")
	@ResponseBody
	public JsonResModel boardSearch(@RequestBody HashMap<String,String> map) throws Exception {
		log.debug("############## START boardSearch ##############"+map);
		
		List<HashMap<String, String>> searchList = boardService.selectBoardList(map);
		
		HashMap<String,Object> returnMap = new HashMap<String,Object>();
		JsonResModel jsonModel = new JsonResModel();
		returnMap.put("list", searchList);
		jsonModel.setData(returnMap);

		log.debug("############## END boardSearch ##############");
		return jsonModel;
	}
}
