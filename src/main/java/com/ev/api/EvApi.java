package com.ev.api;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.Timestamp;
import java.util.*;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.text.html.parser.AttributeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.format.datetime.joda.DateTimeParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ev.vo.ApiVO;

import java.io.BufferedReader;
import java.io.IOException;

public class EvApi {
	
	    // tag값의 정보를 가져오는 메소드
		private static String getTagValue(String tag, Element eElement) {
		    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		    Node nValue = (Node) nlList.item(0);
		    if(nValue == null) 
		        return null;
		    return nValue.getNodeValue();
		}
	
	public static List<ApiVO> api() throws IOException   {
		int page = 1;	// 페이지 초기값 
		List<ApiVO> list = new ArrayList<ApiVO>();
		
		
		try{
			while(true){
		StringBuilder urlBuilder = new StringBuilder("http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "="+ URLEncoder.encode("hR8kBsu86Cx0xEumFWONu1zyZtg5876w2yHXlDFo2uaxH1SDhxUDUidyLerffwqMs8QFLT5ZbDQ57KeUYI2RLg==","UTF-8")); /* 공공데이터포털에서 받은 인증키 */
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + page); /* 페이지번호 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1500", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + URLEncoder.encode("addr", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* 검색대상 충전소주소 */
		
		String url = urlBuilder.toString();
		
		/* -------필요없음 ---------
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		
		System.out.println("Response code: " + conn.getResponseCode());
		
		BufferedReader rd;
		 */
		
		DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
		Document doc = dBuilder.parse(url);
		
		// root tag 
		doc.getDocumentElement().normalize();
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		
		// 파싱할 tag
		NodeList nList = doc.getElementsByTagName("item");
		//System.out.println("파싱할 리스트 수 : "+ nList.getLength());
		
		System.out.println("");

		
		for(int temp = 0; temp < nList.getLength(); temp++){
			
			ApiVO vo = new ApiVO();
			
			Node nNode = nList.item(temp);
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE){
				
				Element eElement = (Element) nNode;
				System.out.println("######################");
				//System.out.println(eElement.getTextContent());
				System.out.println("주소  : " + getTagValue("addr", eElement));
				System.out.println("충전기 타입  : " + getTagValue("chargeTp", eElement));
				System.out.println("충전기 ID : " + getTagValue("cpId", eElement));
				System.out.println("충전기 명칭  : " + getTagValue("cpNm", eElement));
				System.out.println("충전기 상태  : " + getTagValue("cpStat", eElement));
				System.out.println("충전 방식  : " + getTagValue("cpTp", eElement));
				System.out.println("충전소 ID  : " + getTagValue("csId", eElement));
				System.out.println("충전소 명칭  : " + getTagValue("csNm", eElement));
				System.out.println("위도  : " + getTagValue("lat", eElement));
				System.out.println("경도  : " + getTagValue("longi", eElement));
				System.out.println("충전기 갱신  : " + getTagValue("statUpdateDatetime", eElement));
				
				vo.setAddr(getTagValue("addr", eElement));
				vo.setC_tp(Integer.parseInt(getTagValue("chargeTp", eElement)));
				vo.setCp_id(Integer.parseInt(getTagValue("cpId", eElement)));
				vo.setCp_nm(getTagValue("cpNm", eElement));
				vo.setCp_stat(Integer.parseInt(getTagValue("cpStat", eElement)));
				vo.setCp_tp(Integer.parseInt(getTagValue("cpTp", eElement)));
				vo.setCs_id(Integer.parseInt(getTagValue("csId", eElement)));
				vo.setCs_nm(getTagValue("csNm", eElement));
				vo.setLat(Float.parseFloat(getTagValue("lat", eElement)));
				vo.setLongi(Float.parseFloat(getTagValue("longi", eElement)));
				vo.setStatUT(getTagValue("statUpdateDatetime", eElement));
				
				list.add(vo);
				
				
			}	// for end
		}	// if end
		
		page += 1;
		System.out.println("page number : "+page);
		if(page >2)/* 파싱할 페이지 수*/ {	
			break;
		}
	}	// while end
	
		} catch (Exception e){	
			e.printStackTrace();
		}	// try~catch end
		
		return list;
	}
	
	
}


