package com.spring.myweb.user.mapper;

import com.spring.myweb.user.entity.User;

public interface IUserMapper {

	//아이디 중복확인
	int idCheck(String id);	
	
	//회원 가입
	void join(User user);
	
	//로그인
	//아이디를 통해 비밀번호를 조회하는 메서드
	String login(String id);
	
	//회원 정보 얻어오기
	User getInfo(String id);
		
	//회원 정보 수정
	void updateUser(User user);
	
}
