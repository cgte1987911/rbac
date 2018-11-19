/**
 * 
 */
package com.ltf.test;

import org.codehaus.jackson.type.TypeReference;

import com.ltf.utils.JsonMapper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dreamneverdie 2018年11月19日
 */
@Slf4j
@Getter
@Setter
@ToString
public class S extends F {
	private String name;
	private String sex;

	/**
	 * @param args
	 *            主函数 测试对象和json字符串互相转换
	 */
	public static void main(String[] args) {
		F f = new F();
		S s = new S();
		if (f instanceof S) {
			log.info("111");
		}
		if (s instanceof F) {
			log.info("111");
		}

		S s1 = JsonMapper.string2Obj("{\"name\":\"ltf\",\"sex\":\"男\"}", new TypeReference<S>() {
		});
		log.info(s1.toString());

		String str = JsonMapper.obj2String(s1);
		log.info(str);

	}

}
