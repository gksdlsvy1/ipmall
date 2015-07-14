package kr.co.ipmall.service.userService;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ipmall.dao.UserDAO;
import kr.co.ipmall.model.exception.IdPasswordNotMatchingException;
import kr.co.ipmall.vo.Customer;
import kr.co.ipmall.vo.Manager;
import kr.co.ipmall.vo.Seller;
import kr.co.ipmall.vo.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="userDAO")
	private UserDAO userDAO;

	// 유저 정보 삽입
	// 각 객체 타입에 맞게 insert
	@Override
	@Transactional
	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
		// select 유저를 통해 DB에 해당 email이 있는지 검색
		User newUser = userDAO.selectUser(user);	
		
		// email이 있는 경우 exception 처리
		if(newUser != null)
			throw new kr.co.ipmall.model.exception.AlreadyExistingUserException("dup email " + user.getEmail());
		
		switch(user.getLevel()){
		case User.CUSTOMER :
			newUser = new Customer(user);
			break;
		case User.SELLER :
			newUser = new Seller(user);
			break;
		case User.MANAGER :
			newUser = new Manager(user);
		}

		try{
			userDAO.insertUser(newUser);
		} catch(Exception e) {
			log.error(e);
		}
			
	}
	
	// 유저 삭제
	@Transactional
	public void deleteUser(String email) throws Exception{
		userDAO.deleteUser(email);
	}
	
	// 유저 정보 변경
	@Transactional
	public void updateUserInfo(User user) throws Exception {
		/*User user = new Customer(req.getEmail(), req.getPassword(), req.getName(), req.getPhone(), req.getLevel(), new Date(), new Date(),
				req.getAccountNum(), req.getAccountName(), req.getStatus(), req.getBirthday(), req.getSex());*/
		userDAO.updateUser(user);
	}
	
	// 유저 권한 확인
	@SuppressWarnings("unused")
	@Transactional
	public User authenticate(String email, String password) throws Exception{

		// User 객체로 곧바로 받을 수 없기 때문에 user 초기화를 통해 객체 생성
		User user = userDAO.selectByEmail(email);
		
		/*
		User user = new User((String)map.get("email"), (String)map.get("pw"), (String)map.get("name"), (String)map.get("phone"), (int)map.get("level"),(Date)map.get("create_time"), (Date)map.get("update_time"),
				(String)map.get("account_num"), (String)map.get("account_name"), (int)map.get("status"));*/
		
		// 각 로그인 exception 처리
		if(user == null){
			throw new IdPasswordNotMatchingException();
		}
		if(!user.matchPassword(password)) {
			throw new IdPasswordNotMatchingException();
		}
		
		// 이메일, 이름 반환
		return user;
	}
	
	public int selectUserNo() {
		int customerNo = (int) userDAO.selectOne("user.selectUserNo");
		return customerNo;
	}

}
