package presentation_layer;

public class OrderConResponse {
	private int orderID;
	private int status;
	private String errordesc;
	private int errorcode;
	
	public OrderConResponse(int orderID, int status, String errordesc, int errorcode) {
		this.setOrderID(orderID);
		this.setStatus(status);
		this.setErrorcode(errorcode);
		this.setErrordesc(errordesc);
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrordesc() {
		return errordesc;
	}

	public void setErrordesc(String errordesc) {
		this.errordesc = errordesc;
	}

	public int getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	

}
