package action.admin.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import form.admin.account.AccountForm;
import model.bean.Account;
import model.bo.AccountBO;
import statics.Log;

public class AddAccountAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		// accountListForm tương tác dữ liệu từ form
		AccountForm accountForm = (AccountForm) form;

		// accountBO để tương tác vs csdl
		AccountBO accountBO = new AccountBO();

		// Lưu lại hành động từ form
		String action = action = accountForm.getAction();

		// Tạo ra đối tượng account với dữ liệu từ form
		Account account = new Account(accountForm.getAccountId(), accountForm.getLevel(), accountForm.getCategoryId(),
				accountForm.getName(), accountForm.getEmail(), accountForm.getPassword(), accountForm.getPhone(),
				accountForm.getStatus());

		if ("submit".equals(action)) {

			accountBO.addAccount(account);

			// Thêm thành công và chuyển trang
			return mapping.findForward("addedAccount");

		} else {

			return mapping.findForward("addAccount");
		}
	}
}
