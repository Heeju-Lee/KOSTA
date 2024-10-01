package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

//데이타 가공과 연관되는 레이어..
public interface UserService {
	void addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
