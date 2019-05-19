package com.bb.model;

/********
 * 
 * @author Waleed
 * This the Model class for all the computer details
 * 
 */
public class Computer {

	private String computerName;
	private String introducedDate;
	private String discontinuedDate;
	private String company;
	
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	public String getIntroducedDate() {
		return introducedDate;
	}
	public void setIntroducedDate(String introducedDate) {
		this.introducedDate = introducedDate;
	}
	public String getDiscontinuedDate() {
		return discontinuedDate;
	}
	public void setDiscontinuedDate(String discontinuedDate) {
		this.discontinuedDate = discontinuedDate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	 //Overriding equals
	@Override
	public boolean equals(Object obj) 
	{
	    if (this == obj) return true;
	    if (obj == null) return false;
	    if (this.getClass() != obj.getClass()) return false;
	    Computer that = (Computer) obj;
	    if (!this.getComputerName().equals(that.getComputerName())) return false;
	    if (!this.getIntroducedDate().equals(that.getIntroducedDate())) return false;
	    if (!this.getDiscontinuedDate().equals(that.getDiscontinuedDate())) return false;
	    if (!this.getCompany().equals(that.getCompany())) return false;
		return true;
	}			
}
