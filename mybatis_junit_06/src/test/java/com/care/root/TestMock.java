package com.care.root;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
		"classpath:testMember.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		})
public class TestMock {
	@Autowired MemberController mc;
	MockMvc mock;
	
	@Before
	public void setup() {
		System.out.println("@Test 실행전 실행됩니다.");
		// memberController로 실행 할 수 있는 객체 생성
		mock = MockMvcBuilders.standaloneSetup(mc).build();
	}
	@Test
	public void testIndex() throws Exception {
		System.out.println("------ test 실행 됨");
		// 해당 경로로 연락을 취해줌
		mock.perform(get("/index"))
		.andDo(print())
		// 현재 요청정보 200이면 성공
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("member/index"));
	}
	@Test
	public void testMemberView() throws Exception {
		mock.perform(get("/memberview"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("member/memberview"))
		.andExpect(model().attributeExists("list"));
	}
	@Test
	@Transactional(transactionManager = "txMgr")
	public void testInsert() throws Exception {
		mock.perform(post("/insert")
				.param("id","999")
				.param("name","구구비둘기"))
				.andDo(print())
				.andExpect(status().is3xxRedirection());
	}
}
