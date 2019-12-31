package base.biz.schedule.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
/**
 * 샘플링 달력 조회 서비스. interface 제거
 * @author ojh
 *
 */
@Service("myScheduleService")
public class MyScheduleServiceImpl {

	@Resource(name="myScheduleMapper")
	private MyScheduleMapper myScheduleMapper;
	
	private Logger log = LogManager.getLogger(this.getClass());
	
	public List<Map<String, Object>> selectScheduleList(Map<String, Object> map) throws Exception {
//		return myScheduleDAO.selectScheduleList(map);
		log.debug("service"+map);
		return myScheduleMapper.selectScheduleList(map);
	}

	public void insertSchedule(Map<String, Object> map) throws Exception {
		myScheduleMapper.insertSchedule(map);
	}

	public List<Map<String, Object>> selectScheduleView(String pk) throws Exception {
		
		return myScheduleMapper.selectScheduleView(pk);
	}

	public void updateSchedule(Map<String, Object> map) throws Exception {
		myScheduleMapper.updateSchedule(map);
	}

	public void deleteSchedule(Map<String, Object> map) throws Exception {
		myScheduleMapper.deleteSchedule(map);	
	}

	
}
