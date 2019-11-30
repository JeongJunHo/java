package ws_java_0808_정준호;

import java.util.Scanner;

public class WeatherMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WeatherMain wm = new WeatherMain();
		
		while(true) {
			wm.createGUI();
			int n = sc.nextInt();
			
			switch (n) {
			case 1:
				wm.addEvent();
				break;
			case 2:
				wm.showList();
				break;
			case 3:
				wm.addEvent2();
				break;
			case 4:
				wm.showList2();
				break;
			case 0:
				return;
			}
			
		}
	}
	
	/**
	 * GUI 생성
	 */
	public void createGUI() {
		System.out.println("======================");
		System.out.println("날씨 정보 프로그램입니다.");
		System.out.println("1.XML SAX Parser Start");
		System.out.println("2.SAX Parsing 결과 출력");
		System.out.println("3.XML DOM Parser Start");
		System.out.println("4.DOM Parsing 결과 출력");
		System.out.println("0.종료");
		System.out.println("======================");
	}
	
	/**
	 * XML 파싱 후 날씨 리스트 생성
	 */
	public void addEvent() {
		WeatherDAO wDAO = WeatherDAO.getInstance();
		
		wDAO.connectXML();
		System.out.println("SAX Parser 생성완료");
	}
	
	/**
	 * 리스트 출력
	 */
	public void showList() {
		WeatherDAO wDAO = WeatherDAO.getInstance();
		
		System.out.println("SAX Parser 리스트");
		for (News weather : wDAO.getWeatherList()) {
			System.out.println(weather);
		}
	}
	
	/**
	 * XML 파싱 후 날씨 리스트 생성
	 */
	public void addEvent2() {
		WeatherDAO2 wDAO = WeatherDAO2.getInstance();
		
		wDAO.connectXML();
		System.out.println("DOM Parser 생성완료");
	}
	
	/**
	 * 리스트 출력
	 */
	public void showList2() {
		WeatherDAO2 wDAO = WeatherDAO2.getInstance();
		
		System.out.println("DOM Parser 리스트");
		for (News weather : wDAO.getWeatherList()) {
			System.out.println(weather);
		}
	}	
}
