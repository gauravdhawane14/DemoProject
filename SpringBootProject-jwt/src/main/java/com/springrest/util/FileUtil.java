package com.springrest.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	
	public static void fileUpload(byte[] file,String filePath, String fileName)throws IOException {
		
		File targetFile=new File(filePath);
		
		if(targetFile.exists()) {
			targetFile.mkdirs();
		}
		
		 // Binary stream write		
		FileOutputStream out = new FileOutputStream(filePath+fileName);
	    out.write(file);
	    out.flush();
	    out.close();

		
	}

}
