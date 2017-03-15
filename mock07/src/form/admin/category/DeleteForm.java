package form.admin.category;

import org.apache.struts.action.ActionForm;

public class DeleteForm extends ActionForm{
	int categoryId;

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * 
	 */
	public DeleteForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param categoryId
	 */
	public DeleteForm(int categoryId) {
		super();
		this.categoryId = categoryId;
	}
	
}
