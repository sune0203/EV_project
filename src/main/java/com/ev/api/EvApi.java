package com.ev.api;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class EvApi {
	/* Java 샘플 코드 */
//	public static list<apiVO> EvApi(String search) {
//			list<apiVO> e_vo = new list<apiVO>();
//	        StringBuilder urlBuilder = new StringBuilder("http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList"); /*URL*/
//	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=CvpnEVVkOCWFDGyHJtpZHmTMDxUESl9dapf5afM70Iv88HfB8xGuQFfBz24tJb8gpe50lAccNCzkJ1R5cTphSA%3D%3D"); /*Service Key*/
//	        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("CvpnEVVkOCWFDGyHJtpZHmTMDxUESl9dapf5afM70Iv88HfB8xGuQFfBz24tJb8gpe50lAccNCzkJ1R5cTphSA%3D%3D", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
//	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("11", "UTF-8")); /*페이지번호*/
//	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//	        urlBuilder.append("&" + URLEncoder.encode("addr","UTF-8") + "=" + URLEncoder.encode("전라남도 나주시 전력로 55", "UTF-8")); /*검색대상 충전소주소*/
//	        URL url = new URL(urlBuilder.toString());
//	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//	        conn.setRequestMethod("GET");
//	        conn.setRequestProperty("Content-type", "application/json");
//	        System.out.println("Response code: " + conn.getResponseCode());
//	        BufferedReader rd;
//	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//	        } else {
//	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//	        }
//	        StringBuilder sb = new StringBuilder();
//	        String line;
//	        while ((line = rd.readLine()) != null) {
//	            sb.append(line);
//	        }
//	        rd.close();
//	        conn.disconnect();
//	        System.out.println(sb.toString());
//	        
//	        return e_vo;
//	    }
	
	  public static void main(String[] args) throws IOException {
	        StringBuilder urlBuilder = new StringBuilder("http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList"); /*URL*/
//	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=hR8kBsu86Cx0xEumFWONu1zyZtg5876w2yHXlDFo2uaxH1SDhxUDUidyLerffwqMs8QFLT5ZbDQ57KeUYI2RLg=="); /*Service Key*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("hR8kBsu86Cx0xEumFWONu1zyZtg5876w2yHXlDFo2uaxH1SDhxUDUidyLerffwqMs8QFLT5ZbDQ57KeUYI2RLg==", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("addr","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*검색대상 충전소주소*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        System.out.println("");
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	    }
	
	}
	

