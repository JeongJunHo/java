package ws_java_0808_정준호;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ws_java_0808_정준호.WeatherDAO.MyHandler;

public class WeatherDAO2 {
	private List<News> weatherList;
	private static WeatherDAO2 weatherDAO2 = new WeatherDAO2();

	private WeatherDAO2() {
		weatherList = new ArrayList<News>();
	}

	public static WeatherDAO2 getInstance() {
		return weatherDAO2;
	}

	public List<News> getWeatherList() {
		return weatherList;
	}

	public void connectXML() {
		final String URL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2911074000";

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser;
		try {
			parser = dbf.newDocumentBuilder();
			Document xmldoc = parser.parse(URL);
			Element root = xmldoc.getDocumentElement();
			NodeList nodeList = root.getElementsByTagName("data");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element p = (Element) nodeList.item(i);
				
				News weather = new News();
				weather.setHour(Integer.parseInt(p.getElementsByTagName("hour").item(0).getFirstChild().getNodeValue()));
				weather.setTemp(Double.parseDouble(p.getElementsByTagName("temp").item(0).getFirstChild().getNodeValue()));
				weather.setWfKor(p.getElementsByTagName("wfKor").item(0).getFirstChild().getNodeValue());
				weather.setReh(Integer.parseInt(p.getElementsByTagName("reh").item(0).getFirstChild().getNodeValue()));
				weatherList.add(weather);
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

	}
}
