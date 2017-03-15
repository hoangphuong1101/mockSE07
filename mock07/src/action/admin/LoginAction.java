package action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Login;
import model.bo.LoginBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.admin.LoginForm;;

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// loginForm để chứ dữ liệu ở form giao diện
		LoginForm loginForm = (LoginForm) form;

		// loginBO để thao tác với csdl
		LoginBO loginBO = new LoginBO();

		// Tạo ra đối tượng loginAccount với email và password từ form
		Login loginAccount = new Login(loginForm.getEmail(), loginForm.getPassword());

		if (loginBO.checkLogin(loginAccount)) {
			// Nếu đăng nhập với đối tượng loginAccount thành công thì trả v�?
			// success
			return mapping.findForward("success");
		} else {
			// Nếu đăng nhập với đối tượng loginAccount thành công thì trả v�?
			// failed và thông báo lỗi lên form
			loginForm.setNotification("Đăng nhập thất bại");
			return mapping.findForward("failed");
		}
	}
}
