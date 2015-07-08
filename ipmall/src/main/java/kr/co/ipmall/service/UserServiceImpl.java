package kr.co.ipmall.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.ipmall.dao.RegisterRequest;
import kr.co.ipmall.dao.UserDAO;
import kr.co.ipmall.dao.vo.User;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return userDAO.selectBoardList(map);
		
	}

	@Override
	public void insertBoard(Map<String, Object> map) throws Exception {
		userDAO.insertBoard(map);
	}

	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		userDAO.updateHitCnt(map);
		Map<String, Object> resultMap = userDAO.selectBoardDetail(map);
		return resultMap;
	}

	@Override
	public void updateBoard(Map<String, Object> map) throws Exception{
		userDAO.updateBoard(map);
	}

	@Override
	public void deleteBoard(Map<String, Object> map) throws Exception {
		userDAO.deleteBoard(map);
	}

	@Override
	public void insertUser(RegisterRequest req) throws Exception {
		// TODO Auto-generated method stub
		User user = userDAO.selectUser(req);
		if(user != null)
			throw new kr.co.ipmall.model.exception.AlreadyExistingUserException("dup email " + user.getEmail());
		
		User newUser = new User(req.getEmail(), req.getPassword(), req.getName(), req.getPhone(), new Date(), new Date(),
		req.getAccountNum(), req.getAccountName());
		userDAO.insertUser(newUser);
			
	}

}
