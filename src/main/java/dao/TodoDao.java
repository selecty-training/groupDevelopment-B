package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.base.BaseDao;
import entity.EmployeeInfo;
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
	public List<EmployeeInfo> findByParam(TodoListInfo todo) throws SQLException {
		StringBuilder sql = new StringBuilder();

		// SQLの生成
		sql.append(" SELECT");
		sql.append("      e.id");
		sql.append("     ,e.password");
		sql.append("     ,e.name");
		sql.append("     ,t.id");
		sql.append("     ,t.todo");
		sql.append("     ,t.employeeList_id");
		sql.append(" FROM");
		sql.append("     employeeList e LEFT JOIN todoList t");
		sql.append("         ON e.id = t.employeeList_id");

		String keyword = " WHERE ";
		List<Object> paramList = new ArrayList<>();

		if (todo.getIdToDo() != null) {
			sql.append(keyword + " t.id = ?");
			paramList.add(todo.getIdToDo());
			keyword = " AND ";
		}

		if (!(Util.isStringEmpty(todo.getTodo()))) {
			sql.append(keyword + " t.todo LIKE ?");
			paramList.add("%" + todo.getTodo() + "%");
			keyword = " AND ";
		}

		if (todo.getEmployeeList_id() != null) {
			sql.append(keyword + " e.id = ?");
			paramList.add(todo.getEmployeeList_id());
			keyword = " AND ";
		}

		// Statementの生成および条件の設定
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(paramList.toArray());

		ResultSet rs = stmt.executeQuery();

		// 検索結果の取得
		List<EmployeeInfo> todoList = new ArrayList<>();
		while (rs.next()) {
			EmployeeInfo todoInfo = new EmployeeInfo(rowMapping2(rs));
			todoInfo.setEmployee(rs.getString("name"));
			todoInfo.setId(rs.getInt("e.id"));
			todoList.add(todoInfo);
		}

		// 見つからなかった
		this.closeStatement();
		return todoList;
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
				 ,todo.getEmployeeList_id()
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
	protected TodoListInfo rowMapping2(ResultSet rs) throws SQLException {
		TodoListInfo todo = new TodoListInfo();
		todo.setIdToDo(rs.getInt("t.id"));
		todo.setTodo(rs.getString("todo"));
		todo.setEmployeeList_id(rs.getInt("employeeList_id"));
		return todo;
	}

	@Override
	protected String[] getColumnsList() {
		return new String[]{
				 "id"
				,"todo"
				,"employeeList_id"
		};
	}

	@Override
	protected String[] getPrimaryKey() {
		return new String[]{
				"id"
		};
	}

}
