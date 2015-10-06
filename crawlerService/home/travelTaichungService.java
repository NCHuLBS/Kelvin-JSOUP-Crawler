package crawlerService.home;

import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import crawlerService.home.commonService;

public class travelTaichungService {

	/**
	 * �ѪR�O���[���ȹC��--�̷s����������
	 * 
	 * @param resolveUrl
	 *            �ѪR�����}
	 * @throws Exception
	 *             ���~��T
	 */
	public static void AnalysisTravelTaichung(String resolveUrl) throws Exception {
		URL url = new URL(resolveUrl);
		Document xmlDoc = Jsoup.parse(url, 5000);
		Elements linkAs = xmlDoc.select("ul.news-list").select("h3.icon-paper").select("a");
		// AnalysisTravelTaichungNewsDetail(linkAs.get(3).absUrl("href"));
		for (Element element : linkAs) {
			try {
				AnalysisTravelTaichungNewsDetail(element.absUrl("href"));
			} catch (Exception e) {
				System.out.println(e.toString());
				continue;
			}
		}
	}

	/**
	 * �ѪR�O���[���ȹC��--�̷s�������ԲӸ�T����
	 * 
	 * @param resolveUrl
	 *            �ѪR�����}
	 * @throws Exception
	 *             ���~��T
	 */
	private static void AnalysisTravelTaichungNewsDetail(String resolveUrl) throws Exception {
		URL url = new URL(resolveUrl);
		Document xmlDoc = Jsoup.parse(url, 5000);
		String title = xmlDoc.select("h2.page-name").text();
		String publishDate = xmlDoc.select("p.publish-date").text().replace("�o�G��� ", "");
		String decription = xmlDoc.select("div.act-sum").text().trim();
		String messageContent = xmlDoc.select("div.act-desc").html().trim();
		messageContent = commonService.FiltrationHtmlSpeciallyTags(messageContent);
		messageContent = commonService.FiltrationHtmlEspeciallyTags(messageContent);

		System.out.println(title);
		System.out.println(publishDate);
		System.out.println(decription);
		System.out.println(messageContent);
		System.out.println("");
	}
}
