package base.comm.data;

import java.util.HashMap;

public class JsonResModel {

	private String status = "200";
	private String msg;
	private HashMap<String,String> data;
	
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
	public HashMap<String, String> getData() {
		return data;
	}
	public void setData(HashMap<String, String> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JsonResModel [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
}
