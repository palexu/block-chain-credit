package top.palexu.blockchaincredit.user.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.palexu.blockchaincredit.user.model.User;

@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUserName(String username);

    int checkEmail(String email);

    User userLogin(@Param("username") String username, @Param("password") String password);

    String selectQuestionByUsername(String username);

    int checkAnswer(@Param("username")String username,@Param("answer")String answer,@Param("question")String question);

    int updatePasswdByUserName(@Param("username")String username,@Param("password")String password);

    int checkPassword(@Param("password")String password,@Param("userId") int userId);

    int checkEmailByUserId(@Param("email") String email,@Param("userId") int userId);
}