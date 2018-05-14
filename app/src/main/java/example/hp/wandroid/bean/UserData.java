package example.hp.wandroid.bean;

/**
 * {"collectIds":[2796,2196,2911,2910],"email":"","icon":"","id":5672,"password":"123456","type":0,"username":"abc"}
 */
public class UserData {
    String username;  //名字
    String password;  //密码
    String icon;  //头像资源id


    public UserData(String name, String password, String headIcoRes) {
        this.username = name;
        this.password = password;
        this.icon = headIcoRes;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadIcoRes() {
        return icon;
    }

    public void setHeadIcoRes(String headIcoRes) {
        this.icon = headIcoRes;
    }
}
