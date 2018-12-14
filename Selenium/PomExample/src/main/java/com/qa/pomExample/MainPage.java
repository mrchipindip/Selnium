package com.qa.pomExample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

	@FindBy (id = "search_query_top")
	private WebElement searchBar;
	
	public void search(String searchText) {
		searchBar.sendKeys(searchText);
		searchBar.submit();
	}
	
}
