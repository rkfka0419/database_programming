package company;


public class Message {
	private int mnumber;
	private String title;
	private String body;
	private String sender;
	private String receiver;
	private String sendtime;
	public int getMnumber() {
		return mnumber;
	}
	public void setMnumber(int mnumber) {
		this.mnumber = mnumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
}

