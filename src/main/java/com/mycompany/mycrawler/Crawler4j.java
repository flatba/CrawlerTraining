/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mycrawler;

import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import java.nio.file.Files;
//import java.nio.file.Paths;


/**
 * Crawler4jのサンプルプログラム
 * @author flatba
 */
public class Crawler4j {

	public void crawler4j() {
		//    // ブログ記事一覧のページのURL
		//    String url = "http://takezoe.hatenablog.com/";
		//    // GETリクエストを送信し、レスポンスをDocumentオブジェクトで取得
		//    Document doc = Jsoup.connect(url).get();
		//    // JQueryと同様のCSSセレクタで検索結果のリンクを抽出
		//    Elements elements = doc.select("a.entry-title-link");
		//    // 抽出したリンクを一件ずつ処理
		//    for (Element element : elements) {
		//      // リンクのラベルを取得
		//      String title = element.text();
		//      // リンクのURLを取得
		//      String nextUrl = element.attr("href");
		//      // リンク先ページを取得
		//      Document nextDoc = Jsoup.connect(nextUrl).get();
		//      // 記事の内容をHTMLで取得
		//      String content = nextDoc.select("div.entry-content").html();
		//      // 「タイトル.html」というファイル名で記事の内容を保存
		//      Files.write(Paths.get(title + ".html"), content.getBytes("UTF-8"));
		//    }

			String crawlStorageFolder = "/Users/flatba/dev/java/crawler_practise/data";
			// クローラーの同時実行数
			int numberOfCrawlers = 1;

			CrawlConfig config = new CrawlConfig();
			// 開始URLから何ポップ先までリンクをたどるか
			config.setMaxDepthOfCrawling(1);
			// クローラーのデータを保持するディレクトリ
			config.setCrawlStorageFolder("/Users/flatba/dev/java/crawler_practise/data");

			// CrawlControllerを準備する
			PageFetcher pageFecher = new PageFetcher(config);
			RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
			RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFecher);
			CrawlController controller;
			try {
				controller = new CrawlController(config, pageFecher, robotstxtServer);
				// クロールを開始するURLを指定
				controller.addSeed("http://takezoe.hatenablog.com/");
				// クロールを開始
				controller.start(HatenaArticleCrawler.class, numberOfCrawlers);
			} catch (Exception ex) {
				Logger.getLogger(Crawler4j.class.getName()).log(Level.SEVERE, null, ex);
			}

	}
}

