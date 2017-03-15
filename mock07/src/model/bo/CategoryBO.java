package model.bo;

import java.util.ArrayList;

import model.bean.Category;
import model.dao.CategoryDAO;

public class CategoryBO {

	CategoryDAO categoryDAO = new CategoryDAO();
	// lấy danh sách theo trang
	public ArrayList<Category> getListCategory(int page) {
		return categoryDAO.getListCategory(page);
	}
	// xóa
	public void delete(Category category) {
		categoryDAO.delete(category);
	}
//	thêm
	public void add(Category category) {
		categoryDAO.add(category);
	}
//	lấy theo id
	public Category getById(Category category) {
		return categoryDAO.getById(category);
	}
//	sửa
	public void edit(Category category) {
		categoryDAO.edit(category);
	}
}
