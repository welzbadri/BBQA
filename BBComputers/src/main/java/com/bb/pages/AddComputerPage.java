package com.bb.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.bb.model.Computer;

public class AddComputerPage {

	private static Logger log = LogManager.getLogger(AddComputerPage.class.getName());
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public AddComputerPage(WebDriver driver){
		this.setDriver(driver);
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(id="name")
     WebElement computerNameTxt;
	
	 @FindBy(id="introduced")
     WebElement introducedDateTxt;
	 
	 @FindBy(id="discontinued")
     WebElement discontinuedDateTxt;
	 
	 @FindBy(id="company")
     WebElement companyDdlElement;
	 
	 @FindBy(xpath="//input[@value='Create this computer']")
     WebElement createComputerBtn; 
	 
	 public void addNewComputer(Computer computer){
		 
		 if(computer.getComputerName() !=null){ 
			 computerNameTxt.clear();
			 computerNameTxt.sendKeys(computer.getComputerName());
			 log.info("Value " +computer.getComputerName()+" is Entered.");
		 }	
		 if(computer.getIntroducedDate() !=null){	
			 introducedDateTxt.clear();
			 introducedDateTxt.sendKeys(computer.getIntroducedDate());
			 log.info("Value " +computer.getIntroducedDate()+" is Entered.");
		 }
		 if(computer.getDiscontinuedDate() !=null){ 
			 discontinuedDateTxt.clear();
			 discontinuedDateTxt.sendKeys(computer.getDiscontinuedDate());
			 log.info("Value " +computer.getDiscontinuedDate()+" is Entered.");
		 }
		 if(computer.getCompany() !=null){
			Select  companyOptions = new Select(companyDdlElement);
			companyOptions.selectByVisibleText(computer.getCompany());}
		 log.info("Value " +computer.getCompany()+" is Selected");
		 createComputerBtn.click();	 
		 log.info(computer.getComputerName() +" has been created ..");
	 } 	 
}
