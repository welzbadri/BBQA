package com.bb.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bb.model.Computer;

public class HomeComputerGridPage {

	private static Logger log = LogManager.getLogger(HomeComputerGridPage.class.getName());
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public HomeComputerGridPage(WebDriver driver) {
		this.setDriver(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "add")
	WebElement addNewComputerBtn;

	@FindBy(id = "searchbox")
	WebElement searchComputerTxt;

	@FindBy(id = "searchsubmit")
	WebElement searchBtn;

	@FindBy(xpath = "//*[@id='main']/table/tbody/tr")
	List<WebElement> searchResultsRows;

	@FindBy(xpath = "//*[@id='main']/table/tbody/tr/td/a")
	List<WebElement> searchResultsComputerRows;

	@FindBy(css = "div.alert-message")
	WebElement confirationMessageLabel;

	public void searchComputer(Computer computer) {

		if (computer.getComputerName() != null) {
			searchComputerTxt.sendKeys(computer.getComputerName());
			searchBtn.click();
			log.info("Search computer button clicked.");
		}
	}

	/**
	 * Click in Add a new Computer Button
	 */
	public void clickAddNewComputer() {
		addNewComputerBtn.click();
		log.info("Add new computer clicked.");
	}

	/**
	 * Search for specific computer in the Computers grid
	 * 
	 * @param computerName
	 * @return true or false based on computer exists of not
	 */
	public boolean isComputerExistsInGrid(String computerName) {
		boolean exists = false;
		int computerCount = searchResultsComputerRows.size();
		try {
			if (computerCount > 0) {
				List<String> computers = getListOfComputersNamesInGrid();

				for (String computerVal : computers) {
					if (computerVal.equals(computerName)) {
						exists = true;
						log.debug(computerName + " Exists ...");
					}
				}
			}
		} catch (Exception e) {

			log.error(e.getMessage());
		}
		return exists;
	}

	/**
	 * Get list of all defined computers in the Computers Grid
	 * 
	 * @return computerValues
	 */
	public List<String> getListOfComputersNamesInGrid() {
		List<String> computerValues = new ArrayList<String>();

		for (WebElement computer : searchResultsComputerRows) {
			computerValues.add(computer.getText());
		}
		return computerValues;
	}

	/**
	 * Click on specific computer in the Computers grid
	 * 
	 * @param computerName
	 */
	public void SelectComputerRowFromGrid(String computerName) {

		int computerCount = searchResultsComputerRows.size();
		try {
			if (computerCount > 0) {
				
				for (WebElement computerElement : searchResultsComputerRows) {
					if (computerElement.getText().equals(computerName)) {
						computerElement.click();
						log.debug(computerName + " is selected from the grid ...");
					}
				}			
			}
		} catch (Exception e) {

			log.error(e.getMessage());
		}
	}
	/**
	 * Get the confirmation message of Add , Edit and Delete
	 * 
	 * @return message
	 */
	public String getConfirmationMessage() {
		log.info("confirmation message of CRUD operations");
		String message = confirationMessageLabel.getText().trim();
		return message;

	}
}
