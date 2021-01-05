package web.com.until;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	/**
	 * MD5工具类
	 * 
	 * MD5加密方法
	 * @param String
	 * @return String 
	 */
	public static String getEncodeByMd5(String str) {
		try {
			int i;
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();
			
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			//返回string字符串
			return buf.toString();
			
			// return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			// e.printStackTrace();
			return null;
		}

	}

}
