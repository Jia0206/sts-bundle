package com.spring.myweb.user.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.myweb.user.entity.User;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserMapperTest {

	@Autowired
	private IUserMapper mapper;
	
	@Test
    @DisplayName("회원 가입을 진행했을 때 회원가입이 성공해야 한다.")
    void registTest() {            
		User user = User.builder()
						.userId("abc1234")						
						.userPw("aaa1111")
						.userName("임지아")
				 		.userPhone1("010")
				 		.userPhone2("010-9")
				 		.userEmail1("@")
				 		.userEmail2("@")
				 		.addrBasic("서울")
				 		.addrDetail("동 호수")
				 		.addrZipNum("040")
						.build();
		     
	    mapper.join(user);
		
    }
    
   

	@Test
    @DisplayName("존재하는 회원 아이디를 조회했을 시 1이 리턴되어야 한다.")
    void checkIdTest() {
        	String id = "abc1234";        	
        	assertEquals(1, mapper.idCheck(id));
    }
    
    @Test
    @DisplayName("존재하는 회원 아이디를 입력 했을 시 그 회원의 비밀번호가 리턴되어야 한다.")
    void loginTest() {    	
    		String id = "abc1234";
    	
    		assertNotNull(mapper.login(id));
    		assertEquals("aaa1111!",mapper.login(id));
    	
    }
    
    @Test
    @DisplayName("존재하지 않는 회원의 아이디를 전달하면 null이 올 것이다.")
    void getInfoTest() {
    	assertNull(mapper.getInfo("merong"));
    	
    	
    }
    
    @Test
    @DisplayName("id를 제외한 회원의 정보를 수정할 수 있어야 한다.")
    void updateTest() {
        
    	User user = User.builder()
		    			.userId("abc1234")
		    			.userPw("aaa1111!")
		    			.userName("조호석")
	    				.userEmail1("abc4321")
	    				.userEmail2("gmail.com")
	    				.addrBasic("서울")
	    				.addrDetail("040")
	    				.addrZipNum("154")
	    				.build();
    	mapper.updateUser(user);
    	assertEquals(user.getUserEmail1(), mapper.getInfo("abc1234").getUserEmail1());
    				
    }
	
	
		
}
