package com.care.root;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.care.root.member.controller.MemberController;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.mybatis.member.MemberMapper;
import com.care.root.member.service.MemberService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
		"classpath:testMember.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		})
public class testMember {
	@Autowired MemberController mc;
	@Autowired MemberService ms;
	@Autowired MemberMapper mapper;
	MockMvc mock;
	@Before
	public void setup() {
		System.out.println("@Test 실행전 실행됩니다.");
		// memberController로 실행 할 수 있는 객체 생성
		mock = MockMvcBuilders.standaloneSetup(mc).build();
	}
	// 객체 확인
	@Test
	public void testMc() {
		System.out.println("mc : "+mc);
		assertNotNull(mc); // null 이 아니면 성공
	}
	@Test
	public void testMs() {
		System.out.println("ms : "+ms);
		assertNotNull(ms); // null 이 아니면 성공
	}
	@Test
	public void testMapper() {
		System.out.println("mapper : "+mapper);
		assertNotNull(mapper); // null 이 아니면 성공
	}
	// index 실행 테스트
	@Test
	public void index() throws Exception {
		System.out.println("------ test 실행 됨");
		mock.perform(get("/index"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("default/main"));
	}
	//login 실행 테스트
	@Test
	@Transactional(transactionManager = "txMgr")
	public void loginTest() throws Exception {
		System.out.println("------ test 실행 됨");
		mock.perform(post("/loginChk")
				.param("dto.id", "aaa")
				.param("dto.pw","aaa")
				)
		.andDo(print())
		.andExpect(status().isOk());

	}
	
	@Test
	@Transactional(transactionManager = "txMgr")
	public void testInsert() throws Exception {
		mock.perform(post("/insert")
				.param("id","111")
				.param("pw","111")
				.param("addr","구구비둘기"))
				.andDo(print())
				.andExpect(status().is3xxRedirection());
	}
}
