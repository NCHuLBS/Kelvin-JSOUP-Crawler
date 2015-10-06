package crawlerService.home;

import java.util.Arrays;
import java.util.List;

public class commonService {

	private static List<String> speciallyTags = Arrays.asList("<br>", "&nbsp;", "&gt;", "&ensp;");

	private static List<String> especiallyTags = Arrays.asList("<img", "<span", "<a", "<strong", "<u", "<p", "</img",
			"</span", "</a", "</strong", "</u", "</p");

	/**
	 * 過濾特殊的Html符號
	 * 
	 * @param originalHtml
	 *            待過濾的Html
	 * @return 過濾後的Html
	 */
	public static String FiltrationHtmlSpeciallyTags(String originalHtml) {
		for (String speciallyTag : speciallyTags) {
			originalHtml = originalHtml.replace(speciallyTag, "");
		}
		return originalHtml;
	}

	/**
	 * 過濾特殊的Html符號
	 * 
	 * @param originalHtml
	 *            待過濾的Html
	 * @return 過濾後的Html
	 */
	public static String FiltrationHtmlEspeciallyTags(String originalHtml) {
		for (String especiallyTag : especiallyTags) {
			int startIndex = originalHtml.indexOf(especiallyTag);
			int endIndex = originalHtml.indexOf(">", startIndex);
			// System.out.println(especiallyTag);
			// System.out.println(originalHtml);
			// System.out.println(startIndex + "," + endIndex);
			if (startIndex >= 0 && endIndex >= 0) {
				originalHtml = originalHtml.substring(0, startIndex)
						+ originalHtml.substring(endIndex + 1, originalHtml.length());
				originalHtml = FiltrationHtmlEspeciallyTags(originalHtml);
			}
		}
		return originalHtml;
	}

}
