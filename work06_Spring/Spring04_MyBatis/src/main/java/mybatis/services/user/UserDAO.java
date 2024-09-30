package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

// 비즈니스 로직의 템플릿...
// ~mapping10.xml을 보고 작성...
// 해당 파일의 id값이 함수 이름으로 / parameterType이 인자값으로 / resultMap이 반환타입으로
public interface UserDAO {
	int addUser(User user) throws Exception;
	int removeUser(String userId) throws Exception;
	int updateUser(User user) throws Exception;
	
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
