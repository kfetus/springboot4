package base.biz.schedule.impl;

import java.util.List;
import java.util.Map;

import base.comm.dbio.ProjectMapper;

//@ProjectMapper("myScheduleMapper")
public interface MyScheduleMapper {

	public List<Map<String, Object>> selectScheduleList(Map<String, Object> map) throws Exception;
	public void insertSchedule(Map<String, Object> map) throws Exception;
	public List<Map<String, Object>> selectScheduleView(String pk) throws Exception;
	public void updateSchedule(Map<String, Object> map) throws Exception;
	public void deleteSchedule(Map<String, Object> map) throws Exception;
}
