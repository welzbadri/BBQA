package com.bb.tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.bb.model.Computer;
import com.bb.pages.AddComputerPage;
import com.bb.pages.EditComputerPage;
import com.bb.pages.HomeComputerGridPage;
import com.bb.testparser.GenerateTestData;

/********
 * 
 * @author Waleed Badri
 *
 * This class will contains computers test cases:
 * Add Computer - Check create new computer with all valid data.
 * Search Computer - Check searching for an existing computer name.
 * Search Computer - Check data retrieved correctly when searching for an existing computer name.
 * Delete Computer - Check deleting an existing computer name.
 */
public class ComputersTests extends TestBase
{
	private static Logger log = LogManager.getLogger(ComputersTests.class.getName());

	HomeComputerGridPage homePage ; 
	AddComputerPage addComputerPage ; 
	EditComputerPage editComputerPage ; 

	
	@BeforeMethod
	public void BranchesTestSetup()
	{
		addComputerPage = new AddComputerPage(driver);
		editComputerPage = new EditComputerPage(driver);
		homePage = new HomeComputerGridPage(driver);
	}
	
	/** Manual Test Case number and Title
	 * TC0001: Add Computer - Check create new computer with all valid data.
	 */
	@Test(priority=1)
	public void checkCreateNewComputerWithValidDataTest()
	{
		log.info(Thread.currentThread().getStackTrace()[1].getMethodName()+" Test Started");
		/**
		 *  Arrange Test Data
		 *  Load the test data from the excel sheet (ComputersTestData.xlsx)
		 *  Pass row number in excel sheet to get the computer data.
		 */
		Computer computerData = GenerateTestData.getComputerData(1);

		// Act  ... Test Case Steps
        homePage.clickAddNewComputer();
        addComputerPage.addNewComputer(computerData);
        String actualValidationMsg = homePage.getConfirmationMessage();
        String expectedValidationMsg = GenerateTestData.getValidationMessage()+computerData.getComputerName().trim();
           
		// Assert that a confirmation message appears in home page
        Assert.assertTrue(actualValidationMsg.contains(expectedValidationMsg));
	}
	/** Manual Test Case number and Title
	 * TC0005: Search Computer - Check searching for an existing computer name 
	 */
	@Test(priority=2)
	public void checkSearchForExistingComputerTest()
	{
		/**
		 *  Arrange Test Data
		 *  Load the test data from the excel sheet (ComputersTestData.xlsx)
		 *  Pass row number in excel sheet to get the computer data.
		 */
		Computer computerData = GenerateTestData.getComputerData(1);
		// Act  ... Test Case Steps
        homePage.searchComputer(computerData);  
        boolean isComputerReturned = homePage.isComputerExistsInGrid(computerData.getComputerName());
           
		// Assert that computer details should be returned in the grid.
        Assert.assertTrue(isComputerReturned);
	}
	
	/** Manual Test Case number and Title
	 * TC0007: Search Computer - Check data retrieved correctly when searching for an existing computer name  
	 */
	@Test(priority=3)
	public void checkDataRetrievedCorrectlyAfterSearchComputerTest()
	{
		/**
		 *  Arrange Test Data
		 *  Load the test data from the excel sheet (ComputersTestData.xlsx)
		 *  Pass row number in excel sheet to get the computer data.
		 */
		Computer computerData = GenerateTestData.getComputerData(1);
		// Act  ... Test Case Steps
        homePage.searchComputer(computerData);  
        homePage.SelectComputerRowFromGrid(computerData.getComputerName());

        Computer retrievedComputerData = editComputerPage.getComputerRetrievedValue();
        
   		// Assert that Computer details retrieved successfully in the "Edit Computer" form.
        Assert.assertTrue(retrievedComputerData.equals(computerData));
	}
	
	/** Manual Test Case number and Title
	 * TC0008: Edit Computer - Check Edit an existing computer name with valid data 
	 */
	@Test(priority=4)
	public void checkEditExistingComputerWithValidDataTest()
	{
		/**
		 *  Arrange Test Data
		 *  Load the test data from the excel sheet (ComputersTestData.xlsx)
		 *  Pass row number in excel sheet to get the computer data.
		 *  Get different data from excel by passing row number 2
		 */
		Computer computerData = GenerateTestData.getComputerData(1);
		Computer computerDataForUpdate = GenerateTestData.getComputerData(2);

		// Act  ... Test Case Steps
        homePage.searchComputer(computerData);  
        homePage.SelectComputerRowFromGrid(computerData.getComputerName());
        editComputerPage.editComputer(computerDataForUpdate);
        String actualValidationMsg = homePage.getConfirmationMessage();
        String expectedValidationMsg = GenerateTestData.getValidationMessage()+computerDataForUpdate.getComputerName().trim();        
		// Assert that a confirmation message appears in home page
        Assert.assertTrue(actualValidationMsg.contains(expectedValidationMsg));
	}
	
	/** Manual Test Case number and Title
	 * TC00010: Delete Computer - Check deleting an existing computer name  
	 */
	@Test(priority=5)
	public void checkDeleteExistingComputerTest()
	{
		/**
		 *  Arrange Test Data
		 *  Load the test data from the excel sheet (ComputersTestData.xlsx)
		 *  Pass row number in excel sheet to get the computer data.
		 *  Get different data from excel by passing row number 2
		 */
		Computer computerDataForUpdate = GenerateTestData.getComputerData(2);

		// Act  ... Test Case Steps
        homePage.searchComputer(computerDataForUpdate);  
        homePage.SelectComputerRowFromGrid(computerDataForUpdate.getComputerName());
        editComputerPage.clickDeleteComputer();
        
        String actualValidationMsg = homePage.getConfirmationMessage();
        String expectedValidationMsg = GenerateTestData.getDeleteValidationMessage();        
		// Assert that a confirmation message appears in home page
        Assert.assertTrue(actualValidationMsg.contains(expectedValidationMsg));
	}
}
