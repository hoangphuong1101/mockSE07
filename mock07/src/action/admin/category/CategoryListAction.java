package action.admin.category;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.admin.category.CategoryListForm;
import model.bean.Category;
import model.bo.CategoryBO;
import statics.Pagination;

public class CategoryListAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// accountListForm tương tác dữ liệu từ form
		CategoryListForm categoryListForm = (CategoryListForm) form;

		// accountBO để tương tác vs csdl
		CategoryBO categoryBO = new CategoryBO();

		// Lấy số trang cần xem
		int page = categoryListForm.getPage();

		// Lấy danh sách category từ csdl và lưu vào categorys
		ArrayList<Category> categorys = categoryBO.getListCategory(page);

		// Gán categorys lên form
		categoryListForm.setCategorys(categorys);

		// Gán số trang hiện tại lên form
		categoryListForm.setPage(Pagination.page);

		// Gán tổng số trang lên form
		categoryListForm.setTotalPage(Pagination.totalPage);

		// Trả v�? trang listAccounts
		return mapping.findForward("listCategorys");
	}

}
