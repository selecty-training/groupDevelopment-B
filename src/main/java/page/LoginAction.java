package page;

import java.util.Map;

import javax.servlet.annotation.WebServlet;

import page.base.BaseServlet;
import service.SearchService;

//import com.selecty.example.page.base.BaseServlet;
//import com.selecty.example.service.SearchService;

@WebServlet(name="login", urlPatterns={"/login"})
public class LoginAction extends BaseServlet {

	@Override
	protected String getPageName() {
		return "login";
	}

	@Override
	protected String doAction() throws Exception {
		// 画面入力項目の取得
		String[] param = super.getInputParameter("id", "pass");

		// 入力チェック
		/*
		 * 必須チェックはHTML側で済みのため、Java側は特になし
		 */

		// ログイン処理
		SearchService service = new SearchService();
		String i = param[0];
		Integer id = null;
		if (i.trim().length() > 0) {
			try {
				id = Integer.parseInt(i);
			} catch (NumberFormatException e) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
		}
		Map<String, Object> loginData = service.doLogin(id, param[1]);

		// 結果の取得（検索結果0件）
		if (loginData == null || loginData.get("EMP") == null) {
			throw new Exception("IDまたはパスワードが間違っています");
		}
//			TodoListInfo todo = new TodoListInfo();
//			List<EmployeeInfo> todoInfoList = service.searchTodoInfo(todo);

		// 取得した情報をセッションへ格納
		super.session.setAttribute("LOGIN_EMP", loginData.get("EMP"));
		super.session.setAttribute("DEP_LIST", loginData.get("DEP_LIST"));
//		super.request.setAttribute("empInfoList", todoInfoList);
		return "menu";
	}
}



