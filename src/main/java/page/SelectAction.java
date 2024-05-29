package page;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import entity.TodoListInfo;
import page.base.BaseServlet;
import service.SearchService;

/**
 * Servlet implementation class SelectAction
 */
@WebServlet(name = "select", urlPatterns = { "/select" })
public class SelectAction extends BaseServlet {
	
	@Override
	protected String getPageName() {
		return "select";
	}

	@Override
	protected String doAction() throws Exception {
		String[] pageParam = super.getInputParameter(
				"idTodo" // 0
				, "todo" // 1
				, "employeeList_id" // 2
		);
		
		Integer id = null;

		// 入力チェック
		/*
		 * IDが数値でない場合は検索しなくても0件
		 */
		if (pageParam[0].trim().length() > 0) {
			try {
				id = Integer.parseInt(pageParam[0]);
			} catch (NumberFormatException e) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
		}

		// 画面入力値 -> DTOへ
		TodoListInfo todo = new TodoListInfo();
		todo.setIdToDo(id);
		todo.setTodo(pageParam[1]);
		todo.setEmployeeList_id(Integer.parseInt(pageParam[2]));
		

		// 検索を行う
		SearchService service = new SearchService();
		List<TodoListInfo> empInfoList = service.searchTodoListInfo(todo);

		// 検索結果の判定
		if (empInfoList.size() == 0) {
			throw new Exception("入力された条件で情報が見つかりませんでした");
		}

		// 取得した結果をセット
		super.request.setAttribute("empInfoList", empInfoList);
		return "selectResult";
	}

}
