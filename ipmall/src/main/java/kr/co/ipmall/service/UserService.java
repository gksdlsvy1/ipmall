package kr.co.ipmall.service;

import kr.co.ipmall.dao.RegisterRequest;
import kr.co.ipmall.dao.vo.AuthInfo;

public interface UserService {

	/*
	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;

	void insertBoard(Map<String, Object> map) throws Exception;

	Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception;

	void updateBoard(Map<String, Object> map) throws Exception;

	void deleteBoard(Map<String, Object> map) throws Exception;
	*/
	void insertUser(RegisterRequest req) throws Exception;
	void deleteUser(String email) throws Exception;
	void updateUserInfo(RegisterRequest req) throws Exception;

}
