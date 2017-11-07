/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mycrawler;

/**
 *
 * @author flatba
 */
public class MyCrawler {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

//		String url = "https://netbeans.org/kb/73/java/project-setup_ja.html";
//		GetCharset gc = new GetCharset();
//		gc.getCharset(url);

		String dir = "/Users/flatba/Desktop/340018_1180107D1131_1_09.pdf";

		ParseFile pf = new ParseFile();
		pf.parseFile(dir);

	}

}
