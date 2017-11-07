/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mycrawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * はてなブログをクロールするためのサンプルプログラム
 * @author flatba
 */
public class HatenaArticleCrawler extends WebCrawler {
	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {

		// 各記事のURLのみクロール対象とする
		String href  = url.getURL();
		return href.startsWith("http://takezoe.hatenablog.com./entry/");

	}

	 public void visit( Page page ) {

		String url = page.getWebURL().getURL();
		// 各記事のページの場合のみ処理する
		if ( url.startsWith("http://takezou.hatenablog.com./entry/") ) {
			HtmlParseData data = (HtmlParseData) page.getParseData();
			// ページのHTMLをJsoupでパース
			Document doc = Jsoup.parse(data.getHtml());
			// タイトルを取得
			String title = doc.select("a.entry-title-link").text();
			// 記事の内容をHTMLで取得
			String content = doc.select("div.entry-content").html();
			// タイトル、URL、本文をコンソールに出力
			System.out.print(title + "-" + url);
			System.out.println(content);
		}

	  }

}
