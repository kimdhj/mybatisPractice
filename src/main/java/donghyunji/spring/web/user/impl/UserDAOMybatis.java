package donghyunji.spring.web.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import donghyunji.spring.web.user.UserVO;

@Repository
public class UserDAOMybatis {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public UserVO getUser(UserVO vo) {
		System.out.println("---> Mybatis�� getUser() ��� ó��");
		return (UserVO) sqlSessionTemplate.selectOne("UserDAO.getUser", vo);
	}
}
