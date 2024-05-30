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
                "todo"      // 1
        );

        TodoListInfo td = new TodoListInfo();
        td.setIdToDo(Integer.parseInt(pageParam[0]));
        td.setTodo(pageParam[1]);
        
        UpdateService service = new UpdateService();
        service.registTodoList(td, UPDATE_MODE.INSERT);

        return "insertResult";
    }
}