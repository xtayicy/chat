package server.pattern;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

import common.Message;
import common.MessageType;

/**
 * 
 * @author harry
 *
 */
public class ServerClientThread extends Thread {
	Socket socket;

	public ServerClientThread(Socket socket) {
		this.socket = socket;
	}
	
	public void report(String content){
		HashMap<String, ServerClientThread> hm = ManageThread.hm;
		Iterator<String> it = hm.keySet().iterator();
		
		while(it.hasNext()){
			Message message = new Message();
			message.setContent(content);
			message.setMessageType(MessageType.MESSAGE_RETURN_ONLINEFRIEND);
			String onLineId = it.next().toString();
			
			ServerClientThread sct = ManageThread.getThread(onLineId);
			try {
				ObjectOutputStream oos = new ObjectOutputStream(sct.socket.getOutputStream());
				message.setGetter(onLineId);
				oos.writeObject(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		while(true){
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Message message = (Message) ois.readObject();
				
				if(message.getMessageType().equals(MessageType.MESSAGE)){
					message.setMessageType(MessageType.MESSAGE);
					//System.out.println(message.getSender() + "��" + message.getGetter() + "˵:" + message.getContent());
					ServerClientThread sct = ManageThread.getThread(message.getGetter());
					ObjectOutputStream oos = new ObjectOutputStream(sct.socket.getOutputStream());
					oos.writeObject(message);
				}else if(message.getMessageType().equals(MessageType.MESSAGE_GET_ONLINEFRIEND)){
					String sender = message.getSender();
					String onLineId = ManageThread.getOnLineId();
					//System.out.println(onLineId);
					Message message2 = new Message();
					message2.setMessageType(MessageType.MESSAGE_RETURN_ONLINEFRIEND);
					message2.setGetter(sender);
					message2.setContent(onLineId);
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(message2);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
