package harry.chat.client.tool;

import harry.chat.client.surface.Chat;

import java.util.HashMap;

/**
 * 
 * @author harry
 *
 */
public class ManageChat {
	private static HashMap<String, Chat> hm = new HashMap<String, Chat>();

	public static void addChat(String friend, Chat chat) {
		hm.put(friend, chat);
	}

	public static Chat getChat(String friend) {
		return hm.get(friend);
	}
}
