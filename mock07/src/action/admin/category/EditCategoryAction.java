package action.admin.category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.admin.category.CategoryForm;
import model.bean.Category;
import model.bo.CategoryBO;
import statics.Log;

public class EditCategoryAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		// tương tác dữ liệu từ form
		CategoryForm categoryForm =(CategoryForm) form;
		//tương tác với sql
		CategoryBO categoryBO = new CategoryBO();
		
		//tạo ra 1 đối tượng category chứa dữ liệu từ form
		Category category = new Category(categoryForm.getCategoryId(), categoryForm.getName());
		// xem id của category
		Log.in(categoryForm.getCategoryId() + "ID: ");
		//lưu lại hành động từ  form
		String action = categoryForm.getAction();
		if("submit".equals(action)){
			categoryBO.edit(category);
			/*sửa thành công chuyển sang trang*/
			return mapping.findForward("editedCategory");
		}else{
			Category categoryData = categoryBO.getById(category);
			categoryForm.setCategoryId(categoryData.getCategoryId());
			categoryForm.setName(categoryData.getName());
			return mapping.findForward("editCategory");
		}
		
	}
}
