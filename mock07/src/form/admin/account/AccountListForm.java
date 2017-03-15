package form.admin.account;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Account;

public class AccountListForm extends ActionForm {
	int page = 1;
	int totalPage = 1;
	ArrayList<Account> accounts;

	public AccountListForm() {
		super();
	}

	public AccountListForm(int page, int totalPage, ArrayList<Account> accounts) {
		super();
		this.page = page;
		this.totalPage = totalPage;
		this.accounts = accounts;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

}
