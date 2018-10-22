package harry.chat.client.tool;

import java.util.HashMap;

/**
 * 
 * @author Harry
 *
 */
public class ManageThread{
	private static HashMap<String, LinkServerThread> hm = new HashMap<String, LinkServerThread>();
	
	public static void addLinkServerThread(String id,LinkServerThread lst){
		hm.put(id, lst);
	}
	
	public static LinkServerThread getLinkServerThread(String id){
		return hm.get(id);
	}
}
