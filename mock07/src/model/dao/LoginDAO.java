package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.bean.Login;
import statics.InfoSQLServer;
import statics.Log;

public class LoginDAO {

	// Khai báo các biến để kết nối vs csdl, lưu tại class InfoSQLServer
	String url = InfoSQLServer.url;
	String userName = InfoSQLServer.userName;
	String password = InfoSQLServer.password;
	Connection connection;

	void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC loi");
		}
	}

	// Kiểm tra đăng nhập với đối tượng loginAccount
	public boolean checkLogin(Login loginAccount) {

		// Mở kết nối
		connect();

		// Khai báo biến rs để chứa kết quả
		ResultSet rs = null;
		try {

			// Câu lẹnh kiểm tra đăng nhập
			String sql = "select name from Account where email = ? AND password = ?";
			PreparedStatement pr = connection.prepareStatement(sql);

			// Truyền các biến vào câu lệnh để thực thi
			pr.setString(1, loginAccount.getEmail());
			pr.setString(2, loginAccount.getPassword());
			rs = pr.executeQuery();

			if (rs.next()) {
				// Nếu kết quả trả về khác null, đăng nhập thành công, return
				// true
				return true;
			}

			// Đóng kết nối
			pr.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Đăng nhập thất bại, return false
		return false;

	}

}
