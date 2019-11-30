package com.ssafy.hw;

import java.util.List;
import java.util.Scanner;

public class NewsMain {
	public static void main(String[] args) {
		String url = "http://rss.etnews.com/Section902.xml";
		Scanner sc = new Scanner(System.in);
		//DOM parser
		NewsDAODOMImpl ndd = NewsDAODOMImpl.getInstance();
		//SAX parser
		NewsDAOSAXImpl nds = NewsDAOSAXImpl.getInstance();
		
		
		while(true) {
			System.out.println("======================");
			System.out.println("뉴스 정보 프로그램입니다.");
			System.out.println("1.SAX Parsing 후 리스트 출력");
			System.out.println("2.SAX Parsing 결과 중 기사 검색");
			System.out.println("3.DOM Parsing 후 리스트 출력");
			System.out.println("4.DOM Parsing 결과 중 기사 검색");
			System.out.println("0.종료");
			System.out.println("======================");
			
			int n = sc.nextInt();
			
			switch (n) {
				case 1:
					for (News news : nds.getNewsList(url)) {
						System.out.println(news);
					}
					break;
				case 2:
					System.out.println("원하는 기사 순서 검색 0번부터");
					System.out.println(nds.search(sc.nextInt()).getDesc());
					break;
				case 3:
					for (News news: ndd.getNewsList(url)) {
						System.out.println(news);
					}
					break;
				case 4:
					System.out.println("원하는 기사 순서 검색 0번부터");
					System.out.println(ndd.search(sc.nextInt()).getDesc());
					break;
				case 0:
					return;
			}
		}
	}
}
