package form.admin.account;

import org.apache.struts.action.ActionForm;

public class DeleteForm extends ActionForm {
	private int accountId;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public DeleteForm() {
		super();
	}

	public DeleteForm(int accountId) {
		super();
		this.accountId = accountId;
	}

	
}
