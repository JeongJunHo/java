package com.ssafy.hw;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductMgrImpl implements IProductMgr {
	private HashMap<String,Product> map = new HashMap<String,Product>();
	private static ProductMgrImpl pm = new ProductMgrImpl();

	public static ProductMgrImpl getInstance() {
		return pm;
	}
	
	@Override
	public void addProduct(Product product) {
		map.put(product.getCode(), product);
	}

	@Override
	public ArrayList<Product> list() {
		ArrayList<Product> tmp = new ArrayList<Product>();
		tmp.addAll(map.values());
		return tmp;
	}

	@Override
	public Product searchByCode(String code) {
		
		return map.get(code);
	}

	@Override
	public ArrayList<Product> searchByName(String name) {
		ArrayList<Product> tmp = new ArrayList<Product>();
		
		for (Product product : map.values()) {
			if(product.getName().contains(name)) {
				tmp.add(product);
			}
		}
		
		return tmp;
	}

	@Override
	public ArrayList<Product> searchByName(String name, int price) {
		ArrayList<Product> tmp = new ArrayList<Product>();
		
		for (Product product : map.values()) {
			if(product.getName().contains(name) && product.getPrice() <= price) {
				tmp.add(product);
			}
		}
		
		return tmp;
	}

	@Override
	public ArrayList<Product> tvList() {
		ArrayList<Product> tmp = new ArrayList<Product>();
		
		for (Product product : map.values()) {
			if(product instanceof TV) {
				tmp.add(product);
			}
		}
		
		return tmp;
	}

	@Override
	public ArrayList<Product> refrigeratorList() {
		ArrayList<Product> tmp = new ArrayList<Product>();
		
		for (Product product : map.values()) {
			if(product instanceof Refrigerator) {
				tmp.add(product);
			}
		}
		
		return tmp;
	}

	@Override
	public ArrayList<Product> over400Lrefrigerator() {
		ArrayList<Product> tmp = new ArrayList<Product>();
		
		for (Product product : map.values()) {
			if(product instanceof Refrigerator) {
				if(((Refrigerator) product).getLiter() >= 400) {
					tmp.add(product);	
				}
			}
		}
		
		return tmp;
	}

	@Override
	public ArrayList<Product> over50InchTV() {
		ArrayList<Product> tmp = new ArrayList<Product>();
		
		for (Product product : map.values()) {
			if(product instanceof TV) {
				if(((TV) product).getInch() >= 50) {
					tmp.add(product);	
				}
			}
		}
		
		return tmp;
	}

	@Override
	public void updatePrice(String code, int price) {
		Product p = map.get(code);
		p.setPrice(price);
	}

	@Override
	public void delete(String code) {
		map.remove(code);
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
	
}
