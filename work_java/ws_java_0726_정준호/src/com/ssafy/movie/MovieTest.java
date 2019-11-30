package com.ssafy.movie;

import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {
		MovieMgr mm = MovieMgr.getInstance();
		
		while (true) {
			System.out.println("<<< 영화 관리 프로그램 >>>");
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영화 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 영화 장르별 검색");
			System.out.println("5. 영화 정보 삭제");
			System.out.println("0. 종료");
			System.out.print("원하는 번호를 선택하세요.");
			
			Scanner sc = new Scanner(System.in);
			
			int select = sc.nextInt();
			sc.nextLine();
			
			//영화 정보 입력
			if(select == 1) {
				System.out.println("영화 정보 입력");
				System.out.print("영화제목 : ");
				String title = sc.nextLine();
				System.out.print("감독 : ");
				String director = sc.next();
				System.out.print("평점 : ");
				int grade = sc.nextInt();
				sc.nextLine();
				System.out.print("장르 : ");
				String genre = sc.next();
				sc.nextLine();
				System.out.print("개요 : ");
				String summary = sc.nextLine();
				
				mm.add(new Movie(title,director,grade,genre,summary));
			//영화 정보 전체 검색
			}else if (select == 2) {
				System.out.println("영화 리스트");
				Movie[] tmp = mm.search();
				for (Movie movie : tmp) {
					System.out.println(movie.toString());
				}
				if(tmp.length == 0) {
					System.out.println("찾는정보와 일치하는 영화가 없습니다.");
				}
				System.out.println();
			//영화명 검색
			}else if (select == 3) {
				System.out.print("영화명 검색 : ");
				Movie[] tmp = mm.search(sc.next());
				for (Movie movie : tmp) {
					System.out.println(movie.toString());
				}
				if(tmp.length == 0) {
					System.out.println("찾는정보와 일치하는 영화가 없습니다.");
				}
				System.out.println();
			//영화 장르별 검색
			}else if (select == 4) {
				System.out.print("영화 장르별 검색 : ");
				Movie[] tmp = mm.searchGenre(sc.next());
				for (Movie movie : tmp) {
					System.out.println(movie.toString());
				}
				if(tmp.length == 0) {
					System.out.println("찾는정보와 일치하는 영화가 없습니다.");
				}
				System.out.println();
			//영화 정보 삭제
			}else if (select == 5) {
				System.out.print("영화 삭제(영화제목) : ");
				mm.delete(sc.next());
				System.out.println();
			//종료
			}else if (select == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
