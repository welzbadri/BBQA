package com.bb.pages;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bb.model.Computer;


public class EditComputerPage {
	private static Logger log = LogManager.getLogger(EditComputerPage.class.getName());
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public EditComputerPage(WebDriver driver) {
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
	 
	 @FindBy(xpath="//input[@value='Save this computer']")
     WebElement saveComputerBtn;
	 
	 @FindBy(xpath="//input[@value='Delete this computer']")
     WebElement deleteComputerBtn;
	 
	 public void editComputer(Computer computer){
		 
		 if(computer.getComputerName() !=null){ 
			 computerNameTxt.clear();
			 computerNameTxt.sendKeys(computer.getComputerName());
			 log.info("Value " +computer.getComputerName()+" Entered successfully");
		 }	
		 if(computer.getIntroducedDate() !=null){
			 introducedDateTxt.clear();
			 introducedDateTxt.sendKeys(computer.getIntroducedDate());
			 log.info("Value " +computer.getIntroducedDate()+" Entered successfully");
		 }
		 if(computer.getDiscontinuedDate() !=null){
			 discontinuedDateTxt.clear();
			 discontinuedDateTxt.sendKeys(computer.getDiscontinuedDate());
			 log.info("Value " +computer.getDiscontinuedDate()+" Entered successfully");
		 }
		 if(computer.getCompany() !=null){
			Select  companyOptions = new Select(companyDdlElement);
			companyOptions.selectByVisibleText(computer.getCompany());}
		 log.info("Value " +computer.getCompany()+" is Selected");
		 saveComputerBtn.click();	 
		 log.info(computer.getComputerName() +" has been updated ..");
	 } 
	 
	 /**
	  * Get retrieved computer model from selected computer
	  * 
	  * @return computer
	  */
	 public Computer getComputerRetrievedValue(){
		 Computer computer = new Computer();
		 computer.setComputerName(computerNameTxt.getAttribute("value"));
		 computer.setIntroducedDate(introducedDateTxt.getAttribute("value"));
		 computer.setDiscontinuedDate(discontinuedDateTxt.getAttribute("value"));
		 Select  companyOptions = new Select(companyDdlElement);
		 WebElement option = companyOptions.getFirstSelectedOption();
		 computer.setCompany(option.getText());		 	 
		 return computer;
	 }
	 
	 public void clickDeleteComputer(){	 
		 deleteComputerBtn.click();
		 log.info(" Delete Computer button Clicked ..");
	 }
	 	 
}
