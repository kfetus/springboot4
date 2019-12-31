package base.biz.sign;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Transactional
@Service("signByCanvasService")
public class SignByCanvasService {

//	@Autowired 
//	private PlatformTransactionManager transactionManager;

	
	@Resource(name="signByCanvasMapper")
	private SignByCanvasMapper signByCanvasMapper;
	
	private Logger log = LogManager.getLogger(this.getClass());
	
	public List<HashMap<String, Object>> selectSignList(HashMap<String, String> map) throws Exception {
		log.debug("service"+map);
		return signByCanvasMapper.selectSignList(map);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor=Exception.class)
	public void insertSign(String pk, String signData) throws Exception {
//		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
//		try {
		signByCanvasMapper.insertSign(pk, signData);
		signByCanvasMapper.updateSign(signData);
		signByCanvasMapper.insertSign(pk, signData);
//		} catch(Exception e) {
//			e.printStackTrace();
//			transactionManager.rollback(status);
//		}
//		transactionManager.commit(status);

	}
}
