/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mycrawler;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

/**
 * HTMLを読み込んで文字コードを判別するプログラム
 * @author flatba
 */
public class GetCharset {

	public void getCharset( String url ) {

		Response response;
		try {

			response = Jsoup.connect(url).execute();
			//  HTTPレスポンスヘッダに文字コード情報が含まれている場合
			//  Connection.execute()メソッドの実行後に文字コード名が取得できる
			System.out.print ("文字コードは" + response.charset() + "です。");

			//  HTTPレスポンスヘッダに文字コード情報が含まれておらず、
			// HTML内のmetaタグに文字コード情報が含まれている場合、
			// Response.parse()メソッドの実行後に文字コードが取得できる
			response.parse();
			System.out.println("レスポンスをパースしました。");
			System.out.println("文字コードは" + response.charset() + "です。");

		} catch (IOException ex) {
			Logger.getLogger(GetCharset.class.getName()).log(Level.SEVERE, null, ex);
		}



	 }

}
