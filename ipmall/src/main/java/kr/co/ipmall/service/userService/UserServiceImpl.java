package kr.co.ipmall.service.userService;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

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

	
	/////////////////////////////////// 이부분 newUser객체로 초기화해서 넣어야되는지 아니면 그냥 user 사용하면 customer 같은 자식 클래스에 값이 자동으로 저장되는지 확인해봐야됨
	@Override
	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
		// select 유저를 통해 DB에 해당 email이 있는지 검색
		User newUser = userDAO.selectUser(user);	
		System.out.println("After selectUser");

		
		// email이 있는 경우 exception 처리
		if(newUser != null)
			throw new kr.co.ipmall.model.exception.AlreadyExistingUserException("dup email " + user.getEmail());
		System.out.println("After check email");
		
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
		/*
		if(((Seller)newUSer).getBrNumber() == user.getBrNumber())
			throw new kr.co.ipmall.model.exception.AlreadyExistingUserException("dup email " + user.getEmail());*/
		
		/*
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
			
		}*/
			userDAO.insertUser(newUser);
			
	}
	
	public void deleteUser(String email) throws Exception{
		userDAO.deleteUser(email);
	}
	
	///////////// 이 부분도 customer 고유의 변수도 초기화 되는지 확인해 봐야됨
	public void updateUserInfo(User user) throws Exception {
		/*User user = new Customer(req.getEmail(), req.getPassword(), req.getName(), req.getPhone(), req.getLevel(), new Date(), new Date(),
				req.getAccountNum(), req.getAccountName(), req.getStatus(), req.getBirthday(), req.getSex());*/
		userDAO.updateUser(user);
	}
	
	@SuppressWarnings("unused")
	public User authenticate(String email, String password) throws Exception{

		// User 객체로 곧바로 받을 수 없기 때문에 user 초기화를 통해 객체 생성
		System.out.println("User Service : authenticate!!!");
		User user = userDAO.selectByEmail(email);
		System.out.println("user : " + user.getAccountName());
		
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

}
