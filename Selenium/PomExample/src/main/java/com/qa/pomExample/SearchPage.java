package com.qa.pomExample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SearchPage {

	@FindBy (css = "ul[class='product_list grid row']")
	public WebElement unorderList;
	
	@FindBys ({
		@FindBy (css = "ul[class='product_list grid row']"),
		@FindBy (tagName = "li")
	})
	public List<WebElement> items;
	
	public boolean find(String searchTerm) {
		for (WebElement ele : items) {
			try {
				if (ele.findElement(By.tagName("h5")).getText().equals(searchTerm)) {
					return true;
				}
			} catch (Exception e) {
			}
		}
		return false;
	}
}
