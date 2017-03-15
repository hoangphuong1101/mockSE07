package action.admin.category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.admin.category.DeleteForm;
import model.bean.Category;
import model.bo.CategoryBO;

public class DeleteCategoryAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
//		tương tác dữ liệu từ form
		DeleteForm deleteForm =(DeleteForm) form;
//		tương tác với cơ sở dữ liệu
		CategoryBO categoryBO =new CategoryBO();
		
		// lấy Id từ form
		int id = deleteForm.getCategoryId();
		// tạo ra đối tương 
		Category category =new Category();
		
		// lấy ra category tại địa chỉ id trên
		category.setCategoryId(id);
		if(id>=0){
//			xóa đối tượng tại địa chỉ trên
			categoryBO.delete(category);
			
		}
		// trar về deletedCategory
		return mapping.findForward("deletedCategory");
	}
}
