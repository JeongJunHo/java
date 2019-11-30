package com.ssafy.hw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		
		return resultList;
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
		
		return resultList;
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
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("product.dat"));
			oos.writeObject(map);
			oos.flush();
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
}
