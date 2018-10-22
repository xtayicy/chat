package harry.chat.client.surface;

import harry.chat.client.tool.*;
import harry.chat.common.Message;
import harry.chat.common.MessageType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * @author harry
 *
 */
@SuppressWarnings("serial")
public class Chat extends JFrame implements ActionListener {
	private JTextArea textArea;
	private JTextField textField;
	private JButton button;
	private JPanel panel;
	private String ownerId;
	private String friendId;

	public Chat(String ownerId, String friendId) {
		this.ownerId = ownerId;
		this.friendId = friendId;
		textArea = new JTextArea();
		textField = new JTextField(20);
		button = new JButton("发送");
		button.addActionListener(this);
		panel = new JPanel();

		panel.add(textField);
		panel.add(button);

		add(textArea);
		add(panel, "South");
		setTitle("你正在和" + friendId + "聊天");
		setSize(300, 200);
		setLocation(318, 186);
		setResizable(false);
		setVisible(true);
	}

	public void showMessage(Message message) {
		String content = message.getSender() + "对你说:" + message.getContent() + "\r\n";
		textArea.append(content);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			Message message = new Message();
			message.setMessageType(MessageType.MESSAGE);
			message.setSender(ownerId);
			message.setGetter(friendId);
			message.setContent(textField.getText());
			// message.setDate(new Date().toString);
			try {
				LinkServerThread lst = ManageThread.getLinkServerThread(ownerId);
				ObjectOutputStream oos = new ObjectOutputStream(lst.getSocket().getOutputStream());
				oos.writeObject(message);
				String content = "你对" + friendId + "说:" + textField.getText() + "\r\n";
				textArea.append(content);
				textField.setText("");
			} catch (Exception e2) {
			}
		}
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	@Override
	public String toString() {
		return "Chat [textArea=" + textArea + ", textField=" + textField
				+ ", button=" + button + ", panel=" + panel + ", ownerId="
				+ ownerId + ", friendId=" + friendId + "]";
	}
}
