package kr.co.ipmall.dao;

import java.util.List;
import java.util.Map;

import kr.co.ipmall.dao.vo.User;

import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO extends AbstractDAO{

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
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		insert("user.insertUser",user);
	}
	
	@SuppressWarnings("unchecked")
	public User selectUser(RegisterRequest req) {
		return (User)selectOne("user.selectUser",req);
	}
	
	public User selectByEmail(String email) {
		return (User)selectOne("user.selectUser",email);
	}


}
