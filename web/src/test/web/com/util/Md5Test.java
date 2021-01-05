package test.web.com.util;

import web.com.until.MD5Util;

public class Md5Test {

	public static void main(String[] args) {
		//≤‚ ‘md5π§æﬂ¿‡
		String str1 = MD5Util.getEncodeByMd5("root");
		String str2 = MD5Util.getEncodeByMd5("root1");
		System.out.println(str2);
		System.out.println(str1.length());
		System.out.println(str1.equals(str2));
	}

}
