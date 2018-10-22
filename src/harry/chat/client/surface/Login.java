package harry.chat.client.surface;

import harry.chat.client.model.*;
import harry.chat.client.tool.*;
import harry.chat.common.Message;
import harry.chat.common.MessageType;
import harry.chat.common.User;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.*;

/**
 * 
 * @author harry
 *
 */
@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {
	private JLabel label;
	private JTabbedPane tabbedPane;
	private JPanel panelLeft, panelMid, panelRight;
	private JLabel label_panelLeft, label2_panelLeft, label3_panelLeft, label4_panelLeft;
	private JButton btn_panelLeft;
	private JTextField textField_panelLeft;
	private JPasswordField passwordField_panelLeft;
	private JCheckBox checkBox_panelLeft, checkBox2_panelLeft;
	private JPanel panel;
	private JButton btn_panel, btn2_panel, btn3_panel;

	public static void main(String[] args) {
		new Login();
	}

	public Login() {
		label = new JLabel(new ImageIcon("image/banner01.gif"));

		panelLeft = new JPanel(new GridLayout(3, 3));
		label_panelLeft = new JLabel("QQ号码", JLabel.CENTER);
		label2_panelLeft = new JLabel("QQ密码", JLabel.CENTER);
		label3_panelLeft = new JLabel("忘记密码", JLabel.CENTER);
		label3_panelLeft.setForeground(Color.blue);
		label4_panelLeft = new JLabel("申请密码保护", JLabel.CENTER);
		btn_panelLeft = new JButton("清除");
		textField_panelLeft = new JTextField();
		passwordField_panelLeft = new JPasswordField();
		checkBox_panelLeft = new JCheckBox("隐身登录");
		checkBox2_panelLeft = new JCheckBox("记住密码");
		panelLeft.add(label_panelLeft);
		panelLeft.add(textField_panelLeft);
		panelLeft.add(btn_panelLeft);
		panelLeft.add(label2_panelLeft);
		panelLeft.add(passwordField_panelLeft);
		panelLeft.add(label3_panelLeft);
		panelLeft.add(checkBox_panelLeft);
		panelLeft.add(checkBox2_panelLeft);
		panelLeft.add(label4_panelLeft);

		tabbedPane = new JTabbedPane();
		tabbedPane.add("QQ号码", panelLeft);
		panelMid = new JPanel();
		tabbedPane.add("手机号码", panelMid);
		panelRight = new JPanel();
		tabbedPane.add("电子邮件", panelRight);

		panel = new JPanel();
		btn_panel = new JButton("登录");
		btn_panel.addActionListener(this);
		btn2_panel = new JButton("取消");
		btn3_panel = new JButton("向导");
		panel.add(btn_panel);
		panel.add(btn2_panel);
		panel.add(btn3_panel);

		this.add(label, "North");
		this.add(tabbedPane, "Center");
		this.add(panel, "South");

		this.setTitle("用户登录");
		this.setSize(351, 240);
		this.setLocation(300, 280);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_panel) {
			Authentication authentication = new Authentication();
			User user = new User();
			String userId = textField_panelLeft.getText().trim();
			user.setUserId(userId);
			user.setPassword(new String(passwordField_panelLeft.getPassword()));

			if (authentication.checkUser(user)) {
				List list = new List(user.getUserId());
				ManageList.addList(userId, list);
				Socket socket = ManageThread.getLinkServerThread(userId).getSocket();
				try {
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					Message message = new Message();
					message.setMessageType(MessageType.MESSAGE_GET_ONLINEFRIEND);
					message.setSender(userId);
					oos.writeObject(message);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "用户名或密码错误");
			}
		}
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	public JPanel getPanelLeft() {
		return panelLeft;
	}

	public void setPanelLeft(JPanel panelLeft) {
		this.panelLeft = panelLeft;
	}

	public JPanel getPanelMid() {
		return panelMid;
	}

	public void setPanelMid(JPanel panelMid) {
		this.panelMid = panelMid;
	}

	public JPanel getPanelRight() {
		return panelRight;
	}

	public void setPanelRight(JPanel panelRight) {
		this.panelRight = panelRight;
	}

	public JLabel getLabel_panelLeft() {
		return label_panelLeft;
	}

	public void setLabel_panelLeft(JLabel label_panelLeft) {
		this.label_panelLeft = label_panelLeft;
	}

	public JLabel getLabel2_panelLeft() {
		return label2_panelLeft;
	}

	public void setLabel2_panelLeft(JLabel label2_panelLeft) {
		this.label2_panelLeft = label2_panelLeft;
	}

	public JLabel getLabel3_panelLeft() {
		return label3_panelLeft;
	}

	public void setLabel3_panelLeft(JLabel label3_panelLeft) {
		this.label3_panelLeft = label3_panelLeft;
	}

	public JLabel getLabel4_panelLeft() {
		return label4_panelLeft;
	}

	public void setLabel4_panelLeft(JLabel label4_panelLeft) {
		this.label4_panelLeft = label4_panelLeft;
	}

	public JButton getBtn_panelLeft() {
		return btn_panelLeft;
	}

	public void setBtn_panelLeft(JButton btn_panelLeft) {
		this.btn_panelLeft = btn_panelLeft;
	}

	public JTextField getTextField_panelLeft() {
		return textField_panelLeft;
	}

	public void setTextField_panelLeft(JTextField textField_panelLeft) {
		this.textField_panelLeft = textField_panelLeft;
	}

	public JPasswordField getPasswordField_panelLeft() {
		return passwordField_panelLeft;
	}

	public void setPasswordField_panelLeft(JPasswordField passwordField_panelLeft) {
		this.passwordField_panelLeft = passwordField_panelLeft;
	}

	public JCheckBox getCheckBox_panelLeft() {
		return checkBox_panelLeft;
	}

	public void setCheckBox_panelLeft(JCheckBox checkBox_panelLeft) {
		this.checkBox_panelLeft = checkBox_panelLeft;
	}

	public JCheckBox getCheckBox2_panelLeft() {
		return checkBox2_panelLeft;
	}

	public void setCheckBox2_panelLeft(JCheckBox checkBox2_panelLeft) {
		this.checkBox2_panelLeft = checkBox2_panelLeft;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getBtn_panel() {
		return btn_panel;
	}

	public void setBtn_panel(JButton btn_panel) {
		this.btn_panel = btn_panel;
	}

	public JButton getBtn2_panel() {
		return btn2_panel;
	}

	public void setBtn2_panel(JButton btn2_panel) {
		this.btn2_panel = btn2_panel;
	}

	public JButton getBtn3_panel() {
		return btn3_panel;
	}

	public void setBtn3_panel(JButton btn3_panel) {
		this.btn3_panel = btn3_panel;
	}

	@Override
	public String toString() {
		return "Login [label=" + label + ", tabbedPane=" + tabbedPane
				+ ", panelLeft=" + panelLeft + ", panelMid=" + panelMid
				+ ", panelRight=" + panelRight + ", label_panelLeft="
				+ label_panelLeft + ", label2_panelLeft=" + label2_panelLeft
				+ ", label3_panelLeft=" + label3_panelLeft
				+ ", label4_panelLeft=" + label4_panelLeft + ", btn_panelLeft="
				+ btn_panelLeft + ", textField_panelLeft="
				+ textField_panelLeft + ", passwordField_panelLeft="
				+ passwordField_panelLeft + ", checkBox_panelLeft="
				+ checkBox_panelLeft + ", checkBox2_panelLeft="
				+ checkBox2_panelLeft + ", panel=" + panel + ", btn_panel="
				+ btn_panel + ", btn2_panel=" + btn2_panel + ", btn3_panel="
				+ btn3_panel + "]";
	}
}
