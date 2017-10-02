package VO;

public class ServiceResultVO<X> {

	int statusCode;
	String status;
	X data;
	
	
	public ServiceResultVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public X getData() {
		return data;
	}
	public void setData(X data) {
		this.data = data;
	}
	
}
