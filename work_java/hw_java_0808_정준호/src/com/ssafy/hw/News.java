package com.ssafy.hw;

public class News {
	private String title;
	private String desc;
	private String link;
	
	public News() {
		super();
	}
	/**
	 * @param title
	 * @param desc
	 * @param link
	 */
	public News(String title, String desc, String link) {
		super();
		this.title = title;
		this.desc = desc;
		this.link = link;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "News [title=" + title + ", desc=" + desc + ", link=" + link + "]";
	}
}
