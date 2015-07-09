package kr.co.ipmall.dao;

import java.util.Map;

import kr.co.ipmall.dao.vo.User;
import kr.co.ipmall.model.exception.UserNotFoundException;

import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO extends AbstractDAO{

	/*
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("view.selectBoardList", map);
	}

	public void insertBoard(Map<String, Object> map) throws Exception{
		insert("view.insertBoard", map);
	}

	public void updateHitCnt(Map<String, Object> map) throws Exception{
		update("view.updateHitCnt", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception{
		return (Map<String, Object>) selectOne("view.selectBoardDetail", map);
	}

	public void updateBoard(Map<String, Object> map) throws Exception{
		update("view.updateBoard", map);
	}

	public void deleteBoard(Map<String, Object> map) throws Exception{
		update("view.deleteBoard", map);
	}*/

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		
		// user 공통의 기본 정보 insert
		insert("user.insertUser",user);
		
		// 각각의 추가 정보 insert 
		if(user.getLevel() == User.CUSTOMER) {
			insert("user.insertCustomer",user);
		} else if(user.getLevel() == User.SELLER) {
			insert("user.insertSeller",user);
		} else {
			insert("user.insertManager",user);
		}
	}
	
	@SuppressWarnings("unchecked")
	public User selectUser(RegisterRequest req) {
		return (User)selectOne("user.selectUser",req);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectByEmail(String email) {
		try{
			return (Map<String, Object>)selectOne("user.selectUser",email);
		} catch(UserNotFoundException ex) {
			return null;
		}
		
	}
	
	public void changePwd(User user) {
		update("user.updatePwd",user);
	}
	
	public void deleteUser(String email) {
		delete("user.deleteUser",email);
	}
	
	public void updateUser(User user) {
		update("updateUser",user);
	}

}
