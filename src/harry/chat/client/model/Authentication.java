package harry.chat.client.model;
import harry.chat.common.*;

/**
 * 
 * @author harry
 *
 */
public class Authentication {
	public boolean checkUser(User user){
		return new Link().send(user);
	}
}
