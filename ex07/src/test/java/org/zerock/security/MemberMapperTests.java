package org.zerock.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/security-context.xml"
})
@Log4j
public class MemberMapperTests {

	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void testRead() {
		MemberVO vo = mapper.read("admin90");
		
		log.info(vo);
		
		vo.getAuthList().forEach(autoVO -> log.info(autoVO));
	}
	
}
