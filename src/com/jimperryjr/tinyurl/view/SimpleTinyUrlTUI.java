package com.jimperryjr.tinyurl.view;

import java.util.Random;
import java.util.Scanner;

import com.jimperryjr.tinyurl.model.Url;
import com.jimperryjr.tinyurl.model.UrlLibrary;


/**
 * webcom test  
 * @author jim perry, jr.
 * @version 03.03.2016
 */
public class SimpleTinyUrlTUI {

	private Scanner userKeyboard;
	private UrlLibrary library;	
	
	

	public SimpleTinyUrlTUI(UrlLibrary library) {
		if (library == null) {
			throw new IllegalArgumentException("Invalid url library object");
		}		
		this.userKeyboard = new Scanner(System.in);
		this.library = library;
	}
	
	
	
	
	
	
	
	
	

	private int getUserNumber(String message) {		
		if (message.equals("")) {
			throw new IllegalArgumentException("Invalid url library, expecting library object");
		}	
		
		int userchoice = 0;
		
		try {
			System.out.print(message);
			userchoice = Integer.parseInt(this.userKeyboard.nextLine());
		} catch (NumberFormatException error) {
			System.out.println("Sorry: [ " + this.getErrorString(error) + " ] is not valid. Enter 1, 2 or 9. \n");
		}
		return userchoice;
	}	
	
	
	private void addLongUrl() {
		String originalUrl = "";

		System.out.print("Enter a long url: " );
		

		originalUrl = this.userKeyboard.nextLine();
		System.out.println("");

		Random randomObject = new Random();
		Url newUrl = new Url(randomObject, originalUrl);
		this.library.populateUrlLibrary(newUrl);

		System.out.println("Your entered: "+ newUrl.getUrlOriginal());
		System.out.println("Short url:    "+ newUrl.getUrlShort() + "\n");

	}
	
	
	
	private void listAllUrls() {
		System.out.print(this.library.toString() + "\n");
	}
	
	
	
	
	
	
	
	/**
	 * controls program flow 
	 **/	
	public void run() {
		int userchoice = 0;	
		this.displayWelcome();
		this.displayMenu();		
		
		try {
			userchoice = this.getUserNumber("Enter selection: ");
		} catch (NumberFormatException error) {
			System.out.println("Sorry: [ " + this.getErrorString(error) + " ] is not valid. Enter 1, 2 or 9. \n");
		}
		
		this.selectionCategories(userchoice);	
	}
	
	
	/**
	 * Displays the welcome
	 **/
	private void displayWelcome() {		
		System.out.println("Welcome to the shorten URL app");		
	
	}
	
	
	/**
	 * Displays menu options:
	 **/
	private void displayMenu() {		
		System.out.println("1 - Add a long url\t 2 - Show list of url's ");
		System.out.println("9 – Quit the application");
	}

	
	
	/**
	 * main menu options, prompt user to select
	 * @param userChoice users menu selection
	 **/
	private void displayMenuInput(int userChoice) {			
		try {
			userChoice = Integer.parseInt(this.userKeyboard.nextLine());
		} catch (NumberFormatException error) {
			System.out.println("Sorry: [ " + this.getErrorString(error) + " ] is not valid. Enter a number between 1 and 3. \n");
		}
		this.selectionCategories(userChoice);
	}	
	
	
	
	/**
	 * Decides what functions execute based on user input
	 * @param userchoice user's menu selection
	 **/	
	private void selectionCategories(int userchoice) {		
		switch (userchoice) {
			case 1:	
				System.out.println("\n    [1 Add long url]");	   
				this.addLongUrl();   		
	    		this.displayMenuAndInput(userchoice);	
				break;

	        case 2: 
	        	System.out.println("\n*   [2  List of urls]");  
	        	this.listAllUrls();
	    		this.displayMenuAndInput(userchoice);		        	
	            break;            
	        case 9: 
	        	System.out.println("\n    [9 Quit]");
	        	System.out.println("    We hope you enjoyed this program.\n\n");
	            break;
	        default: 
	        	System.out.print("Not valid input. Please try again.\n\n");
	        	this.displayMenuAndInput(userchoice);
	        	break;		
		}
		System.out.println("\n\n");
	}	
	
	/**
	 * Displays menu
	 * @param userchoice user's menu selection
	 **/
	private void displayMenuAndInput(int userChoice) {
    	this.displayMenu();
    	this.displayMenuInput(userChoice);
	}
	
	
	/**
	 * provides specific text that causes input errors 
	 * @param error accepts ERROR from try catch 
	 * @return returns the value\input responsible for error
	 */
	private String getErrorString(NumberFormatException error) {
		int first = error.getMessage().indexOf("\"", 0) + 1; 
		int second = error.getMessage().lastIndexOf("\"");
	
		return error.getMessage().substring(first, second);		
	}	
	
	
	
	
	
		

}
