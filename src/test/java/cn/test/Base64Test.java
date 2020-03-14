package cn.test;

import java.util.Arrays;

import org.apache.shiro.codec.Base64;
import org.junit.jupiter.api.Test;


public class Base64Test {

	@Test
	public void test_encode() {
		byte[] bytes = {'A','A'} ;
		System.out.println("ASKII:" + Arrays.toString(bytes));
		String code = Base64.encodeToString(bytes);
		System.out.println("code:"+code);
		String decode = Base64.decodeToString(code);
		System.out.println("decode:"+decode);
	}
	
	
	
}
