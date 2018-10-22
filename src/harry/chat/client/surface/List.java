package harry.chat.client.surface;

import harry.chat.client.tool.ManageChat;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;

/**
 * 
 * @author harry
 *
 */
@SuppressWarnings("serial")
public class List extends JFrame implements ActionListener, MouseListener {
	private JPanel panel, panelCenter, panelSouth;
	private JButton btn_panel, btn2_panel, btn3_panel;
	private JScrollPane scrollPane;
	private JLabel[] label;
	private String self;
	private JPanel panelNorth2, panelCenter2, panel2;
	private JButton btn_panel2, btn2_panel2, btn3_panel2;
	private JScrollPane scrollPane2;
	private JLabel[] label2;
	private CardLayout cardLayout;
	
	public List(String ownerId) {
		btn_panel = new JButton("我的好友");
		btn2_panel = new JButton("陌生人");
		btn2_panel.addActionListener(this);
		btn3_panel = new JButton("黑名单");

		panel = new JPanel(new BorderLayout());
		panelCenter = new JPanel(new GridLayout(50, 1, 4, 4));
		label = new JLabel[50];

		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel(i + 1 + "", new ImageIcon("image/dog.jpg"), JLabel.LEFT);
			label[i].setEnabled(false);
			if (label[i].getText().equals(ownerId)) {
				label[i].setEnabled(true);
			}
			label[i].addMouseListener(this);
			panelCenter.add(label[i]);
		}
		panelSouth = new JPanel(new GridLayout(2, 1));
		panelSouth.add(btn2_panel);
		panelSouth.add(btn3_panel);
		scrollPane = new JScrollPane(panelCenter);

		panel.add(btn_panel, "North");
		panel.add(scrollPane, "Center");
		panel.add(panelSouth, "South");

		this.self = ownerId;

		btn_panel2 = new JButton("我的好友");
		btn_panel2.addActionListener(this);
		btn2_panel2 = new JButton("陌生人");
		btn3_panel2 = new JButton("黑名单");

		panel2 = new JPanel(new BorderLayout());
		panelCenter2 = new JPanel(new GridLayout(20, 1, 4, 4));
		label2 = new JLabel[20];

		for (int i = 0; i < label2.length; i++) {
			label2[i] = new JLabel(i + 1 + "", new ImageIcon("image/dog.jpg"), JLabel.LEFT);
			panelCenter2.add(label2[i]);
		}
		panelNorth2 = new JPanel(new GridLayout(2, 1));
		panelNorth2.add(btn_panel2);
		panelNorth2.add(btn2_panel2);
		scrollPane2 = new JScrollPane(panelCenter2);

		panel2.add(panelNorth2, "North");
		panel2.add(scrollPane2, "Center");
		panel2.add(btn3_panel2, "South");

		cardLayout = new CardLayout();

		this.setLayout(cardLayout);
		this.add(panel, "1");
		this.add(panel2, "2");
		this.setTitle(ownerId);
		this.setSize(200, 400);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void showOnLineId(String id) {
		int i = Integer.parseInt(id) - 1;
		label[i].setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn2_panel) {
			cardLayout.show(this.getContentPane(), "2");
		} else if (e.getSource() == btn_panel2) {
			cardLayout.show(this.getContentPane(), "1");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			String strFriendId = ((JLabel) e.getSource()).getText();
			Chat chat = new Chat(self, strFriendId);
			ManageChat.addChat(self + "" + strFriendId, chat);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel label = (JLabel) e.getSource();
		label.setForeground(Color.red);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel label = (JLabel) e.getSource();
		label.setForeground(Color.black);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanelCenter() {
		return panelCenter;
	}

	public void setPanelCenter(JPanel panelCenter) {
		this.panelCenter = panelCenter;
	}

	public JPanel getPanelSouth() {
		return panelSouth;
	}

	public void setPanelSouth(JPanel panelSouth) {
		this.panelSouth = panelSouth;
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

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JLabel[] getLabel() {
		return label;
	}

	public void setLabel(JLabel[] label) {
		this.label = label;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public JPanel getPanelNorth2() {
		return panelNorth2;
	}

	public void setPanelNorth2(JPanel panelNorth2) {
		this.panelNorth2 = panelNorth2;
	}

	public JPanel getPanelCenter2() {
		return panelCenter2;
	}

	public void setPanelCenter2(JPanel panelCenter2) {
		this.panelCenter2 = panelCenter2;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JButton getBtn_panel2() {
		return btn_panel2;
	}

	public void setBtn_panel2(JButton btn_panel2) {
		this.btn_panel2 = btn_panel2;
	}

	public JButton getBtn2_panel2() {
		return btn2_panel2;
	}

	public void setBtn2_panel2(JButton btn2_panel2) {
		this.btn2_panel2 = btn2_panel2;
	}

	public JButton getBtn3_panel2() {
		return btn3_panel2;
	}

	public void setBtn3_panel2(JButton btn3_panel2) {
		this.btn3_panel2 = btn3_panel2;
	}

	public JScrollPane getScrollPane2() {
		return scrollPane2;
	}

	public void setScrollPane2(JScrollPane scrollPane2) {
		this.scrollPane2 = scrollPane2;
	}

	public JLabel[] getLabel2() {
		return label2;
	}

	public void setLabel2(JLabel[] label2) {
		this.label2 = label2;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	@Override
	public String toString() {
		return "List [panel=" + panel + ", panelCenter=" + panelCenter
				+ ", panelSouth=" + panelSouth + ", btn_panel=" + btn_panel
				+ ", btn2_panel=" + btn2_panel + ", btn3_panel=" + btn3_panel
				+ ", scrollPane=" + scrollPane + ", label="
				+ Arrays.toString(label) + ", self=" + self
				+ ", panelNorth2=" + panelNorth2 + ", panelCenter2="
				+ panelCenter2 + ", panel2=" + panel2 + ", btn_panel2="
				+ btn_panel2 + ", btn2_panel2=" + btn2_panel2
				+ ", btn3_panel2=" + btn3_panel2 + ", scrollPane2="
				+ scrollPane2 + ", label2=" + Arrays.toString(label2)
				+ ", cardLayout=" + cardLayout + "]";
	}
}
