package base.comm.property;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 메세지 프로퍼티 관리
 * @author ojh
 *
 */
@Service("messagePropertyService")
public class MessagePropertyService {

	private Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired
	private Properties properties;
	
	public String getTest() {
		log.debug("$$$$$$ MessagePropertyService.getTest $$$$$$");
		return properties.getProperty("message.test");
	}
}
