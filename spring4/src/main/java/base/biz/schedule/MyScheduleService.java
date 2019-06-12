package base.biz.schedule;

import java.util.List;
import java.util.Map;

public interface MyScheduleService {

	public List<Map<String,Object>> selectScheduleList(Map<String,Object> map) throws Exception;
	
	public void insertSchedule(Map<String,Object> map) throws Exception;
	
	public List<Map<String,Object>> selectScheduleView(String pk) throws Exception;
	
	public void updateSchedule(Map<String,Object> map) throws Exception;
	
	public void deleteSchedule(Map<String,Object> map) throws Exception;
}
