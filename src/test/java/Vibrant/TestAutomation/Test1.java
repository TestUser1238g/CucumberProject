package Vibrant.TestAutomation;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObjects.AdminPage;
import Vibrant.DriverFactory.BaseTest;

public class Test1 extends BaseTest {

	@Test(groups= {"smoke"})
	public void verifyAdminPage() throws InterruptedException {
		Assert.assertEquals("Admin", dashboardPage.verifyDashboardTitle(), "Dashboard Page Fail");
		AdminPage adminPage = dashboardPage.clickOnAdminBtn();
		Assert.assertEquals("Admin", adminPage.verifyAdminPageTitle(), "Admin page Failed");

	}
	
	@Test(groups= {"regression"})
	public void readValuesFromExl() throws FilloException {
		String filePath=System.getProperty("user.dir")+"//src//test//java//Vibrant//Utilities//TestData.xlsx";
		
		Fillo fillo=new Fillo();
		Connection con=fillo.getConnection(filePath);
		Recordset rs=con.executeQuery("select * from Sheet1");
		while(rs.next()) {
			System.out.println(rs.getField("Names"));
			System.out.println(rs.getField("Marks"));
			System.out.println(rs.getField("Price"));
			
		}
	}
	
	@Test(groups= {"regression"})
	public void readValuesFrmJson() throws IOException {
		
		
		String readVal=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//Vibrant//Utilities//TestData.json"),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> ls=mapper.readValue(readVal, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		for(int i=0;i<ls.size();i++) {
			System.out.println(ls.get(i));
		}
	}

}
