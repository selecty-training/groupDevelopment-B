package page;

import javax.servlet.annotation.WebServlet;

import entity.TodoListInfo;
import page.base.BaseServlet;
import service.SearchService;

//import com.selecty.example.entity.Employee;
//import com.selecty.example.page.base.BaseServlet;
//import com.selecty.example.service.SearchService;

/**
 * TodoIDから情報を取得して、次の画面に値を渡すためのクラスです。
 * 今回の対象であれば、「削除→削除対象確認」や「更新→更新内容入力」などです。
 *
 */
@WebServlet(name="targetSearch", urlPatterns={"/targetSearch"})
public class targetSearch extends BaseServlet {
	@Override
	protected String getPageName() {
		String page = super.getInputParameter("page")[0];
		return "update".equals(page) ? "update" : "delete";
	}
	@Override
	protected String doAction() throws Exception {
		String[] pageParam = super.getInputParameter(
				 "idTodo"		// 0
				,"page"			// 1
		);

		int idTodo = -1;
		try {
			idTodo = Integer.parseInt(pageParam[0]);
		} catch (NumberFormatException e) {
			throw new Exception("入力されたIDで見つかりませんでした");
		}

		SearchService service = new SearchService();
		TodoListInfo todoList = service.searchTodoListByPkey(idTodo);

		if (todoList == null) {
			throw new Exception("入力されたIDで見つかりませんでした");
		}


		super.request.setAttribute("idTodo", todoList.getIdToDo());
		super.request.setAttribute("todo", todoList.getTodo());
		super.request.setAttribute("employeeList_id", todoList.getEmployeeList_id());

		return "update".equals(pageParam[1]) ? "updateInput" : "deleteConfirm";
	}
}

