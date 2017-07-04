package client.tool;

import java.util.HashMap;

import client.surface.Chat;

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
