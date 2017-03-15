package model.bo;

import model.bean.Login;
import model.dao.LoginDAO;;

public class LoginBO {

	LoginDAO loginDAO = new LoginDAO();

	//Gọi hàm kiểm tra đăng nhập ở lớp DAO với đối tượng loginAccount
	public boolean checkLogin(Login loginAccount) {
		return loginDAO.checkLogin(loginAccount);
	}
	
}
