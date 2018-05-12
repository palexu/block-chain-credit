package top.palexu.blockchaincredit.user.common;

/**
 * 常量类
 * Created by thRShy on 2017/5/1.
 */
public class Const {

    public static final String CURRENT_USER = "current_user";

    public static final String EMAIL = "email";

    public static final String USERNAME = "username";

    public interface Role {
        int ROLE_ADMIN = 0;
        int ROLE_PERSON = 1;
        int ROLE_ORG = 2;
    }
}
