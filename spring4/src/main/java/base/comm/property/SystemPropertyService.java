package base.comm.property;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 시스템 프로퍼티 관리
 * @author ojh
 *
 */
@Service("systemPorpertyService")
public class SystemPropertyService {

	private Logger log = LogManager.getLogger(this.getClass());
	
	private final String propertyType = "system";
	
	@Autowired
	private Properties properties;
	
	public String getTest() {
		log.debug("$$$$$$ SystemPorpertyService.getTest $$$$$$");
		return properties.getProperty(propertyType+".test");
	}
}
