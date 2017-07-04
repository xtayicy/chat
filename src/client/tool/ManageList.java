package client.tool;

import java.util.HashMap;

import client.surface.List;

/**
 * 
 * @author harry
 *
 */
public class ManageList {
	private static HashMap<String, List> hm = new HashMap<String, List>();
	
	public static void addList(String id,List list){
		hm.put(id, list);
	}
	
	public static List getList(String id){
		return hm.get(id);
	}
}
