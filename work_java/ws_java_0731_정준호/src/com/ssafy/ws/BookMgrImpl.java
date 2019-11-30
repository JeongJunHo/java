package com.ssafy.ws;

import java.util.ArrayList;
import java.util.Calendar;

public class BookMgrImpl implements IBookMgr {
	private static BookMgrImpl bm = new BookMgrImpl();
	private ArrayList<Book> list = new ArrayList<Book>();
	
	public static BookMgrImpl getInstance(){
		return bm;
	}

	@Override
	public void addBook(Book book) {
		list.add(book);
	}

	@Override
	public ArrayList<Book> list() {
		return list;
	}

	@Override
	public ArrayList<Book> searchByNumber(String isbn) {
		ArrayList<Book> tmp = new ArrayList<Book>();
		
		for (Book book : list) {
			if(book.getIsbn().equals(isbn)) {
				tmp.add(book);
			}
		}
		
		return tmp;
	}

	@Override
	public ArrayList<Book> searchByTitle(String title) {
		ArrayList<Book> tmp = new ArrayList<Book>();
		
		for (Book book : list) {
			if(book.getTitle().contains(title)) {
				tmp.add(book);
			}
		}
		
		return tmp;
	}

	@Override
	public ArrayList<Book> onlyBook() {
		ArrayList<Book> tmp = new ArrayList<Book>();
		
		for (Book book : list) {
			if(!(book instanceof Magazine)) {
				tmp.add(book);
			}
		}
		
		return tmp;
	}

	@Override
	public ArrayList<Book> onlyMagazine() {
		ArrayList<Book> tmp = new ArrayList<Book>();
		
		for (Book book : list) {
			if(book instanceof Magazine) {
				tmp.add(book);
			}
		}
		
		return tmp;
	}

	@Override
	public ArrayList<Book> ThisYearMagazine() {
		ArrayList<Book> tmp = new ArrayList<Book>();
		
		for (Book book : list) {
			if(book instanceof Magazine) {
				Magazine m = (Magazine) book;
				int thisYear = Calendar.getInstance().get(Calendar.YEAR);
				if(m.getYear() == thisYear) {
					tmp.add(book);
				}
			}
		}
		
		return tmp;
	}

	@Override
	public ArrayList<Book> searchByPublisher(String publisher) {
		ArrayList<Book> tmp = new ArrayList<Book>();
		
		for (Book book : list) {
			if(book.getPublisher().equals(publisher)) {
				tmp.add(book);
			}
		}
		
		return tmp;
	}

	@Override
	public ArrayList<Book> searchByPrice(int price) {
		ArrayList<Book> tmp = new ArrayList<Book>();
		
		for (Book book : list) {
			if(book.getPrice() <= price) {
				tmp.add(book);
			}
		}
		
		return tmp;
	}

	@Override
	public int totalPrice() {
		int total = 0;
		
		for (Book book : list) {
			total += book.getPrice();
		}
		
		return total;
	}

	@Override
	public float avgPrice() {
		return totalPrice() / list.size();
	}
}
