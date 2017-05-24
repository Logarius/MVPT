package git.osc.roland.common.utils.xmlParseHandler;


import git.osc.roland.domain.User;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coy on 2017/5/24.
 */
public class UserParseHandler extends DefaultHandler{
    private List<User> users;
    private String currentTag; // 记录当前解析到的节点名称
    private User user; // 记录当前的user

    /**
     * 文档解析开始调用
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        users = new ArrayList<User>();
    }

    /**
     * 文档解析结束后调用
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    /**
     * 节点解析开始调用
     * @param uri : 命名空间的uri
     * @param localName : 标签的名称
     * @param qName : 带命名空间的标签名称
     */
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if ("user".equals(qName)) { // 是一个用户
            for (int i = 0; i < attributes.getLength(); i++) {
//                System.out.println("attributes" + "attribute_name：" + attributes.getLocalName(i)
//                        + "  attribute_value：" + attributes.getValue(i));
                user = new User();
                if("id".equals(attributes.getLocalName(i))){
                    user.setId(Long.parseLong(attributes.getValue(i)));
                }
            }
        }
        currentTag = qName; // 把当前标签记录下来
    }

    /**
     * 节点解析结束后调用
     * @param uri : 命名空间的uri
     * @param localName : 标签的名称
     * @param qName : 带命名空间的标签名称
     */
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        super.endElement(uri, localName, qName);
        if("user".equals(qName)){
            users.add(user);
            user = null;
        }
        currentTag = null;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch,start,length); // 将当前TextNode转换为String
        //System.out.println("characters"+ value + "");
        if("name".equals(currentTag)){  // 当前标签为name标签，该标签无子标签，直接将上面获取到的标签的值封装到当前User对象中
            // 该节点为name节点
            user.setName(value);
        }else if("password".equals(currentTag)){  // 当前标签为password标签，该标签无子标签，直接将上面获取到的标签的值封装到当前User对象中
            // 该节点为password节点
            user.setPassword(value);
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
