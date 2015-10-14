package JsoupCrawler.home;

//import java.net.URL;
import java.util.List;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.parser.Parser;
//import org.jsoup.select.Elements;

import crawlerService.home.travelTaichungService;

public class webCrawler {

	/**
	 * 爬蟲網站取得Html
	 * 
	 * @param resolveUrls
	 *            要解析的網址
	 * @throws Exception
	 *             錯誤資訊
	 */
	public void CrawlerGetHtml(List<String> resolveUrls) throws Exception {
		for (String resolveUrl : resolveUrls) {
			final String url = resolveUrl;
			Thread thread = new Thread() {
				public void run() {
					try {
						System.out.println("執行緒:" + Thread.currentThread().getName());
						System.out.println("開始");
						if (url.indexOf("travel.taichung") > 0) {
							travelTaichungService.AnalysisTravelTaichung(url);
						}
						System.out.println("執行緒:" + Thread.currentThread().getName());
						System.out.println("結束");
					} catch (Exception e) {
						System.out.println("執行緒:" + Thread.currentThread().getName());
						System.out.println(e.toString());
					}
				}
			};
			thread.setName(resolveUrl);
			thread.start();
		}
	}

}
