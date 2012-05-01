package com.narratage.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtils {
	
	public static String getFileContents(StringBuffer sb, String filePath, String fileName) throws IOException{
		String src = filePath+fileName;
		File file = new File(src);  
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));  
		String line;  
		
		while ((line = br.readLine()) != null) {  
			sb.append(line);  
			sb.append("&lt;br&gt;");
		}  
		br.close(); 
		
		return sb.toString();
		
	}

}
