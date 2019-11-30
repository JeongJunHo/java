package com.ssafy.hw;

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
import java.util.Collections;
import java.util.HashMap;

public class ProductMgrImpl implements IProductMgr {
	private HashMap<String,Product> map;
	private static ProductMgrImpl pm = new ProductMgrImpl();
	//필터링 후 반환용 리스트
	ArrayList<Product> resultList = new ArrayList<Product>();
	
	private ProductMgrImpl() {
		map = new HashMap<String,Product>();
		load();
	}

	public static ProductMgrImpl getInstance() {
		return pm;
	}
	
	@Override
	public void addProduct(Product product) throws DuplicateException {
		if(map.get(product.getCode()) != null) {
			throw new DuplicateException();
		}else {
			map.put(product.getCode(), product);
		}
	}
	

	@Override
	public ArrayList<Product> list() throws ProductNotFoundException {
		if(map.size() == 0) {
			throw new ProductNotFoundException();
		}
		
		//초기화
		resultList.clear();
		
		resultList.addAll(map.values());
		//정렬
		Collections.sort(resultList);
		
		return resultList;
	}

	@Override
	public Product searchByCode(String code) throws CodeNotFoundException {
		Product p = map.get(code);
		if(p == null) {
			throw new CodeNotFoundException();
		}
		
		return p;
	}

	@Override
	public ArrayList<Product> searchByName(String name) throws ProductNotFoundException {
		//초기화
		resultList.clear();
		
		for (Product product : map.values()) {
			if(product.getName().contains(name)) {
				resultList.add(product);
			}
		}
		
		if(resultList.size() == 0) {
			throw new ProductNotFoundException();
		}
		
		//정렬
		Collections.sort(resultList);
		
		return resultList;
	}

	@Override
	public ArrayList<Product> searchByName(String name, int price) throws ProductNotFoundException {
		//초기화
		resultList.clear();
		
		for (Product product : map.values()) {
			if(product.getName().contains(name) && product.getPrice() <= price) {
				resultList.add(product);
			}
		}
		
		if(resultList.size() == 0) {
			throw new ProductNotFoundException();
		}
		
		//정렬
		Collections.sort(resultList);
		
		return resultList;
	}

	@Override
	public ArrayList<Product> tvList() throws ProductNotFoundException {
		//초기화
		resultList.clear();
		
		for (Product product : map.values()) {
			if(product instanceof TV) {
				resultList.add(product);
			}
		}
		
		if(resultList.size() == 0) {
			throw new ProductNotFoundException();
		}
		
		//정렬
		Collections.sort(resultList);
		
		ArrayList<Product> tmp = new ArrayList<Product>();
		tmp.addAll(resultList);
		
		return tmp;
	}

	@Override
	public ArrayList<Product> refrigeratorList() throws ProductNotFoundException {
		//초기화
		resultList.clear();
		
		for (Product product : map.values()) {
			if(product instanceof Refrigerator) {
				resultList.add(product);
			}
		}
		
		if(resultList.size() == 0) {
			throw new ProductNotFoundException();
		}
		
		//정렬
		Collections.sort(resultList);
		
		ArrayList<Product> tmp = new ArrayList<Product>();
		tmp.addAll(resultList);
		
		return tmp;
	}

	@Override
	public ArrayList<Product> over400Lrefrigerator() throws ProductNotFoundException {
		//초기화
		resultList.clear();
		
		for (Product product : map.values()) {
			if(product instanceof Refrigerator) {
				if(((Refrigerator) product).getLiter() >= 400) {
					resultList.add(product);
				}
			}
		}
		
		if (resultList.size() == 0) {
			throw new ProductNotFoundException();
		}
		
		//정렬
		Collections.sort(resultList);
		
		return resultList;
	}

	@Override
	public ArrayList<Product> over50InchTV() throws ProductNotFoundException {
		//초기화
		resultList.clear();
		
		for (Product product : map.values()) {
			if(product instanceof TV) {
				if(((TV) product).getInch() >= 50) {
					resultList.add(product);	
				}
			}
		}
		
		if (resultList.size() == 0) {
			throw new ProductNotFoundException();
		}
		
		//정렬
		Collections.sort(resultList);
		
		return resultList;
	}

	@Override
	public void updatePrice(String code, int price) throws CodeNotFoundException {
		Product p = map.get(code);
		
		if(p == null) {
			throw new CodeNotFoundException();
		}else {
			p.setPrice(price);
		}
	}

	@Override
	public void delete(String code) throws CodeNotFoundException {
		Product p = map.get(code);
		
		if(p == null) {
			throw new CodeNotFoundException();
		}else {
			map.remove(code);
		}
	}

	@Override
	public int totalPrice() {
		int total = 0;
		for (Product product : map.values()) {
			int tmp = product.getStock() * product.getPrice();
			total += tmp;
		}
		
		return total;
	}

	@Override
	public void save() {
		new SaveThread().start();
	}

	@Override
	public void load(){
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("product.dat"));
			try {
				map = (HashMap<String,Product>)ois.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println("클래스를 찾을 수 없습니다. 제품 불러오기 실패");
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("입출력 오류. 제품 불러오기 실패");
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				System.out.println("입출력 오류. 닫기 실패");				
			}
		}
		
		
	}

	@Override
	public void send() {
		// TODO Auto-generated method stub
		new SendThread().start();
	}
	
	private class SaveThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(new FileOutputStream("product.dat"));
				synchronized(map) {
					oos.writeObject(map);
				}
				oos.flush();
				System.out.println("저장완료");
			} catch (FileNotFoundException e) {
				System.out.println("파일을 찾을 수 없습니다. 제품 저장 실패");
			} catch (IOException e) {
				System.out.println("입출력 오류. 제품 저장 실패");
				
			} finally {
				try {
					if(oos != null) {
						oos.close();
					}
				} catch (IOException e) {
					System.out.println("입출력 오류. 닫기 실패");
				}
			}
		}
	}
	
	private class SendThread extends Thread {
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
				
				ArrayList<Product> productList = tvList();
				productList.addAll(refrigeratorList());
				oos.writeObject(productList);
				oos.flush();
				
				System.out.println();
				System.out.println(br.readLine() + "개");
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ProductNotFoundException e) {
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
}
