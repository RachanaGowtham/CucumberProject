package com.training.pageFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;

import com.training.base.BasePage;
import com.training.utilities.CommonUtilities;


public class PageFactory {
	
	static CommonUtilities common = new CommonUtilities();
	
	static final HashMap<String, String> packageClassMap = new HashMap<String, String>();

	public static String getPackage() throws IOException {
	String packageName= common.getproperty("page.packages");
	return packageName;
	}
			
		
	

	public BasePage initialize(String pageName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		BasePage page = null;
		String packagename= getPackage();
		String pageClassFullName = packagename + "."
				+ pageName;
		page = (BasePage) Class.forName(pageClassFullName)
				.newInstance();
	
		/*String formattedPageName = getRemovedSpaceName(pageName);
		try {
			String packageName = packageClassMap.get(formattedPageName);
			if (packageName != null) {
				String pageClassFullName = packageName + "."
						+ formattedPageName;
				page = (BasePage) Class.forName(pageClassFullName)
						.newInstance();
			} else {
				System.out.println("Page Class with" + formattedPageName
						+ "doesnt exist .Please provide valid page Name");*/
		return page;	
		}

		/*} catch (Exception e) {
			e.printStackTrace();
			
		}*/
		
		

	//}

	

	

}