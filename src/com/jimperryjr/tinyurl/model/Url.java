package com.jimperryjr.tinyurl.model;

import java.util.Random;

/**
 * webcom test  
 * @author jim perry, jr.
 * @version 03.03.2016
 */
public class Url {
	
	private String urlOriginal;
	private String urlShort;
	private Random randomObject;
	
	
	public Url(Random random, String originalUrl) {
		this.urlOriginal = originalUrl;
		this.randomObject = random;
		this.createRandomShortURL();
	}
	

	public String getUrlOriginal() {
		return urlOriginal;
	}
	
	public String getUrlShort() {
		return urlShort;
	}	

	
	/** 
	 * 
	 * @return random short url
	 */
	private void createRandomShortURL() {
		String baseUrl = "http://tiny.cc/";
				
		String[] urlEnd = new String[4];
		
		urlEnd[0] = Integer.toString(this.randomObject.nextInt(10));
		urlEnd[1] = Integer.toString(this.randomObject.nextInt(10));
		urlEnd[2] = Integer.toString(this.randomObject.nextInt(10));
		urlEnd[3] = Integer.toString(this.randomObject.nextInt(10));
				
		String urlEnding = "";
		for (int count = 0; count < urlEnd.length; count++) {
			urlEnding += urlEnd[count];
		}
		
		this.urlShort = baseUrl + urlEnding;
		
	}

}
