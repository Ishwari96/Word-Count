package com.words.counting.words;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Method;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CountingWordsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void ApplicationStartTest() {
		CountingWordsApplication.main(new String[] {});
	}
	
}
