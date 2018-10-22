package harry.chat.server.surface;

import harry.chat.server.pattern.*;

import java.awt.event.*;

import javax.swing.*;

public class Surface extends JFrame implements ActionListener{
	JPanel panel;
	JButton btnOpen,btnShut;
	
	public static void main(String[] args){
		new Surface();
	}
	
	public Surface() {
		panel=new JPanel();
		btnOpen=new JButton("启动服务器");
		btnOpen.addActionListener(this);
		btnShut=new JButton("关闭服务器");
		
		panel.add(btnOpen);
		panel.add(btnShut);
		
		this.add(panel);
		this.setTitle("服务器端");
		this.setSize(186, 168);
		this.setLocation(318, 186);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnOpen){
			new Service();
		}
	}
}
