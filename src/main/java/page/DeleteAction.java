package page;

import javax.servlet.annotation.WebServlet;

import page.base.BaseServlet;
import service.UpdateService;

/**
 * 社員情報削除を行う画面に対応したページクラスです
 *
 */
@WebServlet(name="delete", urlPatterns={"/delete"})
public class DeleteAction extends BaseServlet {
	@Override
	protected String getPageName() {
		return "deleteConfirm";
	}

	@Override
	protected String doAction() throws Exception {

		String[] pageParam = super.getInputParameter(
				 "empId"		// 0
		);

		UpdateService service = new UpdateService();
		service.deleteEmployee(Integer.parseInt(pageParam[0]));

		return "deleteResult";
	}

}
