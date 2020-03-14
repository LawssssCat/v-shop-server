package cn.test;

import java.util.UUID;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;

public class UUIDTest {

	@Test
	public void test_UUID() {
		String algorithmName = Md5Hash.ALGORITHM_NAME; // 加密算法名
		Object source = "asdf123"; // 密码明文
		String salt = UUID.randomUUID().toString(); // 盐值
		int hashIterations = 3; // 加密次数
		SimpleHash hash = new SimpleHash(algorithmName, source, salt, hashIterations);
		// show
		System.out.println("加密算法:" + algorithmName);
		System.out.println("加密次数" + hashIterations);
		System.out.println("加密盐值:" + salt);
		System.out.println("盐值长度:" + salt.length());
		System.out.println("加密结果:" + hash.toString());
		System.out.println("密文长度:" + hash.toString().length());
		System.out.println("原密码:" + source);
	}
}
