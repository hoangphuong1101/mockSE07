package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Thread;
import statics.InfoSQLServer;
import statics.Log;

public class ThreadDAO {

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

	// Lấy danh sách danh mục
	public ArrayList<model.bean.Thread> getList() {
		// Mở kết nối
		connect();

		// Biến lưu kết quả từ truy vấn
		ResultSet rs = null;

		// Lưu danh sách account từ csdl
		ArrayList<model.bean.Thread> temp = new ArrayList<Thread>();

		try {

			// Câu lệnh đếm có bao nhiêu dòng trong csdl
			String sql = "select Thread.* from Thread";
			PreparedStatement pr = connection.prepareStatement(sql);
			rs = pr.executeQuery();

			try {
				DecimalFormat numberFormat = new DecimalFormat("#.##");
				while (rs.next()) {
					Thread threadTemp = new Thread(rs.getInt("threadId"), rs.getInt("categoryId"), rs.getInt("accountId"),
							rs.getString("name"), rs.getString("address"), rs.getDouble("latitude"),
							rs.getDouble("longitude"), rs.getString("content"), rs.getLong("price"),
							rs.getInt("electricFee"), rs.getInt("waterFee"), rs.getInt("otherFee"), rs.getInt("area"),
							rs.getBoolean("wifi"), rs.getBoolean("waterHeater"), rs.getBoolean("conditioner"),
							rs.getBoolean("fridge"), rs.getBoolean("attic"), rs.getBoolean("camera"),
							rs.getString("waterSource"), rs.getString("direction"), rs.getInt("numOfToilets"),
							rs.getInt("numOfPeople"), rs.getInt("object"), rs.getInt("villageId"), rs.getString("created"),
							rs.getInt("viewed"), rs.getInt("status"), rs.getString("imageThumb"));
					if (threadTemp.getPrice() > 1000000) {
						threadTemp.setPriceString(
								numberFormat.format(((double) (threadTemp.getPrice() / (1.0 * 1000000)))) + " triệu ");
					} else if (threadTemp.getPrice() > 1000) {
						threadTemp.setPriceString((threadTemp.getPrice() / 1000) + " ngàn ");
					}
					temp.add(threadTemp);
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

	// Lấy danh sách danh mục
	public ArrayList<model.bean.Thread> getListMostView() {
		// Mở kết nối
		connect();

		// Biến lưu kết quả từ truy vấn
		ResultSet rs = null;

		// Lưu danh sách account từ csdl
		ArrayList<model.bean.Thread> temp = new ArrayList<Thread>();

		try {

			// Câu lệnh đếm có bao nhiêu dòng trong csdl
			String sql = "SELECT top 4 * FROM Thread order by viewed desc";
			PreparedStatement pr = connection.prepareStatement(sql);
			rs = pr.executeQuery();

			try {
				DecimalFormat numberFormat = new DecimalFormat("#.##");
				while (rs.next()) {
					Thread threadTemp = new Thread(rs.getInt("threadId"), rs.getInt("categoryId"), rs.getInt("accountId"),
							rs.getString("name"), rs.getString("address"), rs.getDouble("latitude"),
							rs.getDouble("longitude"), rs.getString("content"), rs.getLong("price"),
							rs.getInt("electricFee"), rs.getInt("waterFee"), rs.getInt("otherFee"), rs.getInt("area"),
							rs.getBoolean("wifi"), rs.getBoolean("waterHeater"), rs.getBoolean("conditioner"),
							rs.getBoolean("fridge"), rs.getBoolean("attic"), rs.getBoolean("camera"),
							rs.getString("waterSource"), rs.getString("direction"), rs.getInt("numOfToilets"),
							rs.getInt("numOfPeople"), rs.getInt("object"), rs.getInt("villageId"), rs.getString("created"),
							rs.getInt("viewed"), rs.getInt("status"), rs.getString("imageThumb"));
					if (threadTemp.getPrice() > 1000000) {
						threadTemp.setPriceString(
								numberFormat.format(((double) (threadTemp.getPrice() / (1.0 * 1000000)))) + " triệu ");
					} else if (threadTemp.getPrice() > 1000) {
						threadTemp.setPriceString((threadTemp.getPrice() / 1000) + " ngàn ");
					}
					temp.add(threadTemp);
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
		Log.in(temp.toString());
		return temp;
	}

	// Xóa
	public void delete(Thread thread) {

		// Mở kết nối
		connect();
		try {

			// Câu lệnh xóa
			String sql = "delete from Thread where threadId = ?";
			PreparedStatement pr = connection.prepareStatement(sql);

			// Truyền accounId vào
			pr.setInt(1, thread.getCategoryId());

			// Thực hiện query update
			pr.executeUpdate();

			// Đóng kết nối
			pr.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void add(Thread thread) {

		// Mở kết nối
		connect();
		try {

			// Câu lệnh select
			String sql = "insert into Thread(categoryId, accountId, name, address, latitude, longitude, content, price, electricFee, waterFee, otherFee, area, wifi, waterHeater, conditioner, fridge, attic, camera, waterSource, direction, numOfToilets, numOfPeople, object, villageId, created, viewed, status ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pr = connection.prepareStatement(sql);

			// Truyền các tham số
			pr.setInt(1, thread.getCategoryId());
			pr.setInt(2, thread.getAccountId());
			pr.setString(3, thread.getName());
			pr.setString(4, thread.getAddress());
			pr.setDouble(5, thread.getLatitude());
			pr.setDouble(6, thread.getLongitude());
			pr.setString(7, thread.getContent());
			pr.setLong(8, thread.getPrice());
			pr.setInt(9, thread.getElectricFee());
			pr.setInt(10, thread.getWaterFee());
			pr.setInt(11, thread.getOtherFee());
			pr.setInt(12, thread.getArea());
			pr.setBoolean(13, thread.isWifi());
			pr.setBoolean(14, thread.isWaterHeater());
			pr.setBoolean(15, thread.isConditioner());
			pr.setBoolean(16, thread.isFridge());
			pr.setBoolean(17, thread.isAttic());
			pr.setBoolean(18, thread.isCamera());
			pr.setString(19, thread.getWaterSource());
			pr.setString(20, thread.getDirection());
			pr.setInt(21, thread.getNumOfToilets());
			pr.setInt(22, thread.getNumOfPeople());
			pr.setInt(23, thread.getObject());
			pr.setInt(24, thread.getVillageId());
			pr.setString(25, thread.getCreated());
			pr.setInt(26, thread.getViewed());
			pr.setInt(27, thread.getStatus());
			// Thực hiện
			pr.executeUpdate();

			// Đóng kết nối
			pr.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Thread getById(Thread thread) {

		// Mở kết nối
		connect();

		// Lưu kết quả truy vấn
		ResultSet rs = null;

		// Lưu thông tin account
		Thread threadData = null;
		try {

			// Câu lệnh truy vấn
			String sql = "select * from  Thread where threadId = ?";
			PreparedStatement pr = connection.prepareStatement(sql);

			// Truyền tham số
			pr.setInt(1, thread.getThreadId());

			// Thực hiện
			rs = pr.executeQuery();

			// Lấy kết quả đưa vào accountData
			if (rs.next()) {
				threadData = new Thread(rs.getInt("threadId"), rs.getInt("categoryId"), rs.getInt("accountId"),
						rs.getString("name"), rs.getString("address"), rs.getDouble("latitude"),
						rs.getDouble("longitude"), rs.getString("content"), rs.getLong("price"),
						rs.getInt("electricFee"), rs.getInt("waterFee"), rs.getInt("otherFee"), rs.getInt("area"),
						rs.getBoolean("wifi"), rs.getBoolean("waterHeater"), rs.getBoolean("conditioner"),
						rs.getBoolean("fridge"), rs.getBoolean("attic"), rs.getBoolean("camera"),
						rs.getString("waterSource"), rs.getString("direction"), rs.getInt("numOfToilets"),
						rs.getInt("numOfPeople"), rs.getInt("object"), rs.getInt("villageId"), rs.getString("created"),
						rs.getInt("viewed"), rs.getInt("status"), rs.getString("imageThumb"));
			}

			// Đóng kết nối
			pr.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return threadData;
	}

	public ArrayList<Thread> getListByCategory(Category category) {

		// Mở kết nối
		connect();

		// Lưu kết quả truy vấn
		ResultSet rs = null;

		// Lưu thông tin account
		ArrayList<Thread> temp = new ArrayList<Thread>();
		try {
			// Câu lệnh truy vấn
			String sql = "select * from  Thread where categoryId = ?  order by threadId OFFSET 0 ROWS FETCH NEXT 6 ROWS ONLY";
			PreparedStatement pr = connection.prepareStatement(sql);

			// Truyền tham số
			pr.setInt(1, category.getCategoryId());

			// Thực hiện
			rs = pr.executeQuery();
			
			DecimalFormat numberFormat = new DecimalFormat("#.##");
			while (rs.next()) {
				Thread threadTemp = new Thread(rs.getInt("threadId"), rs.getInt("categoryId"), rs.getInt("accountId"),
						rs.getString("name"), rs.getString("address"), rs.getDouble("latitude"),
						rs.getDouble("longitude"), rs.getString("content"), rs.getLong("price"),
						rs.getInt("electricFee"), rs.getInt("waterFee"), rs.getInt("otherFee"), rs.getInt("area"),
						rs.getBoolean("wifi"), rs.getBoolean("waterHeater"), rs.getBoolean("conditioner"),
						rs.getBoolean("fridge"), rs.getBoolean("attic"), rs.getBoolean("camera"),
						rs.getString("waterSource"), rs.getString("direction"), rs.getInt("numOfToilets"),
						rs.getInt("numOfPeople"), rs.getInt("object"), rs.getInt("villageId"), rs.getString("created"),
						rs.getInt("viewed"), rs.getInt("status"), rs.getString("imageThumb"));
				if (threadTemp.getPrice() > 1000000) {
					threadTemp.setPriceString(
							numberFormat.format(((double) (threadTemp.getPrice() / (1.0 * 1000000)))) + " triệu ");
				} else if (threadTemp.getPrice() > 1000) {
					threadTemp.setPriceString((threadTemp.getPrice() / 1000) + " ngàn ");
				}
				temp.add(threadTemp);
			}

			// Đóng kết nối
			pr.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public ArrayList<Thread> getRelateThreadsByThread(Thread thread) {

		// Mở kết nối
		connect();

		// Lưu kết quả truy vấn
		ResultSet rs = null;

		// Lưu thông tin account
		ArrayList<Thread> temp = new ArrayList<Thread>();
		try {
			int categoryId = 0;
			// Câu lệnh truy vấn
			String sql = "select categoryId from Thread where threadId = ?";
			PreparedStatement pr = connection.prepareStatement(sql); 

			// Truyền các biến vào câu lệnh để thực thi
			pr.setInt(1, thread.getThreadId()); 
			rs = pr.executeQuery();

			if (rs.next()) {
				categoryId = rs.getInt("categoryId");
			}
			
			
			DecimalFormat numberFormat = new DecimalFormat("#.##");
			sql = "select * from  Thread where categoryId = ?  order by threadId OFFSET 0 ROWS FETCH NEXT 6 ROWS ONLY";

			pr = connection.prepareStatement(sql); 

			// Truyền các biến vào câu lệnh để thực thi
			pr.setInt(1, categoryId); 
			rs = pr.executeQuery();

			while (rs.next()) {
				Thread threadTemp = new Thread(rs.getInt("threadId"), rs.getInt("categoryId"), rs.getInt("accountId"),
						rs.getString("name"), rs.getString("address"), rs.getDouble("latitude"),
						rs.getDouble("longitude"), rs.getString("content"), rs.getLong("price"),
						rs.getInt("electricFee"), rs.getInt("waterFee"), rs.getInt("otherFee"), rs.getInt("area"),
						rs.getBoolean("wifi"), rs.getBoolean("waterHeater"), rs.getBoolean("conditioner"),
						rs.getBoolean("fridge"), rs.getBoolean("attic"), rs.getBoolean("camera"),
						rs.getString("waterSource"), rs.getString("direction"), rs.getInt("numOfToilets"),
						rs.getInt("numOfPeople"), rs.getInt("object"), rs.getInt("villageId"), rs.getString("created"),
						rs.getInt("viewed"), rs.getInt("status"), rs.getString("imageThumb"));
				if (threadTemp.getPrice() > 1000000) {
					threadTemp.setPriceString(
							numberFormat.format(((double) (threadTemp.getPrice() / (1.0 * 1000000)))) + " triệu ");
				} else if (threadTemp.getPrice() > 1000) {
					threadTemp.setPriceString((threadTemp.getPrice() / 1000) + " ngàn ");
				}
				temp.add(threadTemp);
			}

			// Đóng kết nối
			pr.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public ArrayList<Thread> searchBy(Thread thread) {

		// Mở kết nối
		connect();

		// Lưu kết quả truy vấn
		ResultSet rs = null;
		String filter = "";
		int count = 0;
		if (thread.isWifi() == true) {
			if (count == 0)
				filter += " WHERE ";
			count++;
			filter += "wifi = 1";
		}
		if (thread.isWaterHeater() == true) {
			if (count == 0)
				filter += " WHERE ";
			else
				filter += " AND  ";
			count++;
			filter += " waterHeater = 1";
		}
		if (thread.isConditioner() == true) {
			if (count == 0)
				filter += " WHERE ";
			else
				filter += " AND  ";
			count++;
			filter += " conditioner = 1";
		}
		// Lưu thông tin account
		ArrayList<Thread> temp = new ArrayList<Thread>();
		try {

			// Câu lệnh truy vấn
			String sql = "select * from  Thread " + filter;
			PreparedStatement pr = connection.prepareStatement(sql);

			// Thực hiện
			rs = pr.executeQuery();
			// Lấy kết quả đưa vào accountData
			DecimalFormat numberFormat = new DecimalFormat("#.##");
			while (rs.next()) {
				Thread threadTemp = new Thread(rs.getInt("threadId"), rs.getInt("categoryId"), rs.getInt("accountId"),
						rs.getString("name"), rs.getString("address"), rs.getDouble("latitude"),
						rs.getDouble("longitude"), rs.getString("content"), rs.getLong("price"),
						rs.getInt("electricFee"), rs.getInt("waterFee"), rs.getInt("otherFee"), rs.getInt("area"),
						rs.getBoolean("wifi"), rs.getBoolean("waterHeater"), rs.getBoolean("conditioner"),
						rs.getBoolean("fridge"), rs.getBoolean("attic"), rs.getBoolean("camera"),
						rs.getString("waterSource"), rs.getString("direction"), rs.getInt("numOfToilets"),
						rs.getInt("numOfPeople"), rs.getInt("object"), rs.getInt("villageId"), rs.getString("created"),
						rs.getInt("viewed"), rs.getInt("status"), rs.getString("imageThumb"));
				if (threadTemp.getPrice() > 1000000) {
					threadTemp.setPriceString(
							numberFormat.format(((double) (threadTemp.getPrice() / (1.0 * 1000000)))) + " triệu ");
				} else if (threadTemp.getPrice() > 1000) {
					threadTemp.setPriceString((threadTemp.getPrice() / 1000) + " ngàn ");
				}
				temp.add(threadTemp);
			}

			// Đóng kết nối
			pr.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public void edit(Thread thread) {

	}
}
