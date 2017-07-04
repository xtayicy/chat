package server.pattern;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * @author harry
 *
 */
public class ManageThread{
	public static HashMap<String, ServerClientThread> hm = new HashMap<String, ServerClientThread>();

	public static void addThread(String userId,ServerClientThread sct){
		hm.put(userId, sct);
	}
	
	public static ServerClientThread getThread(String userId){
		return hm.get(userId);
	}

	public static String getOnLineId(){
		Iterator<String> it =  hm.keySet().iterator();
		String str = "";
		
		while(it.hasNext()){
			str += it.next().toString()+" ";
		}
		
		return str;
	}
}
