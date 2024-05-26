package Vibrant.TestAutomation;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJsonToJavaObject {
	
	public void convertJSONToJavaObject1() throws StreamReadException, DatabindException, IOException {
		ObjectMapper om=new ObjectMapper();
		
		SingleJson custDetails=om.readValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Vibrant\\Utilities\\Single.json"), SingleJson.class);
		  for (Data course : custDetails.getData()) {
              System.out.println("Course Name: " + course.getCourseName());
              System.out.println("Purchase Date: " + course.getPurchaseDate());
              System.out.println("Amount: " + course.getAmountl());
              System.out.println("Location: " + course.getLocation());
              System.out.println();
          }
	}

}
