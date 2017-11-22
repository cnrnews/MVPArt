package mvp.imooc.com.mvpart.entity;

/**
 * @author:candy
 * @date:2017/11/22 11:33
 * @邮箱:1601796593@qq.com
 */
public class Contact {

    /**
     * id : 49
     * username : tzhtlwg888
     * logo : /./Uploads/Avatar/2017-11-07/5a01316712ac8.jpg
     * companyname : 北京同舟鸿图文化创意有限公司
     * dimecode : /Home/Index/usercode/id/49.html
     * type : 1
     * state : 0
     */

    private String id;
    private String username;
    private String logo;
    private String companyname;
    private String dimecode;
    private String type;
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getDimecode() {
        return dimecode;
    }

    public void setDimecode(String dimecode) {
        this.dimecode = dimecode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
