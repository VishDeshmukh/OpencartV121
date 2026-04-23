package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	//DataProvider1
	
	@DataProvider(name = "Logindata")
	    public String[][] getData() throws IOException {
        System.out.println("executed");
	    String path = "E://vishakha//seleniumwebdriver//OpencartV121//testData//Opencart_Logintest.xlsx";
	    System.out.println("executed1");
	    ExcelUtility xlutil = new ExcelUtility(path);
	    System.out.println("executed2");
	    int totalrows = xlutil.getRowCount("Sheet1");
	    int totalcols = xlutil.getCellCount("Sheet1", 1);
	    System.out.println(totalcols);
	    System.out.println(totalrows);
	    String logindata[][] = new String[totalrows][totalcols]; // exclude header row

	    for (int i = 1; i <=totalrows; i++) { // start from 1 (skip header)
	        for (int j=0; j<totalcols; j++) {

	            logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
	        }
	    }

	    return logindata;
	}
	
		
}
	



