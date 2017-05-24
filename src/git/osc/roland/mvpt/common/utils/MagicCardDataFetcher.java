package git.osc.roland.mvpt.common.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 网络获取万智牌数据
 * Created by eka on 2017/5/24.
 */
public class MagicCardDataFetcher {

    private String webSite = "http://magiccards.info";

    public void fetchData(String strUrl) throws Exception {
        Document doc = Jsoup.connect(strUrl).get();
        Elements links = doc.select("a[href^=/ori/cn/]");
        List<String> cardLinks = new ArrayList<>();
        for (Element link : links) {
            cardLinks.add(link.attr("href"));
        }

    }

    public void fetchData2(String strUrl) throws Exception {
        String fullUrl = webSite + strUrl;
        Document doc = Jsoup.connect(fullUrl).get();

        Element nameElement = doc.select(String.format(Locale.US, "a[href=%s]", strUrl)).first();
        Element typeElement = nameElement.parent().nextElementSibling();
        Element funcElement = typeElement.nextElementSibling().child(0);
        Element descElement = doc.select("div.oo").first().nextElementSibling().child(0);
    }
}
