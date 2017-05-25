package git.osc.roland.mvpt.common.utils.dbfetch;

import git.osc.roland.mvpt.common.domain.MagicCard;
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

    private String webSite;

    private String setName;

    private String lanCode;

    private List<String> cardLinks = null;

    private List<MagicCard> cards = null;

    private boolean running = true;

    private int index = 0;

    private DbFetchProgressListener progressListener = null;

    public MagicCardDataFetcher(String webSite, String setName, String lanCode) {
        this.webSite = webSite;
        this.setName = setName;
        this.lanCode = lanCode;
    }

    /**
     * 开始
     */
    public void start() {
        cards = new ArrayList<>();
        running = true;
        index = 0;
        try {
            cardLinks = fetchCardLinkList();
            while (running && index < cardLinks.size()) {
                cards.add(fetchCard(cardLinks.get(index)));
                if (progressListener != null) {
                    progressListener.onProgress(index);
                }
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 停止
     */
    public void stop() {
        running = false;
    }

    /**
     * 继续抽取
     */
    public void resume() {
        try {
            while (running && index < cardLinks.size()) {
                cards.add(fetchCard(cardLinks.get(index)));
                if (progressListener != null) {
                    progressListener.onProgress(index);
                }
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return 获取最大进度
     */
    public int getProgressMax() {
        return cardLinks.size();
    }

    /**
     * 对卡牌列表界面进行抽取
     * @return 卡牌详细信息相对路径列表
     */
    private List<String> fetchCardLinkList() throws Exception {
        String strUrl = String.format(Locale.US, "%s/%s/%s.html", webSite, setName, lanCode);
        List<String> links = new ArrayList<>();
        Document doc = Jsoup.connect(strUrl).get();
        String selector = String.format(Locale.US, "a[href^=/%s/%s/]", setName, lanCode);
        Elements linksElements = doc.select(selector);
        for (Element link : linksElements) {
            links.add(link.attr("href"));
        }
        return links;
    }

    /**
     * 对卡片详细信息页面进行抽取
     * @param strUrl 相对路径
     * @return 卡牌对象
     */
    private MagicCard fetchCard(String strUrl) throws Exception {
        String fullUrl = webSite + strUrl;
        Document doc = Jsoup.connect(fullUrl).get();

        Element nameElement = doc.select(String.format(Locale.US, "a[href=%s]", strUrl)).first();
        Element typeElement = nameElement.parent().nextElementSibling();
        Element funcElement = typeElement.nextElementSibling().child(0);
        Element descElement = doc.select("div.oo").first().nextElementSibling().child(0);

        MagicCard card = new MagicCard();
        card.setName(nameElement.text());
        card.setType(typeElement.text());
        card.setFunction(funcElement.text());
        card.setDescribe(descElement.text());

        return card;
    }

    public void setProgressListener(DbFetchProgressListener progressListener) {
        this.progressListener = progressListener;
    }
}
