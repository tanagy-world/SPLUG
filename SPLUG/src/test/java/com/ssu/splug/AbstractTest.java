package com.ssu.splug;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/* 紐⑤뱺 ?뚯뒪???뚯씪???곸냽??異붿긽?대옒??
 * - ?대끂?뚯씠???먮룞 異붽?
 * - Logger 
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public abstract class AbstractTest {

	protected static final Logger logger = 
			LoggerFactory.getLogger(AbstractTest.class);

}
