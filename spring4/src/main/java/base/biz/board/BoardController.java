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
 * @author ojh
 *
 */
@RequestMapping(value = "/board")
@Controller
public class BoardController {

	protected Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;

	/**
	 * 게시판 조회
	 * @param map
	 * @return
	 * @throws Exception
	 */
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

	/**
	 * 게시판 등록. json 형식
	 * @param map
	 * @return
	 * @throws Exception
	 */
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
	
	/**
	 * 게시물 삭제
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/boardDelete")
	public String boardDelete(@RequestParam HashMap<String,String> map) throws Exception {
		log.debug("############## START boardDelete ##############");
		String seq = map.get("seq");
		
		boardService.deleteBoard(seq);
		
		log.debug("############## END boardDelete ##############");
		return "redirect:/board/boardList";
	}

	/**
	 * 게시물 상세 보기
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/boardView")
	public ModelAndView boardView(@RequestParam HashMap<String,String> map) throws Exception {
		log.debug("############## START boardView ##############");
		String seq = map.get("seq");
		
		HashMap<String, String> detailData = boardService.selectBoardView(seq);
		log.debug("############## 조회 결과 {}",detailData);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("detailData", detailData );
		mv.addObject("pageTitle", "게시판 상세" );
		
		mv.setViewName("biz/board/boardView.tiles");
		log.debug("############## END boardView ##############");
		return mv;
	}
	
	/**
	 * 게시물 수정
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/boardUpdate")
	public String boardUpdate(@RequestParam HashMap<String,String> map) throws Exception {
		log.debug("############## START boardUpdate ##############");
		
		boardService.updateBoard(map);
		
		log.debug("############## END boardUpdate ##############");
		return "redirect:/board/boardList";
	}
	
}
