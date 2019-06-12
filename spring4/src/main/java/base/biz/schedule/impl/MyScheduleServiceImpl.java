package base.biz.schedule.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import base.biz.schedule.MyScheduleService;

@Service("myScheduleService")
public class MyScheduleServiceImpl implements MyScheduleService {

	@Resource(name="myScheduleMapper")
	private MyScheduleMapper myScheduleMapper;
	
	private Logger log = LogManager.getLogger(this.getClass());
	
	@Override
	public List<Map<String, Object>> selectScheduleList(Map<String, Object> map) throws Exception {
//		return myScheduleDAO.selectScheduleList(map);
		log.debug("service"+map);
		return myScheduleMapper.selectScheduleList(map);
	}

	@Override
	public void insertSchedule(Map<String, Object> map) throws Exception {
		myScheduleMapper.insertSchedule(map);
	}

	@Override
	public List<Map<String, Object>> selectScheduleView(String pk) throws Exception {
		
		return myScheduleMapper.selectScheduleView(pk);
	}

	@Override
	public void updateSchedule(Map<String, Object> map) throws Exception {
		myScheduleMapper.updateSchedule(map);
	}

	@Override
	public void deleteSchedule(Map<String, Object> map) throws Exception {
		myScheduleMapper.deleteSchedule(map);	
	}

	
}
