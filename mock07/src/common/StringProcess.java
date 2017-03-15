package common;

/**
 * StringProcess.java
 *
 * Version 1.0
 *
 * Date: Jan 20, 2015
 *
 * Copyright
 *
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * ----------------------------------------------------------------------- Jan
 * 20, 2015 DaiLV2 Create
 */

public class StringProcess {

	/**
	 * Ham tra ve gioi tinh: 1=Nam, 0=Nu
	 * 
	 * @param val
	 * @return String
	 */
	public static String gioiTinh(String val) {
		if ("0".equals(val)) {
			return "Nữ";
		}
		return "Nam";
	}

	/**
	 * Ham in ra mot xau, null in ra xau rong
	 * 
	 * @param s
	 * @return String
	 */
	public static String getVaildString(String s) {
		if (s == null)
			return "";
		return s;
	}

	/**
	 * Ham kiem tra xau rong hay khong
	 * 
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaild(String s) {
		if (s == null || s.length() == 0)
			return true;
		return false;
	}

	/**
	 * Ham kiem tra xem xau co bao gom chi chu so hay khong
	 * 
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaildNumber(String s) {
		if (notVaild(s))
			return true;
		String regex = "[0-9]+";
		if (s.matches(regex))
			return false;
		return true;
	}

	public static boolean notVaildEmail(String email) {
		if ( email.length() > 0 && email.length() < 6)
			return true;
		return false;
	}

	public static boolean notVaildLevel(int level) {
		if (level == 1 || level == 2 || level == 3)
			return false;
		return true;
	}

	public static boolean notVaildPassword(String password) {
		if ( password.length() > 0 && password.length() < 6)
			return true;
		return false;
	}

	public static boolean notVaildPasswordMatch(String password, String rePassword) {
		if(password.equals(rePassword))
			return false;
		return true;
	}
}
