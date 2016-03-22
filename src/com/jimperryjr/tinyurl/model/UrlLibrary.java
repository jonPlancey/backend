package com.jimperryjr.tinyurl.model;

import java.util.ArrayList;


/**
 * webcom test  
 * @author jim perry, jr.
 * @version 03.03.2016
 */
public class UrlLibrary {

	private ArrayList<Url> url;	

	
	public UrlLibrary() {
		this.url = new ArrayList <Url>();
	}

	public ArrayList<Url> getUrl() {
		return url;
	}
	

	public String toString() {	
		String printOutput = "";
		
		for (int count = 0; count < this.url.size(); count++) {
			//printOutput += this.url.get(count).toString() + "\n";
			printOutput += count + ". " + this.url.get(count).getUrlShort() + "  ->\t" +
							this.url.get(count).getUrlOriginal() + "\n";
		}
		return  printOutput; 
	}
	
	

	public void populateUrlLibrary(Url newUrl) {
		this.url.add(newUrl);
	}
	

}
