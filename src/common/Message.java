package common;

/**
 * 
 * @author harry
 *
 */
public class Message implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7409330221658216731L;
	private String messageType;
	private String getter;
	private String sender;
	private String content;
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGetter() {
		return getter;
	}

	public void setGetter(String getter) {
		this.getter = getter;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
}
