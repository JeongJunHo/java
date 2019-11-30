package com.ssafy;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Dispatcher {
	private BookDAO dao = new BookDAO();
	JFrame f;
	JPanel pUp;
	JPanel pDown;
	JTextField tfIsbn;
	JTextField tfTitle;
	JTextField tfPublisher;
	JTextField tfPrice;
	JTextField tfDescription;
	JTextField tfSearch;
	JButton bInsert;
	JButton bUpdate;
	JButton bDelete;
	JButton bSearch;
	JList list;

	public Dispatcher() {
		// TODO Auto-generated constructor stub
	}
	
	private void setListData() {
		List<Book> data = dao.listBooks();
		DefaultListModel<Book> model = new DefaultListModel<Book>();
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
				Book book = new Book(tfIsbn.getText(), tfTitle.getText(), tfPublisher.getText(), Integer.parseInt(tfPrice.getText()), tfDescription.getText(), null);
				dao.insertBook(book);
				setListData();
			}
		});
		
		bUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Book book = new Book(tfIsbn.getText(), tfTitle.getText(), tfPublisher.getText(), Integer.parseInt(tfPrice.getText()), tfDescription.getText(), null);
				dao.updateBook(book);
				setListData();
			}
		});
		
		bDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dao.deleteBook(tfIsbn.getText());
				setListData();
			}
		});
		
		bSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfSearch.getText().equals("")) {
					setListData();
				}else {
					Book data = dao.findBook(tfSearch.getText());
					if(data.getIsbn() != null) {
						DefaultListModel<Book> model = new DefaultListModel<Book>();
						model.add(0, data);
						list.setModel(model);
					}else {
						DefaultListModel<Book> model = new DefaultListModel<Book>();
						list.setModel(model);
					}
				}
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(!e.getValueIsAdjusting()) {
					JList list = (JList) e.getSource();
					Book book = (Book) list.getSelectedValue();
					if(book != null) {
						tfIsbn.setText(book.getIsbn());
						tfTitle.setText(book.getTitle());
						tfPublisher.setText(book.getPublisher());
						tfPrice.setText(book.getPrice() + "");
						tfDescription.setText(book.getDescription());
					}
				}
			}
		});
	}
	
	private void createGUI() {
		// TODO Auto-generated method stub
		f = new JFrame("학생관리");
		pUp = new JPanel();
		pDown = new JPanel();
		tfIsbn = new JTextField();
		tfTitle = new JTextField();
		tfPublisher = new JTextField();
		tfPrice = new JTextField();
		tfDescription = new JTextField();
		tfSearch = new JTextField();
		bInsert = new JButton();
		bUpdate = new JButton();
		bDelete = new JButton();
		bSearch = new JButton();
		list = new JList<>();
		
		tfIsbn.setColumns(10);
		tfTitle.setColumns(10);
		tfPublisher.setColumns(10);
		tfPrice.setColumns(10);
		tfDescription.setColumns(10);
		tfSearch.setColumns(10);
		pUp.add(tfIsbn);
		pUp.add(tfTitle);
		pUp.add(tfPublisher);
		pUp.add(tfPrice);
		pUp.add(tfDescription);
		f.add(pUp,BorderLayout.NORTH);
		bInsert.setText("Insert");
		bUpdate.setText("Update");
		bDelete.setText("Delete");
		bSearch.setText("Search");
		pDown.add(bInsert);
		pDown.add(bUpdate);
		pDown.add(bDelete);
		pDown.add(tfSearch);
		pDown.add(bSearch);
		
		f.add(pDown, BorderLayout.SOUTH);
		
		f.add(new JScrollPane(list),BorderLayout.CENTER);
		
		f.setSize(800, 500);
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