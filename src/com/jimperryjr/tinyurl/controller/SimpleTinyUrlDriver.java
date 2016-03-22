package com.jimperryjr.tinyurl.controller;

import com.jimperryjr.tinyurl.model.UrlLibrary;
import com.jimperryjr.tinyurl.view.SimpleTinyUrlTUI;


/**
 * webcom test  
 * @author jim perry, jr.
 * @version 03.03.2016
 */
public class SimpleTinyUrlDriver {
	

	public static void main(String[] args) {
		UrlLibrary library = new UrlLibrary(); 
		SimpleTinyUrlTUI gui = new SimpleTinyUrlTUI(library);
		gui.run();
	}

}
