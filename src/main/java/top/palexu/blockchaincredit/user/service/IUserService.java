package top.palexu.blockchaincredit.user.service;


import top.palexu.blockchaincredit.common.ServerResponse;
import top.palexu.blockchaincredit.user.model.User;

/**
 * Created by thRShy on 2017/5/1.
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username, String answer, String question);

    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String token);

    ServerResponse<String> resetPassword(String passwordNew, String passwordOld, User user);

    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInformation(Integer userId);

    ServerResponse checkAdminRole(User user);
}