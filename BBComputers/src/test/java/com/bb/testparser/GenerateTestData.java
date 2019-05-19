package com.bb.testparser;

import com.bb.model.Computer;


public class GenerateTestData {
	
	/** This Method to fill the model from excel sheet 
	 * Param : rowNumber in excel sheet
	 */
	public static Computer getComputerData(int rowNumber){
		
		Computer computer = new Computer();
		try{
			ExcelReader excelTestData = new ExcelReader();

			computer.setComputerName(excelTestData.getCellData("ComputersTests", "ComputerName", rowNumber));
			computer.setIntroducedDate(excelTestData.getCellData("ComputersTests", "IntroducedDate", rowNumber));
			computer.setDiscontinuedDate(excelTestData.getCellData("ComputersTests", "DiscontinuedDate", rowNumber));
			computer.setCompany(excelTestData.getCellData("ComputersTests", "Company", rowNumber));
		}catch(Exception ex ){
			ex.printStackTrace();
		}		
		return computer;
	}
	
	/** This Method to get the expected delete validation message from excel sheet 
	 */
	public static String getDeleteValidationMessage(){
		String messsage= "";
		try{
			ExcelReader excelTestData = new ExcelReader();

			 messsage = excelTestData.getCellData("ComputersTests", "DeleteValidationMsg", 1);
		}catch(Exception ex ){
			ex.printStackTrace();
		}		
		return messsage;
	}
	
	/** This Method to get the expected create/edit validation message from excel sheet 
	 */
	public static String getValidationMessage(){
		String messsage= "";
		try{
			ExcelReader excelTestData = new ExcelReader();

			 messsage = excelTestData.getCellData("ComputersTests", "ConfirmationMsg", 1);
		}catch(Exception ex ){
			ex.printStackTrace();
		}		
		return messsage;
	}

}
