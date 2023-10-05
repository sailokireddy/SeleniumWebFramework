package webframework.SeleniumWebFrameWorkDesign.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertjsontoMAp {

	@DataProvider
	public Object[] getJsontoMap() throws JsonParseException, JsonMappingException, IOException {
		
		File file =new File("C:\\Users\\slokireddy\\eclipse-workspace\\SeleniumWebFrameWorkDesign\\src\\test\\java\\webframewwork\\Data\\TestData.json");
		
		ObjectMapper mapper= new ObjectMapper();
		
		HashMap<String,Object> map=mapper.readValue(file, new TypeReference<HashMap<String, Object>>() {});
		System.out.println(map);
		return new Object[] {map};
	}
	
	@Test(dataProviderClass = ConvertjsontoMAp.class , dataProvider = "getJsontoMap")
	public void retrnData(Map<String,Object> mapw) {
		
		for(Map.Entry<String, Object> map1:mapw.entrySet()) {
			System.out.println(map1.getKey());
			System.out.println(map1.getValue());
		}
	}
	
	
}
