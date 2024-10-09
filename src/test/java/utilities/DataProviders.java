package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		String path = ".\\testData\\Opencart_LoginData.xlsx";//taking excel file from testData folder
		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object for XLUtility
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]= new String[totalrows][totalcols]; //created for 2d array which can store values from excel file
		
		for(int i=1; i<=totalrows;i++) {
			for(int j=0; j<totalcols; j++) {
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
				
			}
		}
		return logindata;//returning 2d array
	}
	
	//DataProvider 2
	
	//DataProvider 3
	

}
