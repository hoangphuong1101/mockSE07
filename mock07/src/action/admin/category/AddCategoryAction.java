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

public class AddCategoryAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		// categoryListForm tương tác dữ liệu từ form
		CategoryForm categoryForm= (CategoryForm) form;
		
		//tuong tác với sql
		CategoryBO categoryBO = new CategoryBO();
		// lưu hành động
		String action = categoryForm.getAction();
		
		// Tạo ra đối tượng category với dữ liệu từ form
		Category category=new Category(categoryForm.getCategoryId(), categoryForm.getName());
		
		//
		if ("submit".equals(action)) {

//			accountBO.addAccount(account);
			categoryBO.add(category);

			// Thêm thành công và chuyển trang
			return mapping.findForward("addedCategory");

		} else {

			return mapping.findForward("addCategory");
		}
}
}
