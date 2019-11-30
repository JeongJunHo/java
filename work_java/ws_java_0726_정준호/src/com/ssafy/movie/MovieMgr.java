package com.ssafy.movie;

public class MovieMgr {
	private Movie[] movies = new Movie[100];
	private int index = 0;
	private static MovieMgr mm = new MovieMgr();

	public static MovieMgr getInstance() {
		return mm;
	}
	
	/** 파라메터로 전달된 영화 정보를 전달받아 배열에 저장한다. */
	public void add(Movie m) {
		movies[index] = m;
		index++;
	}
	
	/** 배열에 저장된 모든 영화정보를 리턴한다. */
	public Movie[] search() {
		Movie[] tmp = new Movie[index];
		System.arraycopy(movies, 0, tmp, 0, index);
		return tmp;
	}
	
	/** 파라메터로 전달된 타이틀을 포함하고 있는 모든 영화 정보를 검색하여 리턴한다. */
	public Movie[] search(String title) {
		int cnt = 0;
		Movie[] tmp = new Movie[index];
		for (int i = 0; i < index; i++) {
			if(movies[i].getTitle().contains(title)) {
				tmp[cnt] = movies[i];
				cnt++;
			}
		}
		
		return resize(tmp, cnt);
	}
	
	/** 파라메터로 전달된 감독명의 모든 영화 정보를 검색하여 리턴한다. */
	public Movie[] searchDirector(String name) {
		int cnt = 0;
		Movie[] tmp = new Movie[index];
		for (int i = 0; i < index; i++) {
			if(movies[i].getDirector().equals(name)) {
				tmp[cnt] = movies[i];
				cnt++;
			}
		}
		
		return resize(tmp, cnt);
	}
	
	/** 파라메터로 전달된 장르의 모든 영화 정보를 검색하여 리턴한다. */
	public Movie[] searchGenre(String genre) {
		int cnt = 0;
		Movie[] tmp = new Movie[index];
		for (int i = 0; i < index; i++) {
			if(movies[i].getGenre().equals(genre)) {
				tmp[cnt] = movies[i];
				cnt++;
			}
		}
		
		return resize(tmp, cnt);
	}
	
	/** 파라메터로 전달된 제목의 영화를 삭제한다. */
	public void delete(String title) {
		for (int i = 0; i < index; i++) {
			if(movies[i].getTitle().equals(title)) {
				movies[i] = movies[index-1];
				movies[index-1] = null;
				index--;
			}
		}
	}
	
	/** 저장된 영화 정보의 갯수를 리턴한다. */
	public int getSize() {
		return index;
	}
	
	public Movie[] resize(Movie[] tmp, int cnt) {
		Movie[] result = new Movie[cnt];
		System.arraycopy(tmp, 0, result, 0, cnt);
		
		return result;
	}
}
