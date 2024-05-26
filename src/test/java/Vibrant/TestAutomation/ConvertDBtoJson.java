package Vibrant.TestAutomation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class ConvertDBtoJson {
	
	   public void convertData() throws ClassNotFoundException, SQLException, StreamWriteException, DatabindException, IOException {
		
		ArrayList<CustomerDetails> al=new ArrayList<>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		JSONArray js=new JSONArray();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Business","root","root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';");
		while(rs.next()) {
			CustomerDetails cd=new CustomerDetails();
			cd.setCourseName(rs.getString(1));
			cd.setPurchaseDate(rs.getString(2));
			cd.setAmountl(Integer.parseInt(rs.getString(3)));
			cd.setLocation(rs.getString(4));
		
			al.add(cd);
		}
		
		for(int i=0;i<al.size();i++) {
//		ObjectMapper mapper=new ObjectMapper();
//		mapper.writeValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Vibrant\\Utilities\\CustDetails"+i+".json"), al.get(i));
		Gson gs=new Gson();
		js.add(gs.toJson(al.get(i)));
		}
		JSONObject jso=new JSONObject();
		jso.put("data",js);
		String unescapedString=StringEscapeUtils.unescapeJava(jso.toJSONString());
		System.out.println(unescapedString);
		String firstString=unescapedString.replace("\"{","{");
		String finalString=firstString.replace("}\"","}");
		System.out.println(finalString);
		FileWriter fw=new FileWriter(System.getProperty("user.dir")+"\\src\\test\\java\\Vibrant\\Utilities\\Single.json");
		fw.write(finalString);
		fw.close();
		con.close();
		
	}

}
