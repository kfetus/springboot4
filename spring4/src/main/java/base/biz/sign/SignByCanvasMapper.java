package base.biz.sign;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import base.comm.dbio.ProjectMapper;

//@ProjectMapper("signByCanvasMapper")
public interface SignByCanvasMapper {

	public List<HashMap<String, Object>> selectSignList(HashMap<String, String> map) throws Exception;
	
	public void insertSign(@Param("signKey") String signKey, @Param("signData") String signData) throws Exception;
	
	public void updateSign(@Param("signData") String signData) throws Exception;
}
