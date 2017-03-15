package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Account;
import model.bean.Login;
import statics.InfoSQLServer;
import statics.Log;
import statics.Pagination;

public class AccountDAO {

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

	// Lấy danh sách tài khoản ở trang
	public ArrayList<Account> getListAccount(int page) {
		// Mở kết nối
		connect();

		// Biến lưu vị trí offset bắt đầu select, toognr số dòng trong csdl
		int offset = 0, total;
		// Biến lưu kết quả từ truy vấn
		ResultSet rs = null;

		// Lưu danh sách account từ csdl
		ArrayList<Account> temp = new ArrayList<Account>();

		try {

			// Câu lệnh đếm có bao nhiêu dòng trong csdl
			String sqlCount = "select count(accountId) as total from Account";
			PreparedStatement pr = connection.prepareStatement(sqlCount);
			rs = pr.executeQuery();
			try {
				if (rs.next()) {
					// Lưu lại tổng số dòng
					total = rs.getInt("total");
					// Vị trí select = số trang * với số dòng trong 1 trang muốn
					// lấy
					offset = (page - 1) > 0 ? ((page - 1) * Pagination.itemPerPage) : 0;

					// Nếu vị trí vượt quá số donngf, thì lấy trang cuối cùng
					if (offset >= total) {
						offset -= (Pagination.itemPerPage);
					}

					// Lưu lại số trang hiện tại
					Pagination.page = page;
					// Tính toán tổng số trang
					Pagination.totalPage = (int) Math.ceil(1.0 * total / Pagination.itemPerPage);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			String sql = "select * from Account order by accountId" + " offset " + offset + " rows fetch next "
					+ Pagination.itemPerPage + " row only";
			pr = connection.prepareStatement(sql);
			rs = pr.executeQuery();

			try {
				while (rs.next()) {
					// Thêm vào arraylist temp
					temp.add(new Account(rs.getInt("accountId"), rs.getInt("level"), 1, rs.getString("name"),
							rs.getString("email"), rs.getString("password"), rs.getString("phone"),
							rs.getInt("status")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// Đóng kết nối
			pr.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Trả về kết quả
		return temp;
	}

	public void deleteAccount(Account account) {

		// Mở kết nối
		connect();
		try {

			// Câu lệnh xóa
			String sql = "delete from Account where accountId = ?";
			PreparedStatement pr = connection.prepareStatement(sql);

			// Truyền accounId vào
			pr.setInt(1, account.getAccountId());

			// Thực hiện query update
			pr.executeUpdate();

			// Đóng kết nối
			pr.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean addAccount(Account account) {

		// Mở kết nối
		connect();
		try {

			// Câu lệnh select
			String sql = "insert into Account(level,categoryId,name,email,password,phone,status)"
					+ " VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pr = connection.prepareStatement(sql);

			// Truyền các tham số
			pr.setInt(1, account.getLevel());
			pr.setNull(2, java.sql.Types.INTEGER); /* Kiểu null của int */
			pr.setString(3, account.getName());
			pr.setString(4, account.getEmail());
			pr.setString(5, account.getPassword());
			pr.setString(6, account.getPhone());
			pr.setInt(7, account.getStatus());

			// Thực hiện
			int count = pr.executeUpdate();
			// Đóng kết nối
			pr.close();
			connection.close();
			if (count > 0) {
				System.out.println("success");
				return true;
			} else {
				System.out.println("stuck somewhere");
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Account getAccountById(Account account) {

		// Mở kết nối
		connect();

		// Lưu kết quả truy vấn
		ResultSet rs = null;

		// Lưu thông tin account
		Account accountData = new Account();

		try {

			// Câu lệnh truy vấn
			String sql = "select * from  Account where accountId = ?";
			PreparedStatement pr = connection.prepareStatement(sql);

			// Truyền tham số
			pr.setInt(1, account.getAccountId());

			// Thực hiện
			rs = pr.executeQuery();

			// Lấy kết quả đưa vào accountData
			if (rs.next()) {
				accountData.setAccountId(rs.getInt(1));
				accountData.setLevel(rs.getInt(2));
				accountData.setCategoryId(rs.getInt(3));
				accountData.setName(rs.getString(4));
				accountData.setEmail(rs.getString(5));
				accountData.setPhone(rs.getString(7));
				accountData.setStatus(rs.getInt(8));
				return accountData;
			}

			// Đóng kết nối
			pr.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	public void editAccount(Account account) {

		// Mở kết nối
		connect();
		try {

			// Nếu mật khẩu lớn hơn 6 kí tự, thì thực hiện đổi mật khẩu
			if (account.getPassword().length() >= 6) {
				// Câu lệnh update
				String sql = "update Account set level = ?, categoryId = ?, name = ?, email = ?, password = ?, phone = ?, status = ? where accountId = ?";
				PreparedStatement pr = connection.prepareStatement(sql);

				// Truyền tham số
				pr.setInt(1, account.getLevel());
				pr.setNull(2, java.sql.Types.INTEGER); /* Kiểu null của int */
				pr.setString(3, account.getName());
				pr.setString(4, account.getEmail());
				pr.setString(5, account.getPassword());
				pr.setString(6, account.getPhone());
				pr.setInt(7, account.getStatus());
				pr.setInt(8, account.getAccountId());

				Log.in("Sua co pass");
				// Thực thi
				pr.executeUpdate();

				// Đóng kết nối
				pr.close();
				connection.close();

			} else {
				// Ngược lại không đổi mật khẩu
				String sql = "update Account set level = ?, categoryId = ?, name = ?, email = ?, phone = ?, status = ? where accountId = ?";
				PreparedStatement pr = connection.prepareStatement(sql);

				// Truyền tham số
				pr.setInt(1, account.getLevel());
				pr.setNull(2, java.sql.Types.INTEGER); /* Kiểu null của int */
				pr.setString(3, account.getName());
				pr.setString(4, account.getEmail());
				pr.setString(5, account.getPhone());
				pr.setInt(6, account.getStatus());
				pr.setInt(7, account.getAccountId());

				Log.in("Sua k0 pass");
				// Thực thi
				pr.executeUpdate();

				// Đóng kết nối
				pr.close();
				connection.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkEmail(Account account) {
		// Mở kết nối
		connect();

		// Khai báo biến rs để chứa kết quả
		ResultSet rs = null;
		try {

			// Câu lẹnh kiểm tra đăng nhập
			String sql = "select name from Account where email = ?";
			PreparedStatement pr = connection.prepareStatement(sql);

			// Truyền các biến vào câu lệnh để thực thi
			pr.setString(1, account.getEmail());
			rs = pr.executeQuery();

			if (rs.next()) {
				Log.in("EMail ton tai");
				// Nếu kết quả trả về khác null, đăng nhập thành công, return
				// true
				return false;
			}

			// Đóng kết nối
			pr.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Đăng nhập thất bại, return false
		Log.in("EMail k0 ton tai");
		return true;
	}
	// Kiểm tra đăng nhập với đối tượng loginAccount
		public boolean checkLogin(Account account) {

			// Mở kết nối
			connect();

			// Khai báo biến rs để chứa kết quả
			ResultSet rs = null;
			try {

				// Câu lẹnh kiểm tra đăng nhập
				String sql = "select name from Account where email = ? AND password = ?";
				PreparedStatement pr = connection.prepareStatement(sql);

				// Truyền các biến vào câu lệnh để thực thi
				pr.setString(1, account.getEmail());
				pr.setString(2, account.getPassword());
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
		//lấy danh sách theo cấp độ
		public ArrayList<Account> getListAccount(int page, int level) {
			// TODO Auto-generated method stub
			return null;
		}
}
