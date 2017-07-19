/*
 * 2016.04.02 ?뚯뒪???꾨즺
 * by wjheo
 */
package com.ssu.splug;

import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Test;
import com.ssu.persistence.TimeDAO;

public class TimeDAOTest extends AbstractTest{

	@Inject
	private TimeDAO dao;
	
	@Test
	public void test() throws Exception {
		logger.info(""+dao.getTime());
		
	}// test()
}// class

