package com.ssu.splug;

import java.sql.SQLException;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring"
		+ "/**/*-context.xml" })
public class DBConnTest {

	@Inject
	private DataSource ds;
	
	@Test
	public void test() throws Exception {
		System.out.println(ds.getConnection());
	}// test()

}// class
