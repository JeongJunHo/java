package com.ssafy.hw;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO {
	private List<News> list = new ArrayList<News>();
	private static NewsDAOSAXImpl nds = new NewsDAOSAXImpl();

	private NewsDAOSAXImpl() {

	}

	public static NewsDAOSAXImpl getInstance() {
		return nds;
	}

	@Override
	public List<News> getNewsList(String url) {
		// TODO Auto-generated method stub
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(new URL(url).openConnection().getInputStream(), handler);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return list.get(index);
	}

	public class SAXHandler extends DefaultHandler {
		private StringBuilder sb;
		News news;

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			super.characters(ch, start, length);
			sb.append(ch, start, length);
		}

		@Override
		public void endElement(String uri, String localName, String name) throws SAXException {
			super.endElement(uri, localName, name);
			if (this.news != null) {
				if (name.equalsIgnoreCase("title")) {
					news.setTitle(sb.toString().trim());
				} else if (name.equalsIgnoreCase("link")) {
					news.setLink(sb.toString().trim());
				} else if (name.equalsIgnoreCase("description")) {
					news.setDesc(sb.toString().trim());
				} else if (name.equalsIgnoreCase("item")) {
					list.add(news);
				}

			}
			sb.setLength(0);
		}

		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			sb = new StringBuilder();
		}

		@Override
		public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
			super.startElement(uri, localName, name, attributes);
			if (name.equalsIgnoreCase("item")) {
				news = new News();
			}
		}
	}
}
