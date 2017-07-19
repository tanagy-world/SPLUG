package com.ssu.splug;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring"
		+ "/**/*-context.xml" })
public class ApplicationContextTest {

	@Inject
	private ApplicationContext ctxt;
	
	@Test
	public void test() {
		System.out.println(ctxt);
	}// test()

}// class
