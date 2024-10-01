package spring.service.dao;

// 비즈니스 로직 template이 있어야 함
public interface MemberDAO {
	void register(String id, String pass);
	void delete(String id, String pass);
}
