package example.hp.wandroid.model.helper;

public interface SfHelper {
    boolean isLogined();

    void setLogined(boolean isLogined);

    String getUserName();

    void saveUserName(String userName);

    String getUserPW();

    void saveUserPW(String password);

}
