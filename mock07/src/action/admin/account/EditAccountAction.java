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

public class EditAccountAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");

		// Tương tác dữ liệu từ form
		AccountForm accountForm = (AccountForm) form;

		// Tương tác với csdl
		AccountBO accountBO = new AccountBO();

		// Tạo ra đối tượng account với dữ liệu từ form
		Account account = new Account(accountForm.getAccountId(), accountForm.getLevel(), accountForm.getCategoryId(),
				accountForm.getName(), accountForm.getEmail(), accountForm.getPassword(), accountForm.getPhone(),
				accountForm.getStatus());

		Log.in(account.getPassword() + "pass");
		// Lưu lại hành động từ form
		String action = action = accountForm.getAction();

		if ("submit".equals(action)) {

			accountBO.editAccount(account);

			// Sửa thành công và chuyển trang
			return mapping.findForward("editedAccount");

		} else {

			Account accountData = accountBO.getAccountById(account);
			accountForm.setAccountId(accountData.getAccountId());
			accountForm.setLevel(accountData.getLevel());
			accountForm.setCategoryId(accountData.getCategoryId());
			accountForm.setName(accountData.getName());
			accountForm.setEmail(accountData.getEmail());
			accountForm.setPhone(accountData.getPhone());
			accountForm.setStatus(accountData.getStatus());
			return mapping.findForward("editAccount");

		}

	}
}
