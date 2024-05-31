package page.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Employee;

//import com.selecty.example.entity.Department;
//import com.selecty.example.entity.Employee;

public abstract class BaseServlet extends HttpServlet {
	//-------------------------------------- プロパティ群
	/** HttpServletRequest */
	protected HttpServletRequest request;
	/** HttpServletResponse */
	protected HttpServletResponse response;
	/** HttpSession */
	protected HttpSession session;
	/** ErrorMessage */
	protected String message;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("UTF-8");
		arg1.setContentType("text/html; charset=UTF-8");
		arg1.setCharacterEncoding("UTF-8");
		
		this.message = null;
		this.request = arg0;
		this.response = arg1;
		this.session = arg0.getSession();

		String nextPage = this.getPageName();
		try {
			// ログインチェック
			if (!"login".equals(this.getPageName())) {
				if (session != null) {
					Employee employee = (Employee) session.getAttribute("LOGIN_EMP");
					
					
					if (
							(employee == null || "".equals(employee.getNmEmployee()))
							
						){
						nextPage = "login";
						throw new Exception("不正なログイン、またはログイン有効期間が過ぎています");
						}
					}
				}
			

			// 画面ごとの処理
			nextPage = this.doAction();
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}

		arg0.setAttribute("errMsg", this.message);
		arg0.getRequestDispatcher(nextPage+".jsp").forward(arg0,arg1);
	}

	//-------------------------------------- Utilメソッド群
	protected String[] getInputParameter(String... names) {
		String[] values = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			values[i] = this.request.getParameter(names[i]);
			request.setAttribute(names[i], values[i]);
		}
		return values;
	}

	//-------------------------------------- 抽象メソッド群
	protected abstract String getPageName();

	protected abstract String doAction() throws Exception;
}
