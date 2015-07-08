package kr.co.ipmall.service;

import java.util.List;
import java.util.Map;

import kr.co.ipmall.dao.RegisterRequest;

public interface UserService {

	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;

	void insertBoard(Map<String, Object> map) throws Exception;

	Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception;

	void updateBoard(Map<String, Object> map) throws Exception;

	void deleteBoard(Map<String, Object> map) throws Exception;
	
	void insertUser(RegisterRequest req) throws Exception;

}
