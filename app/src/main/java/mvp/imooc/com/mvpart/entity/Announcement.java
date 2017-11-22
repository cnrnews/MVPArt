package mvp.imooc.com.mvpart.entity;

/**
 * @author:candy
 * @date:2017/11/22 14:27
 * @邮箱:1601796593@qq.com
 */
public class Announcement {

    /**
     * id : 134
     * user_id : 21
     * title : 中共十九大后，中国最高领导人首次亮相国际多边舞台，
     * pic : ["\/Uploads\/Companybull\/2017-11-20\/5a1289e1059da.jpg","\/Uploads\/Companybull\/2017-11-20\/5a1289e10602e.jpg","\/Uploads\/Companybull\/2017-11-20\/5a1289e10658a.jpg"]
     * bullurl :
     * content : 中共十九大后，中国最高领导人首次亮相国际多边舞台，世界目光紧紧追随，期盼聆听中国声音，阅读中国方案。11月10日，亚太经合组织工商领导人峰会进入最重要的一天——习近平主席出席峰会并发表主旨演讲。题为《抓住世界经济转型机遇谋求亚太更大发展》的演讲，35分钟，17次掌声！
     * addtime : 1511164385
     */

    private String id;
    private String user_id;
    private String title;
    private String pic;
    private String bullurl;
    private String content;
    private String addtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getBullurl() {
        return bullurl;
    }

    public void setBullurl(String bullurl) {
        this.bullurl = bullurl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
