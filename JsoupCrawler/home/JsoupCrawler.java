package JsoupCrawler.home;

import java.util.ArrayList;
import java.util.List;

public class JsoupCrawler {

	private static List<String> resolveUrls = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// dbService dbservice = new dbService();
		// System.out.println(dbservice.dbServiceGetValue());
		AddResolveUrls();
		webCrawler webcrawler = new webCrawler();
		try {
			webcrawler.CrawlerGetHtml(resolveUrls);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private static void AddResolveUrls() {
		resolveUrls.add("http://travel.taichung.gov.tw/zh-tw/Event/News");// 臺中觀光旅遊網--最新消息
//		resolveUrls.add("http://travel.taichung.gov.tw/zh-tw/Event/News?page=17");// 臺中觀光旅遊網--最新消息
	}
}
