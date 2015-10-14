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
	 * ���κ������oHtml
	 * 
	 * @param resolveUrls
	 *            �n�ѪR�����}
	 * @throws Exception
	 *             ���~��T
	 */
	public void CrawlerGetHtml(List<String> resolveUrls) throws Exception {
		for (String resolveUrl : resolveUrls) {
			final String url = resolveUrl;
			Thread thread = new Thread() {
				public void run() {
					try {
						System.out.println("�����:" + Thread.currentThread().getName());
						System.out.println("�}�l");
						if (url.indexOf("travel.taichung") > 0) {
							travelTaichungService.AnalysisTravelTaichung(url);
						}
						System.out.println("�����:" + Thread.currentThread().getName());
						System.out.println("����");
					} catch (Exception e) {
						System.out.println("�����:" + Thread.currentThread().getName());
						System.out.println(e.toString());
					}
				}
			};
			thread.setName(resolveUrl);
			thread.start();
		}
	}

}
