package page;

import javax.servlet.annotation.WebServlet;

import entity.TodoListInfo;
import page.base.BaseServlet;
import service.UpdateService;
import service.UpdateService.UPDATE_MODE;

@WebServlet(name="insert", urlPatterns={"/insert"})
public class InsertAction extends BaseServlet {
    @Override
    protected String getPageName() {
        return "insertConfirm";
    }

    @Override
    protected String doAction() throws Exception {
        String[] pageParam = super.getInputParameter(
                "idTodo",   // 0
                "employeeList_id", //1
                "todo"      // 2
        );

        TodoListInfo td = new TodoListInfo();
        
        td.setEmployeeList_id(Integer.parseInt(pageParam[1])) ;
        td.setTodo(pageParam[2]);
        
        
        UpdateService service = new UpdateService();
        service.registTodoList(td, UPDATE_MODE.INSERT);

        return "insertResult";
    }
}