package action.admin.account;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.admin.LoginForm;
import form.admin.account.AccountListForm;
import model.bean.Account;
import model.bo.AccountBO;
import model.bo.LoginBO;
import statics.Log;
import statics.Pagination;

public class AccountListAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// accountListForm tương tác dữ liệu từ form
		AccountListForm accountListForm = (AccountListForm) form;

		// accountBO để tương tác vs csdl
		AccountBO accountBO = new AccountBO();

		// Lấy số trang cần xem
		int page = accountListForm.getPage();

		// Lấy danh sách account từ csdl và lưu vào accounts
		ArrayList<Account> accounts = accountBO.getListAccount(page);

		// Gán accounts lên form
		accountListForm.setAccounts(accounts);

		// Gán số trang hiện tại lên form
		accountListForm.setPage(Pagination.page);

		// Gán tổng số trang lên form
		accountListForm.setTotalPage(Pagination.totalPage);

		// Trả v�? trang listAccounts
		return mapping.findForward("listAccounts");
	}
}
