package com.ltf.controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ltf.test.Tea;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dreamneverdie
 *
 */
@Slf4j
@SpringBootTest(classes = SampleController.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@AutoConfigureMockMvc
public class SampleControllerTest {
	@Autowired
	private MockMvc mvc;

	/**
	 * @throws Exception	捕捉mock url请求时候的异常
	 *          
	 */
	@Test
	public void home() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(""));

	}

	/**
	 * @throws Exception
	 */

	@Test

	public void json()  {

		// String json="{\"name\":\"puer\"}";
		String json2 = "{\"place\":\"上海\"}";
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", json2);
		map.put("name", "puer");
		Gson gson = new Gson();
		log.info(map.toString());
		java.lang.reflect.Type type = new TypeToken<Tea>() {
		}.getType();
		Tea tea = gson.fromJson(map.toString(), type);
		log.info(tea.toString());
	}

}
