package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.base.BaseDao;
import entity.Employee;
import entity.TodoListInfo;
import util.Util;

public class TodoDao  extends BaseDao<TodoListInfo> {

	public TodoDao(Connection con) {
		super(con);
	}
	
	
	
//	/**
//	 * idでの検索を行う
//	 * @param id 検索するid
//	 * @return 検索結果
//	 */
//	public Employee findById(int id) throws SQLException {
//		Employee entity = null;
//		StringBuilder sql = new StringBuilder();
//
//		// SQLの生成
//		sql.append(" SELECT * FROM " + this.getTableName());
//		sql.append(" WHERE id = ?");
//
//		// Statementの生成および条件の設定
//		this.stmt = this.con.prepareStatement(sql.toString());
//		setParameter(id);
//
//		ResultSet rs = stmt.executeQuery();
//
//		// 検索結果の取得
//		if (rs.next()) {
//			entity = rowMapping(rs);
//		}
//
//		this.closeStatement();
//		return entity;
//	}
	
	/**
	 * 条件検索を行う
	 * @param emp 検索条件
	 * @return 検索結果
	 */
	public List<TodoListInfo> findByParam(Employee emp) throws SQLException {
		StringBuilder sql = new StringBuilder();

		// SQLの生成
		sql.append(" SELECT");
		sql.append("      w.id");
		sql.append("     ,w.password");
		sql.append("     ,w.name");
		sql.append("     ,t.id");
		sql.append("     ,t.todo");
		sql.append("     ,t.workinglist_id");
		sql.append(" FROM");
		sql.append("     workingList w INNER JOIN todoList t");
		//sql.append("         ON e.id_department = d.id_department");

		String keyword = " WHERE ";
		List<Object> paramList = new ArrayList<>();

		if (emp.getIdEmployee() != null) {
			sql.append(keyword + " e.id_employee = ?");
			paramList.add(emp.getIdEmployee());
			keyword = " AND ";
		}

		if (!(Util.isStringEmpty(emp.getNmEmployee()))) {
			sql.append(keyword + " e.nm_employee LIKE ?");
			paramList.add("%" + emp.getNmEmployee() + "%");
			keyword = " AND ";
		}

		if (!(Util.isStringEmpty(emp.getKnEmployee()))) {
			sql.append(keyword + " e.kn_employee LIKE ?");
			paramList.add("%" + emp.getKnEmployee() + "%");
			keyword = " AND ";
		}

		if (!(Util.isStringEmpty(emp.getMailAddress()))) {
			sql.append(keyword + " e.mail_address LIKE ?");
			paramList.add("%" + emp.getMailAddress() + "%");
			keyword = " AND ";
		}

		if (emp.getIdDepartment() != null) {
			sql.append(keyword + " e.id_department = ?");
			paramList.add(emp.getIdDepartment());
			keyword = " AND ";
		}

		// Statementの生成および条件の設定
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(paramList.toArray());

		ResultSet rs = stmt.executeQuery();

		// 検索結果の取得
		List<EmployeeInfo> empList = new ArrayList<>();
		while (rs.next()) {
			EmployeeInfo empInfo = new EmployeeInfo(rowMapping(rs));
			empInfo.setNmDepartment(rs.getString("nm_department"));
			empList.add(empInfo);
		}

		// 見つからなかった
		this.closeStatement();
		return empList;
	}
	
	/**
	 * todoリストの登録を行う
	 * @param todo
	 * @return
	 */
	public int insertTodo(TodoListInfo todo) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO " + this.getTableName());
		sql.append("(");
		sql.append("     todo");
		sql.append("    ,employeeList_id");
		sql.append(") VALUES ( ?, ?)");

		// Statementの生成および条件の設定
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(
				 todo.getTodo()
				 ,todo.getWorkinglist_id()
		);

		int count = this.stmt.executeUpdate();

		this.closeStatement();
		return count;
	}


	
	
	
	
	
	

	@Override
	protected String getTableName() {
		return "todoList";
	}

	@Override
	protected TodoListInfo rowMapping(ResultSet rs) throws SQLException {
		TodoListInfo todo = new TodoListInfo();
		todo.setIdToDo(rs.getInt("id"));
		todo.setTodo(rs.getString("todo"));
		todo.setEmployeeList_id(rs.getInt("employeeList_id"));
		return todo;
	}

	@Override
	protected String[] getColumnsList() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	protected String[] getPrimaryKey() {
		return new String[]{
				"id"
		};
	}

}
