/*
 * Copyright 2022 Hancom Inc. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hwp.test;

/*
 * string to txt file import 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
*/

public class Sample {
	
	public static void main(String[] args) throws Throwable {
		
		HwpxManager hwpxManager = new HwpxManager();
		hwpxManager = HwpxManager.getInstance();
		
		//File Path
		String filePath = "";
		
		filePath = "hwpx full path";		
		
		//file open
        hwpxManager.Open(filePath);

        //text extract
        String hwpxTxtData = hwpxManager.GetTextFile(0);
        
		//image extract
		String hwpxImgData = hwpxManager.GetTextFile(1);
		
		hwpxManager.Close();
		
		/*
		 * hwpxTxtData to txt file example
		File txtfile = new File("d:\\textfile.txt");
		try {
		    FileWriter fileWriter = new FileWriter(txtfile);
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    printWriter.print(hwpxTxtData);
		    printWriter.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		*/
		
		/*
		 * hwpxImgData to txt file example
		File imgfile = new File("d:\\imgfile.txt");
		try {
		    FileWriter fileWriter = new FileWriter(imgfile);
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    printWriter.print(hwpxImgData);
		    printWriter.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		*/
		
		System.out.println("================ text ================");
		System.out.println(hwpxTxtData);
		

		System.out.println("================ image ================");
		System.out.println(hwpxImgData);
	}
}
