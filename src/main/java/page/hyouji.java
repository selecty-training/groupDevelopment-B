package page;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import entity.EmployeeInfo;
import entity.TodoListInfo;
import page.base.BaseServlet;
import service.SearchService;

/**
 * Servlet implementation class hyouji
 */
@WebServlet(name="hyouji", urlPatterns={"/hyouji"})
public class hyouji extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    

	@Override
	protected String getPageName() {
		return "menu";
	}

	@Override
	protected String doAction() throws Exception {
		SearchService service = new SearchService();
		
		TodoListInfo todo = new TodoListInfo();
		List<EmployeeInfo> todoInfoList = service.searchTodoInfo(todo);
		
		super.request.setAttribute("empInfoList", todoInfoList);

		return "menu";
	}

}
