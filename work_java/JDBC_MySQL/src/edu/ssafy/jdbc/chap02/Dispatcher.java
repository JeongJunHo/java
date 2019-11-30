package edu.ssafy.jdbc.chap02;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Dispatcher {
	private DBManager man = new DBManager();

	public Dispatcher() {
		// TODO Auto-generated constructor stub
	}
	
	private void setListData() {
		ArrayList<Student> data = man.queryStudent();
		DefaultListModel<Student> model = new DefaultListModel<>();
		for (int i = 0; i < data.size(); i++) {
			model.add(i, data.get(i));
		}
		list.setModel(model);
	}
	
	private void setEvent() {
		// TODO Auto-generated method stub
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
		});
		
		bInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				man.insertStudent(Integer.parseInt(tfHak.getText()), tfName.getText(), tfGender.getText(), null);
				setListData();
			}
		});
		
		bUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				man.updateStudent(Integer.parseInt(tfHak.getText()), tfName.getText(), tfGender.getText(), null);
				setListData();
			}
		});
		
		bDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				man.deleteStudent(Integer.parseInt(tfHak.getText()));
				setListData();
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
//				System.out.println(e.getFirstIndex());
//				System.out.println(e.getLastIndex());
//				System.out.println(e.getSource());
//				System.out.println(e.getValueIsAdjusting());
				
				if(!e.getValueIsAdjusting()) {
					JList list = (JList) e.getSource();
					Student s = (Student) list.getSelectedValue();
					if(s != null) {
						tfHak.setText(s.getHakbun() + "");
						tfName.setText(s.getName());
						tfGender.setText(s.getGender());
					}
				}
			}
		});
	}

	JFrame f;
	JPanel pUp;
	JPanel pDown;
	JTextField tfHak;
	JTextField tfName;
	JTextField tfGender;
	JButton bInsert;
	JButton bUpdate;
	JButton bDelete;
	JList list;
	
	private void createGUI() {
		// TODO Auto-generated method stub
		f = new JFrame("학생관리");
		pUp = new JPanel();
		pDown = new JPanel();
		tfHak = new JTextField();
		tfName = new JTextField();
		tfGender = new JTextField();
		bInsert = new JButton();
		bUpdate = new JButton();
		bDelete = new JButton();
		list = new JList<>();
		
		tfHak.setColumns(10);
		tfName.setColumns(10);
		tfGender.setColumns(10);
		pUp.add(tfHak);
		pUp.add(tfName);
		pUp.add(tfGender);
		f.add(pUp,BorderLayout.NORTH);
		bInsert.setText("Insert");
		bUpdate.setText("Update");
		bDelete.setText("Delete");
		pDown.add(bInsert);
		pDown.add(bUpdate);
		pDown.add(bDelete);
		f.add(pDown, BorderLayout.SOUTH);
		
		f.add(new JScrollPane(list),BorderLayout.CENTER);
		
		f.setSize(500, 500);
		f.setLocation(200, 300);
		f.setVisible(true);
	}

	private void go() {
		// TODO Auto-generated method stub
		createGUI();
		setListData();
		setEvent();
	}
	
	public static void main(String[] args) {
		new Dispatcher().go();
	}
}
