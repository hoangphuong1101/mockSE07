package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Account;
import model.bean.Category;
import statics.InfoSQLServer;
import statics.Log;
import statics.Pagination;

public class CategoryDAO {

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


	// Xóa
	public void delete(Category category) {

		// Mở kết nối
		connect();
		try {

			// Câu lệnh xóa
			String sql = "delete from Category where categoryId = ?";
			PreparedStatement pr = connection.prepareStatement(sql);

			// Truyền accounId vào
			pr.setInt(1, category.getCategoryId());

			// Thực hiện query update
			pr.executeUpdate();

			// Đóng kết nối
			pr.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// thêm
	public void add(Category category) {

		// Mở kết nối
		connect();
		try {

			// Câu lệnh select
			String sql = "insert into Category(name)" + " VALUES(?)";
			PreparedStatement pr = connection.prepareStatement(sql);

			// Truyền các tham số
			pr.setString(1, category.getName());

			// Thực hiện
			pr.executeUpdate();

			// Đóng kết nối
			pr.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// lấy category theo id 
	public Category getById(Category category) {

		// Mở kết nối
		connect();

		// Lưu kết quả truy vấn
		ResultSet rs = null;

		// Lưu thông tin account
		Category categoryData = new Category();

		try {

			// Câu lệnh truy vấn
			String sql = "select * from  Category where categoryId = ?";
			PreparedStatement pr = connection.prepareStatement(sql);

			// Truyền tham số
			pr.setInt(1, category.getCategoryId());

			// Thực hiện
			rs = pr.executeQuery();

			// Lấy kết quả đưa vào accountData
			if (rs.next()) {
				categoryData.setCategoryId(rs.getInt(1));
				categoryData.setName(rs.getString(2));
				return categoryData;
			}

			// Đóng kết nối
			pr.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryData;
	}
	// sửa category
	public void edit(Category category) {

		// Mở kết nối
		connect();
		try {

			// Câu lệnh update
			String sql = "update Category set name = ?  where categoryId = ?";
			PreparedStatement pr = connection.prepareStatement(sql);

			// Truyền tham số
			pr.setString(1, category.getName());
			pr.setInt(2, category.getCategoryId());

			// Thực thi
			pr.executeUpdate();

			// Đóng kết nối
			pr.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// lấy danh sách theo trang
	public ArrayList<Category> getListCategory(int page) {
		// Mở kết nối
		connect();

		// Biến lưu vị trí offset bắt đầu select, toognr số dòng trong csdl
		int offset = 0, total;
		// Biến lưu kết quả từ truy vấn
		ResultSet rs = null;

		// Lưu danh sách account từ csdl
		ArrayList<Category> temp = new ArrayList<Category>();

		try {

			// Câu lệnh đếm có bao nhiêu dòng trong csdl
			String sqlCount = "select count(categoryId) as total from Category";
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

			String sql = "select * from Category order by categoryId" + " offset " + offset + " rows fetch next "
					+ Pagination.itemPerPage + " row only";
			pr = connection.prepareStatement(sql);
			rs = pr.executeQuery();

			try {
				while (rs.next()) {
					// Thêm vào arraylist temp
					temp.add(new Category(rs.getInt("categoryId"), rs.getString("name")));
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
}
