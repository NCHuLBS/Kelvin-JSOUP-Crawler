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
			if (resolveUrl.indexOf("travel.taichung") > 0) {
				travelTaichungService.AnalysisTravelTaichung(resolveUrl);
			}
		}
	}

}
