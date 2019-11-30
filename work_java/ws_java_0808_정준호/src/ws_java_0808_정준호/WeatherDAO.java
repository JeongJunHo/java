package ws_java_0808_정준호;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherDAO {
	private List<News> weatherList;
	private static WeatherDAO weatherDAO = new WeatherDAO();
	
	private WeatherDAO() {
		weatherList = new ArrayList<News>();
	}
	
	public static WeatherDAO getInstance() {
		return weatherDAO;
	}

	public List<News> getWeatherList() {
		return weatherList;
	}
	
	public void connectXML() {
		final String URL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2911074000";
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			MyHandler handler = new MyHandler();
			parser.parse(new URL(URL).openConnection().getInputStream(), handler);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public class MyHandler extends DefaultHandler{
		private StringBuilder sb;
		News weather;
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			super.characters(ch, start, length);
			sb.append(ch, start, length);
		}
		@Override
		public void endElement(String uri, String localName, String name)
				throws SAXException {
			super.endElement(uri, localName, name);
			if (this.weather != null){
				if (name.equalsIgnoreCase("hour")){
					weather.setHour(Integer.parseInt(sb.toString().trim()));
				} else if (name.equalsIgnoreCase("temp")){
					weather.setTemp(Double.parseDouble(sb.toString().trim()));
				} else if (name.equalsIgnoreCase("wfKor")){
					weather.setWfKor(sb.toString().trim());
				} else if (name.equalsIgnoreCase("reh")){
					weather.setReh(Integer.parseInt(sb.toString().trim()));
				} else if (name.equalsIgnoreCase("data")){
				     weatherList.add(weather);
				}
			}
			sb.setLength(0);
		}
		@Override
		public void startDocument() throws SAXException {
			super.startDocument();
			weatherList = new ArrayList<News>();
			sb = new StringBuilder();
		}
		@Override
		public void startElement(String uri, String localName, String name,
				Attributes attributes) throws SAXException {
			super.startElement(uri, localName, name, attributes);
			if (name.equalsIgnoreCase("data")){
				weather = new News();
			}
		}
	}
}
