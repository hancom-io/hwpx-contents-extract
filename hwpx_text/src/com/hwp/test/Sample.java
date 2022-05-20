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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Sample {

    public static void main(String[] args) throws Throwable {

        HwpxManager hwpxManager = new HwpxManager();
        hwpxManager = HwpxManager.getInstance();

        //File Path
        String filePath = "hwpx 전체 경로 설정";

        File file = new File(filePath);

        if (file.exists()) {
            //file open
            hwpxManager.Open(filePath);

            //text extract
            String hwpxTxtData = hwpxManager.GetTextFile(0);

            //image extract
            String hwpxImgData = hwpxManager.GetTextFile(1);

            hwpxManager.Close();


            String parentPath = file.getParentFile().getPath();

            String outTxtPath = parentPath + "\\text.txt";
            String outImgPath = parentPath + "\\img.txt";

            File txtfile = new File(outTxtPath);
            try {
                FileWriter fileWriter = new FileWriter(txtfile);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.print(hwpxTxtData);
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            File imgfile = new File(outImgPath);
            try {
                FileWriter fileWriter = new FileWriter(imgfile);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.print(hwpxImgData);
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("================ text ================");
            System.out.println(hwpxTxtData);


            System.out.println("================ image ================");
            System.out.println(hwpxImgData);
        } else {
            System.out.println("hwpx파일이 없습니다.");
        }
    }
}
