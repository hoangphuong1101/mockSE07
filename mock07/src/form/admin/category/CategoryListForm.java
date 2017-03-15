package form.admin.category;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Category;

/*import java.sql.Array;*/

public class CategoryListForm extends ActionForm{
	int page = 1;
	int totalPage = 1;
	ArrayList<Category> categorys;
	
	public CategoryListForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param page
	 * @param totalPage
	 * @param categorys
	 */
	public CategoryListForm(int page, int totalPage, ArrayList<Category> categorys) {
		super();
		this.page = page;
		this.totalPage = totalPage;
		this.categorys = categorys;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the categorys
	 */
	public ArrayList<Category> getCategorys() {
		return categorys;
	}

	/**
	 * @param categorys the categorys to set
	 */
	public void setCategorys(ArrayList<Category> categorys) {
		this.categorys = categorys;
	}

	
	
}
