/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mycrawler;

import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author flatba
 */
public class BasicAuthentication {
	public void basicAuthentication(String url, String username, String password) {

		// ユーザ名とパスワードをコロン（：）でつなぎ、Base64エンコードする
		String authorization = username + ":" + password;
		String base64Authorization = new String(Base64.getEncoder().encodeToString(authorization.getBytes()));


		try {
			Response res = Jsoup.connect(url).method(Method.HEAD).execute();

			// HTTP認証が不要なページの場合、上記のリクエストは例外とならず、
			// 下記のように通常のリクエストができる。
			Document doc = Jsoup.connect(url).get();

			// ...

		} catch (HttpStatusException e) {
			// HTTP認証が必要なページの場合、最初のリクエストは例外となる
			Integer status = e.getStatusCode();

			// HTTP認証が必要なページでは、認証情報が不足する場合、
			// ステータス401(Authorization Required)を返す
			if (status == 401) {
				try {
					// AuthorizationヘッダにBase64エンコードされたデータを付けて
					// リクエストする
					Document doc = Jsoup.connect("http///localhost:8080/")
							.header("Authorization", "Basic" + base64Authorization).get();

				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
