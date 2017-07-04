package server.surface;

import java.awt.event.*;
import javax.swing.*;
import server.pattern.*;

public class Surface extends JFrame implements ActionListener{
	JPanel panel;
	JButton btnOpen,btnShut;
	
	public static void main(String[] args){
		new Surface();
	}
	
	public Surface() {
		panel=new JPanel();
		btnOpen=new JButton("����������");
		btnOpen.addActionListener(this);
		btnShut=new JButton("�رշ�����");
		
		panel.add(btnOpen);
		panel.add(btnShut);
		
		this.add(panel);
		this.setTitle("��������");
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
