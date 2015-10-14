package crawlerService.home;

import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import commonViewModels.home.dataTableViewModels;
import commonViewModels.home.sqlParameterViewModels;
import dbService.home.dbService;

public class travelTaichungService {

	/**
	 * 解析臺中觀光旅遊網--最新消息的頁面
	 * 
	 * @param resolveUrl
	 *            解析的網址
	 * @throws Exception
	 *             錯誤資訊
	 */
	public static void AnalysisTravelTaichung(String resolveUrl) throws Exception {
		URL url = new URL(resolveUrl);
		Document xmlDoc = Jsoup.parse(url, 5000);
		Elements linkAs = xmlDoc.select("ul.news-list").select("h3.icon-paper").select("a");
		boolean firstIsExists = travelTaichungService.CheckHtmlIsExist(linkAs.get(0).absUrl("href"));
		if (firstIsExists) {
			return;
		}
		for (Element element : linkAs) {
			try {
				if(travelTaichungService.CheckHtmlIsExist(element.absUrl("href"))){
					continue;
				}
				AnalysisTravelTaichungNewsDetail(element.absUrl("href"));
			} catch (Exception e) {
				System.out.println(e.toString());
				continue;
			}
		}
		
		Element nextPage = xmlDoc.select("div.page-bar").select("span.next-blk").select("a").first();
		if(nextPage.attr("href").toString().trim() != ""){
			System.out.println("還有下一頁");
			AnalysisTravelTaichung(nextPage.absUrl("href"));
		}
	}

	/**
	 * 解析臺中觀光旅遊網--最新消息的詳細資訊頁面
	 * 
	 * @param resolveUrl
	 *            解析的網址
	 * @throws Exception
	 *             錯誤資訊
	 */
	private static void AnalysisTravelTaichungNewsDetail(String resolveUrl) throws Exception {
		URL url = new URL(resolveUrl);
		Document xmlDoc = Jsoup.parse(url, 5000);
		String title = xmlDoc.select("h2.page-name").text();
		StringBuilder sqlCommand = new StringBuilder(
				"INSERT INTO UnstructuredData ( DataUrl ,DataTitle" + ",HtmlSource ) VALUES ( ? ,? ,? )");
		ArrayList<sqlParameterViewModels> sqlParameters = new ArrayList<sqlParameterViewModels>();
		sqlParameters.add(new sqlParameterViewModels("String", resolveUrl));
		sqlParameters.add(new sqlParameterViewModels("String", title));
		sqlParameters.add(new sqlParameterViewModels("String", xmlDoc.html()));
		new dbService().deServiceExecute(sqlCommand.toString(), sqlParameters);
		System.out.println(title);
		System.out.println(resolveUrl);
	}

	private static boolean CheckHtmlIsExist(String resolveUrl) throws Exception {
		StringBuilder sqlCommand = new StringBuilder("SELECT DataSeq FROM UnstructuredData WHERE DataUrl = ?");
		ArrayList<sqlParameterViewModels> sqlParameters = new ArrayList<sqlParameterViewModels>();
		sqlParameters.add(new sqlParameterViewModels("String", resolveUrl));
		dataTableViewModels dt = new dbService().deServiceGetResultSet(sqlCommand.toString(), sqlParameters);
		return dt.DataRows.size() > 0;
	}
}
