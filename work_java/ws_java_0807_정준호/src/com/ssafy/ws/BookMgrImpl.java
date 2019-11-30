package com.ssafy.ws;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class BookMgrImpl implements IBookMgr {
	private class BookClient extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Socket cSocket = null;
			ObjectOutputStream oos = null;
			BufferedReader br = null;
			try {
				cSocket = new Socket("localhost", 7000);
				OutputStream os = cSocket.getOutputStream();
				InputStream is = cSocket.getInputStream();
				oos = new ObjectOutputStream(new BufferedOutputStream(os));
				br = new BufferedReader(new InputStreamReader(is));
				
				oos.writeObject(list);
				oos.flush();
				
				Integer size = Integer.parseInt(br.readLine());
				if(size.equals(list.size())) {
					System.out.println();
					System.out.println("전송확인 완료");
				}else {
					System.out.println();
					System.out.println("전송 오류");
				}
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					cSocket.close();
					oos.close();
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private static BookMgrImpl bm = new BookMgrImpl();
	private ArrayList<Book> list;
	/**
	 * 필터링한 데이터 반환용 리스트
	 */
	ArrayList<Book> resultList = new ArrayList<Book>();
	
	/**
	 * singleton을 위한 접근제한
	 */
	private BookMgrImpl() {
		list = new ArrayList<Book>();
		try {
			open();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력 에러가 발생했습니다.");
		}
	}

	public static BookMgrImpl getInstance(){
		return bm;
	}

	@Override
	public void add(Book book) {
		list.add(book);
	}

	@Override
	public ArrayList<Book> search() {
		return list;
	}

	@Override
	public ArrayList<Book> searchByNumber(String isbn) {
		//데이터 소거
		resultList.clear();
		
		for (Book book : list) {
			if(book.getIsbn().equals(isbn)) {
				resultList.add(book);
			}
		}
		
		return resultList;
	}

	@Override
	public ArrayList<Book> searchByTitle(String title) {
		//데이터 소거
		resultList.clear();
		
		for (Book book : list) {
			if(book.getTitle().contains(title)) {
				resultList.add(book);
			}
		}
		
		return resultList;
	}

	@Override
	public ArrayList<Book> onlyBook() {
		//데이터 소거
		resultList.clear();
		
		for (Book book : list) {
			if(!(book instanceof Magazine)) {
				resultList.add(book);
			}
		}
		
		return resultList;
	}

	@Override
	public ArrayList<Book> onlyMagazine() {
		//데이터 소거
		resultList.clear();
		
		for (Book book : list) {
			if(book instanceof Magazine) {
				resultList.add(book);
			}
		}
		
		return resultList;
	}

	@Override
	public ArrayList<Book> searchByPrice(int price) {
		//데이터 소거
		resultList.clear();
		
		for (Book book : list) {
			if(book.getPrice() <= price) {
				resultList.add(book);
			}
		}
		
		return resultList;
	}

	@Override
	public int getTotalAmount() {
		int total = 0;
		
		for (Book book : list) {
			total += book.getPrice();
		}
		
		return total;
	}

	@Override
	public float avgPrice() {
		return getTotalAmount() / list.size();
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		boolean tmp = false;
		
		for (Book book : list) {
			//책번호가 같다면
			if(book.getIsbn().equals(isbn)) {
				//책을 찾았다면 true
				tmp = true;
				//판매 후 책 수량
				int stock = book.getQuantity()-quantity;
				//팔았을 경우 책 수량이 0보다 적어진다면 예외 발생
				if(stock < 0) {
					throw new QuantityException();
				//정상 수치라면 적용
				}else {
					book.setQuantity(stock);
				}
			}
		}

		//검색된 책이 없다면
		if(tmp == false) {
			throw new ISBNNotFoundException();
		}
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		boolean tmp = false;
		
		for (Book book : list) {
			//책번호가 같다면
			if(book.getIsbn().equals(isbn)) {
				//책을 찾았다면 true
				tmp = true;
				//현재 수량에 구매수량을 합하여 적용
				book.setQuantity(book.getQuantity() + quantity);
			}
		}
		
		//검색된 책이 없다면
		if(tmp == false) {
			throw new ISBNNotFoundException();
		}
	}

	@Override
	public void open() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.dat"));
		list = (ArrayList<Book>) ois.readObject();
		ois.close();
	}

	@Override
	public void close() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat"));
		oos.writeObject(list);
		oos.flush();
		oos.close();
	}

	@Override
	public void send() {
		// TODO Auto-generated method stub
		new BookClient().start();
	}
}
