package base.comm.data;

import java.util.Map;

public class JsonResModel {

	private String status = "200";
	private String msg;
	private Map<String,String> data;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JsonResModel [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
}
