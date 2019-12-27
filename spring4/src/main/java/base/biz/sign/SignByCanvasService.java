package base.biz.sign;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("signByCanvasService")
public class SignByCanvasService {

	@Resource(name="signByCanvasMapper")
	private SignByCanvasMapper signByCanvasMapper;
	
	private Logger log = LogManager.getLogger(this.getClass());
	
	public List<HashMap<String, Object>> selectSignList(HashMap<String, String> map) throws Exception {
		log.debug("service"+map);
		return signByCanvasMapper.selectSignList(map);
	}

	public void insertSign(String pk, String signData) throws Exception {
		signByCanvasMapper.insertSign(pk, signData);
	}
}
