package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.EmployeeDao;
import dao.TodoDao;
import entity.EmployeeInfo;
import entity.TodoListInfo;
import service.BaseService.BaseService;
import util.DbUtil;

//import com.selecty.example.dao.DepartmentDao;
//import com.selecty.example.dao.EmployeeDao;
//import com.selecty.example.entity.Department;
//import com.selecty.example.entity.Employee;
//import com.selecty.example.entity.EmployeeInfo;
//import com.selecty.example.service.base.BaseService;
//import com.selecty.example.util.DbUtil;

public class SearchService extends BaseService {

	public SearchService() throws Exception {
		super(true);
	}

	/**
	 * idアドレス、パスワードでログイン判定を行う
	 * @param id
	 * @param pass
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> doLogin(int id, String pass) throws Exception {
		Map<String, Object> loginData = new HashMap<>();
		EmployeeDao dao = new EmployeeDao(this.con);
		try {
			loginData.put("EMP", dao.selectLoginInfo(id, pass));
			
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return loginData;
	}

	
	

	/**
	 * 検索を行う
	 * @param form
	 * @return
	 */
	public List<EmployeeInfo> searchTodoInfo(TodoListInfo todo) throws Exception {
		TodoDao dao = new TodoDao(this.con);
		List<EmployeeInfo> todoList = null;
		try {
			todoList = dao.findByParam(todo);
			if (todoList.size() == 0 || todoList == null) {
			}
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return todoList;
	}

	/**
	 * ToDoリストの主キー検索を行う
	 * @param IdTodo
	 * @return
	 * @throws Exception
	 */
	public TodoListInfo searchTodoListByPkey(Integer idTodo) throws Exception {
		TodoDao dao = new TodoDao(this.con);
		TodoListInfo todoList = null;
		try {
			todoList = dao.findByPramaryKey(idTodo);
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return todoList;
	}

	/**
	 * メールアドレスの重複チェック
	 * @param id
	 * @param mail
	 * @return
	 * @throws Exception
	 */
//	public boolean checkDuplicationMail(Integer id, String mail) throws Exception {
//		// メールアドレスで検索を行う
//		dao dao = new dao(this.con);
//		try {
//			Employee emp = dao.findByMail(mail);
//
//			if (emp != null) {//一致するデータがあったとき
//				if (id == null || !id.equals(emp.getIdEmployee())) {//入力されたIDがデータと一致しているか
//					return true;
//				}
//			}
//		} finally {
//			DbUtil.closeConnection(this.con);
//		}
//		return false;
	}





