package com.ssafy.hw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NewsDAODOMImpl implements INewsDAO {
	private List<News> list = new ArrayList<News>();
	private static NewsDAODOMImpl ndd = new NewsDAODOMImpl();

	
	
	private NewsDAODOMImpl() {
		super();
	}
	
	public static NewsDAODOMImpl getInstance() {
		return ndd;
	}

	@Override
	public List<News> getNewsList(String url) {
		// TODO Auto-generated method stub
		list.clear();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser;
		try {
			parser = dbf.newDocumentBuilder();
			Document xmldoc = parser.parse(url);
			Element root = xmldoc.getDocumentElement();
			NodeList nodeList = root.getElementsByTagName("item");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element p = (Element) nodeList.item(i);
				
				News news = new News();
				news.setTitle(p.getElementsByTagName("title").item(0).getFirstChild().getNodeValue());
				news.setLink(p.getElementsByTagName("link").item(0).getFirstChild().getNodeValue());
				news.setDesc(p.getElementsByTagName("description").item(0).getFirstChild().getNodeValue());
				list.add(news);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return list.get(index);
	}
}
