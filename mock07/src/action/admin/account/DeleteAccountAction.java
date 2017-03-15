package action.admin.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.admin.account.AccountListForm;
import form.admin.account.DeleteForm;
import model.bean.Account;
import model.bo.AccountBO;
import statics.Log;
import statics.Pagination;

public class DeleteAccountAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//Tương tác dữ liệu từ form
		DeleteForm deleteForm = (DeleteForm) form;
		
		//Tương tác với csdl
		AccountBO accountBO = new AccountBO();
		
		//Lấy accountId từ form
		int accountId = deleteForm.getAccountId();
		
		//Tạo ra đối tượng account
		Account account = new Account();
		
		//Gán giá trị accountId
		account.setAccountId(accountId);
		
		if( accountId >= 0 )
			accountBO.deleteAccount(account);

		//Trả v�? deletedAccount
		return mapping.findForward("deletedAccount");
	}
}
