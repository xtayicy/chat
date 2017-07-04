package common;

/**
 * 
 * @author harry
 *
 */
public class User implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9012743713734710644L;
	private String userId;
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}