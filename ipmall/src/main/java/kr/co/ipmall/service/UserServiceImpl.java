package kr.co.ipmall.service;

import java.util.Date;

import javax.annotation.Resource;

import kr.co.ipmall.dao.RegisterRequest;
import kr.co.ipmall.dao.UserDAO;
import kr.co.ipmall.dao.vo.AuthInfo;
import kr.co.ipmall.dao.vo.Customer;
import kr.co.ipmall.dao.vo.Manager;
import kr.co.ipmall.dao.vo.Seller;
import kr.co.ipmall.dao.vo.User;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	/*
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
	}*/

	@Override
	public void insertUser(RegisterRequest req) throws Exception {
		// TODO Auto-generated method stub
		
		// select 유저를 통해 DB에 해당 email이 있는지 검색
		User user = userDAO.selectUser(req);	

		// email이 있는 경우 exception 처리
		if(user != null)
			throw new kr.co.ipmall.model.exception.AlreadyExistingUserException("dup email " + user.getEmail());
		
		User newUser;
		
		// 각 유저 level 별로 구매자, 판매자, 관리자를 나누어 newUser 객체 초기화
		if(req.getLevel() == User.CUSTOMER) {
			
			newUser = new Customer(req.getEmail(), req.getPassword(), req.getName(), req.getPhone(), req.getLevel(), new Date(), new Date(),
					req.getAccountNum(), req.getAccountName(), req.getStatus(), req.getBirthday(), req.getSex());
			
		} else if(req.getLevel() == User.SELLER) {
			
			newUser = new Seller(req.getEmail(), req.getPassword(), req.getName(), req.getPhone(), req.getLevel(), new Date(), new Date(),
					req.getAccountNum(), req.getAccountName(),req.getStatus(), req.getAddress(), req.getBrNumber());
			
		} else {	// MANAGER
			
			newUser = new Manager(req.getEmail(), req.getPassword(), req.getName(), req.getPhone(), req.getLevel(), new Date(), new Date(),
					req.getAccountNum(), req.getAccountName(),req.getStatus(), req.getDepartment(), req.getPosition());
			
		}
		
		userDAO.insertUser(newUser);
			
	}
	
	public void deleteUser(String email) throws Exception{
		userDAO.deleteUser(email);
	}
	
	public void updateUserInfo(RegisterRequest req) throws Exception {
		User user = new Customer(req.getEmail(), req.getPassword(), req.getName(), req.getPhone(), req.getLevel(), new Date(), new Date(),
				req.getAccountNum(), req.getAccountName(), req.getStatus(), req.getBirthday(), req.getSex());
		userDAO.updateUser(user);
	}

}
