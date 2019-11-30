package edu.ssafy.chap16;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingTest {
	private JList<String> list;
	private JTextField tf;
	private JButton button;
	private JFrame f;
	private DefaultListModel<String> model;
	
	SwingTest(){
		createGUI();
		setData();
		setEvent();
	}
	
	private void setEvent() {
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
		});
//		button.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		button.addActionListener(e -> {
			String text = tf.getText();
			tf.setText("");
			model.addElement(text);
		});
	}
	
	private void setData() {
		model = new DefaultListModel<>();
		model.addElement("Hello");
		list.setModel(model);
	}
	
	private void createGUI() {
		f = new JFrame();
		f.setTitle("MyFirst Swing");
		f.setSize(300,400);
		button = new JButton("버튼");
		tf = new JTextField();
		tf.setColumns(20);
		JPanel p = new JPanel();
		p.add(tf);
		p.add(button);
		list = new JList<String>();
		f.add(list, BorderLayout.CENTER);
		f.add(p,BorderLayout.SOUTH);
		f.setLocation(500, 500);
		
		f.setVisible(true);
	}
	
	void go() {
		
	}
	
	public static void main(String[] args) {
		new SwingTest().go();
	}
}
