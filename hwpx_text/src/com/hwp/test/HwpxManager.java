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

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.tomcat.util.codec.binary.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class HwpxManager {

    private Document document = null;
    private NodeList nodeList = null;

    //text
    private ArrayList<String> textArr = new ArrayList<String>();

    //image
    private ArrayList<String> imageArr = new ArrayList<String>();


    public static HwpxManager getInstance(){
        return new HwpxManager();
    }

    public boolean Open(String filepath) {

        FileInputStream fileInputStream = null;
        ZipInputStream zipInputStream = null;
        ByteArrayOutputStream byteOutStream = null;
        ZipFile zipFile = null;

        try {

            //hwpx unzip
            zipFile = new ZipFile(filepath);
            fileInputStream = new FileInputStream(filepath);
            zipInputStream = new ZipInputStream(fileInputStream, Charset.forName("UTF-8"));
            ZipEntry zipEntry = null;


            while ((zipEntry = zipInputStream.getNextEntry()) != null) {

                //text extract
                /*
                 * Only for all
                 * Requires acquisition in paragraphs and words using hp:p nodes
                 */
                if(zipEntry.getName().indexOf("section") != -1){

                    ZipEntry entry = zipFile.getEntry(zipEntry.getName());
                    InputStream in = zipFile.getInputStream(entry);

                    int ins;
                    byte[] b = new byte[4096];
                    StringBuffer buffer = new StringBuffer();

                    while((ins = in.read(b)) != -1){
                        buffer.append(new String(b, 0, ins));
                    }
                    String str = buffer.toString();

                    InputSource is = new InputSource(new StringReader(str));
                    document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);

                    //Import field names and field values in the body and save the map
                    XPath xpath = XPathFactory.newInstance().newXPath();
                    nodeList = (NodeList) xpath.evaluate("//*[name()='hp:p']", document, XPathConstants.NODESET);

                    for( int idx = 0; idx < nodeList.getLength(); idx++ ){

                        String nodeContents = nodeList.item(idx).getTextContent();

                        if(!nodeContents.trim().equals("")){
                            textArr.add(nodeContents+"<br/>");
                        }
                    }
                }

                //Extract Image (Base64)
                if(zipEntry.getName().indexOf("image") != -1){

                    ZipEntry entry = zipFile.getEntry(zipEntry.getName());
                    InputStream in = zipFile.getInputStream(entry);
                    byteOutStream = new ByteArrayOutputStream();

                    //Extension
                    String fileExt = zipEntry.getName().substring(zipEntry.getName().lastIndexOf(".") + 1);

                    int ins;
                    byte[] b = new byte[1024];
                    while((ins = in.read(b)) != -1){
                        byteOutStream.write(b, 0, ins);
                    }

                    byte[] fileArray = byteOutStream.toByteArray();
                    String imageStr = new String(Base64.encodeBase64(fileArray));
                    imageStr = "data:image/"+ fileExt +";base64, "+ imageStr;

                    imageArr.add(imageStr);
                }
            }

            zipInputStream.closeEntry();

        } catch (Exception e) {
            System.out.println(e);
        }

        return document != null ? true : false;
    }

    //Process and return extracted data
    public String GetTextFile(int type) {

        String fieldContents = "";

        if(type == 0){

            for(int arr = 0; arr < textArr.size(); arr++){
                fieldContents += textArr.get(arr) +"\r\n";
            }

        } else if(type == 1){

            for(int arr = 0; arr < imageArr.size(); arr++){
                fieldContents += imageArr.get(arr) +"||";
            }

        }

        return fieldContents;
    }

    public void Close() {

        nodeList = null;
        document = null;

        textArr.clear();
        imageArr.clear();
    }
}
