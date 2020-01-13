package base.biz.board;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 간단 게시판
 * @author naru
 *
 */
@Service
public class BoardService {

	protected Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired
	private BoardMapper boardMapper;
	
	/**
	 * 게시판 목록 조회
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<HashMap<String, String>> selectBoardList(HashMap<String, String> map) throws Exception {
		log.debug("service"+map);
		return boardMapper.selectBoardList(map);
	}
	
	/**
	 * 게시판 데이터 등록
	 * @param map
	 * @throws Exception
	 */
	public void insertBoard(HashMap<String, String> map) throws Exception {
		boardMapper.insertBoard(map);
	}

	/**
	 * 게시판 데이터 삭제
	 * @param seq
	 * @throws Exception
	 */
	public void deleteBoard(String seq) throws Exception {
		boardMapper.deleteBoard(seq);
	}
}
