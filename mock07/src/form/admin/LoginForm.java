package form.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;

public class LoginForm  extends ActionForm{
	String email;
	String password;
	String notification;

	public LoginForm() {
		super();
	}

	public LoginForm(String email, String password, String notification) {
		super();
		this.email = email;
		this.password = password;
		this.notification = notification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors actionErrors = new ActionErrors();
		if (StringProcess.notVaild(email)) {
			actionErrors.add("tenDangNhapError", new ActionMessage(
					"error.tenDangNhap"));
		}
		if (StringProcess.notVaild(password)) {
			actionErrors
					.add("matKhauError", new ActionMessage("error.matKhau"));
		}
		return actionErrors;
	}
}
