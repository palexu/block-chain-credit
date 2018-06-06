package top.palexu.blockchaincredit.user.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.palexu.blockchaincredit.user.common.Const;
import top.palexu.blockchaincredit.user.common.LoginEnum;
import top.palexu.blockchaincredit.user.common.ResponseCode;
import top.palexu.blockchaincredit.common.ServerResponse;
import top.palexu.blockchaincredit.user.model.User;
import top.palexu.blockchaincredit.user.service.IUserService;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by thRShy on 2017/5/1.
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    /**
     * 用户登录
     *
     * @param session
     * @return
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public ServerResponse<User> login(@RequestBody Map<String, String> map, HttpSession session) {
        ServerResponse<User> response = iUserService.login(map.get("username"), map.get("password"));
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;

    }

    @GetMapping(value = "/logout")
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public ServerResponse<String> register(@RequestBody User user) {
        return iUserService.register(user);
    }

    @GetMapping(value = "/checkValid")
    @ResponseBody
    public ServerResponse<String> checkValid(String str, String type) {
        return iUserService.checkValid(str, type);
    }

    @GetMapping(value = "/getUserInfo")
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByError(LoginEnum.USER_NO_LOGIN.getMsg());
    }

    @GetMapping(value = "/forgetPasswdGetQuestion")
    @ResponseBody
    public ServerResponse<String> forgetPasswdGetQuestion(String username) {
        return iUserService.selectQuestion(username);
    }

    @GetMapping(value = "/forgetPasswdCheckAnswer")
    @ResponseBody
    public ServerResponse<String> forgetPasswdCheckAnswer(String username, String question, String answer) {
        return iUserService.checkAnswer(username, answer, question);
    }

    @GetMapping(value = "/forgetResetPassword")
    @ResponseBody
    public ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken) {
        return iUserService.forgetResetPassword(username, passwordNew, forgetToken);
    }

    @GetMapping(value = "ResetPassword")
    @ResponseBody
    //登录状态下的修改密码
    public ServerResponse<String> resetPassword(HttpSession session, String passwordNew, String passwordOld) {
        User user = (User) session.getAttribute(Const.USERNAME);
        if (user == null) {
            return ServerResponse.createByError("用户未登录");
        }
        return iUserService.resetPassword(passwordNew, passwordOld, user);
    }

    @PostMapping(value = "updateInformation")
    @ResponseBody
    public ServerResponse<User> update_information(HttpSession session, User user) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByError("用户未登录");
        }
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> response = iUserService.updateInformation(user);
        if (response.isSuccess()) {
            response.getData().setUsername(currentUser.getUsername());
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    @PostMapping(value = "getInformation")
    @ResponseBody
    public ServerResponse<User> get_information(HttpSession session) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录,需要强制登录status=10");
        }
        return iUserService.getInformation(currentUser.getId());
    }
}
