package mybatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;
/*
 * @Component
 * Bean tag가 사라짐
 * Layer 별로 조금 더 디테일하게 부를 수 있는 명칭이 있다.
 * 
 * Presentaion Layer  | Service Layer | persistence Layer
 * 
 * @Controller 			@Service		/@Repository
 * 
 */

@Repository
public class MyBatisUserDAOImpl13 implements UserDAO{

	//setter 안해도 됨.
	@Autowired 
	private SqlSession sqlSession;
	
	public static final String NS = "UserMapper10.";

	@Override
	public int addUser(User user) throws Exception {
		int result = sqlSession.insert(NS+"addUser", user);
		//sqlSession.commit();//DML일때는 반드시
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = sqlSession.delete(NS+"removeUser", userId);
		//sqlSession.commit();//DML일때는 반드시
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update(NS+"updateUser", user);
		//sqlSession.commit();//DML일때는 반드시
		return result;
	}

	@Override
	public User getUser(String userId) throws Exception {
		User user = sqlSession.selectOne(NS+"getUser", userId);
		return user;
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		//List<User> list = sqlSession.selectList(NS+"getUserList", user);
		return sqlSession.selectList(NS+"getUserList", user);
	}
}
