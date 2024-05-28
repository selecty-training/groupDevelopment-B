package page;

import javax.servlet.annotation.WebServlet;

import entity.Employee;
import page.base.BaseServlet;
import service.UpdateService;
import service.UpdateService.UPDATE_MODE;

//import com.selecty.example.entity.Employee;
//import com.selecty.example.page.base.BaseServlet;
//import com.selecty.example.service.UpdateService;
//import com.selecty.example.service.UpdateService.UPDATE_MODE;

@WebServlet(name="insert", urlPatterns={"/insert"})
public class InsertAction extends BaseServlet {
	@Override
	protected String getPageName() {
		return "insertConfirm";
	}

	@Override
	protected String doAction() throws Exception {

		String[] pageParam = super.getInputParameter(
				 "empNm"		// 0
				,"empKn"		// 1
				,"mail"			// 2
				,"pass"			// 3
				,"passConfirm"	// 4
				,"depId"		// 5
		);

		if (!pageParam[3].equals(pageParam[4])) {
			throw new Exception("パスワードが一致していません");
		}

		Employee emp = new Employee();
		emp.setNmEmployee(pageParam[0]);
		emp.setPassword(pageParam[1]);

		UpdateService service = new UpdateService();
		service.registEmployee(emp, UPDATE_MODE.INSERT);

		return "insertResult";
	}
}



