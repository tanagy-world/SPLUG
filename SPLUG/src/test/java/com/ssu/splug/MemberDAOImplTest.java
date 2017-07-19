package com.ssu.splug;

import javax.inject.Inject;

import org.junit.Test;

import com.ssu.domain.MemberVO;
import com.ssu.persistence.MemberDAO;

public class MemberDAOImplTest extends AbstractTest {
	@Inject
	private MemberDAO dao;
	
	@Test
	public void test() {
		logger.info(""+dao);
	}
	
	@Test
	public void getTimeTest() {
		logger.info(""+dao.getTime());
	}
	
	@Test
	public void registerTest(){
		MemberVO vo = new MemberVO();
		vo.setUserid("ejid");
		vo.setUserpw("ejpw");
		vo.setUsername("ejg");
		vo.setEmail("ej@g.com");
		
		// DB???ｊ퀬 DB?뚯씠釉붿뿉??吏곸젒 ?뺤씤?대킄???쒕떎.
		dao.register(vo);
	}
	
	@Test
	public void getTest(){
		logger.info(""+dao.get("wjheoid"));
	}
	
	@Test
	public void getListTest(){
		logger.info(""+dao.getList());
	}
	

}
