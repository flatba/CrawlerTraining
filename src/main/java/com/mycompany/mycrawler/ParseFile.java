/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mycrawler;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

/**
 * Apache Tika でPDFファイルからテキストを抽出する。
 * @author flatba
 */
public class ParseFile {

	public void parseFile ( String dir ) {
		try {

			// Tikaを使用するための準備
			Tika tika = new Tika();

			// PDFファイルからテキストを抽出してコンソールにう出力
			String result = tika.parseToString( new File(dir) );
			System.out.println(result);

		} catch (IOException ex) {
			Logger.getLogger(ParseFile.class.getName()).log(Level.SEVERE, null, ex);
		} catch (TikaException ex) {
			Logger.getLogger(ParseFile.class.getName()).log(Level.SEVERE, null, ex);
		}


	}

}
