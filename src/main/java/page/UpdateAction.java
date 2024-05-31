package page;

import javax.servlet.annotation.WebServlet;

import entity.TodoListInfo;
import page.base.BaseServlet;
import service.SearchService;
import service.UpdateService;
import service.UpdateService.UPDATE_MODE;

//import com.selecty.example.entity.Employee;
//import com.selecty.example.page.base.BaseServlet;
//import com.selecty.example.service.SearchService;
//import com.selecty.example.service.UpdateService;
//import com.selecty.example.service.UpdateService.UPDATE_MODE;

/**
 * 入力された情報で、データベースの情報を更新します
 * メールアドレスの更新を行う場合、重複があればエラーとし、確認用のパスワードと一致していない場合もエラーとなります
 *
 */
@WebServlet(name="update", urlPatterns={"/update"})
public class UpdateAction extends BaseServlet {

	@Override
	protected String getPageName() {
		return "updateInput";
	}

	@Override
	protected String doAction() throws Exception {
		// データを取得
		String[] pageParam = super.getInputParameter(
				 "idTodo"				// 0
				,"todo"				// 1
				,"employeeList_id"				// 2
				);
//		String pass = pageParam[0];

//		if (!"".equals(pageParam[4]) || !"".equals(pageParam[5])) {
//			if (!pageParam[4].equals(pageParam[5])) {
//				throw new Exception("パスワードが一致していません");
//			}
//			pass = pageParam[4];
//		}
//
//		SearchService sService = new SearchService();
//		if (sService.checkDuplicationMail(Integer.parseInt(pageParam[0]), pageParam[3])) {
//			throw new Exception("入力されたメールアドレスは既に存在しています");
//		}
		

		UpdateService uService= new UpdateService();
		TodoListInfo todo = new TodoListInfo();
		todo.setIdToDo(Integer.parseInt(pageParam[0]));
		todo.setTodo(pageParam[1]);
		todo.setEmployeeList_id(Integer.parseInt(pageParam[2]));

		int id = Integer.parseInt(pageParam[2]);
		SearchService service = new SearchService();
		if (service.checkId(id)) {
			throw new Exception("存在しない社員IDです");
		}
		
		uService.registTodoList(todo, UPDATE_MODE.UPDATE);
		return "updateResult";
	}
}