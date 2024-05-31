package page;

import javax.servlet.annotation.WebServlet;

import page.base.BaseServlet;
import service.SearchService;

//import com.selecty.example.page.base.BaseServlet;
//import com.selecty.example.service.SearchService;

/**
 * 社員登録情報の確認を行うページクラスです
 * メールアドレスが既に登録されているか判定します
 *
 */
@WebServlet(name="inputCheck", urlPatterns={"/inputCheck"})
public class InputCheckAction extends BaseServlet {

	@Override
	protected String getPageName() {
		return "insert";
	}

	@Override
	protected String doAction() throws Exception {
		String[] pageParam = super.getInputParameter(
				 "idTodo"    // 0 idTodoは自動で設定されるようにしたい！！！！
				,"employeeList_id"//1
				,"todo"		 // 2
			);
		
		
		//
		int id = Integer.parseInt(pageParam[1]);
		SearchService service = new SearchService();
		if (service.checkId(id)) {
			throw new Exception("存在しない社員IDです");
		}
		//

		return "insertConfirm";
	}
}



