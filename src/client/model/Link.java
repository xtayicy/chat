package client.model;

import java.io.*;
import java.net.*;

import client.tool.*;
import common.*;

/**
 * 
 * @author harry
 *
 */
public class Link {
	public Socket socket;

	public boolean send(Object o) {
		try {
			Socket socket = new Socket("127.0.0.1", 9999);
			this.socket = socket;

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(o);

			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			Message message = (Message) objectInputStream.readObject();

			if (message.getMessageType().equals("1")) {
				LinkServerThread lst = new LinkServerThread(socket);
				lst.start();
				ManageThread.addLinkServerThread(((User) o).getUserId(), lst);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
