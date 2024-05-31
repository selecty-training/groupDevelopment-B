package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.base.BaseDao;
import entity.Employee;
import entity.EmployeeInfo;
import entity.TodoListInfo;

public class EmployeeDao extends BaseDao<Employee> {

	public EmployeeDao(Connection con) {
		super(con);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	/**
	 * ログインで入力された情報で検索を行う
	 * @param id
	 * @param pass
	 * @return ログイン情報に合致した社員情報
	 */
	public Employee selectLoginInfo(int id, String pass) throws SQLException {
		Employee entity = null;
		StringBuilder sql = new StringBuilder();

		// SQLの生成
		sql.append(" SELECT * FROM " + this.getTableName());
		sql.append(" WHERE id = ? AND password = ?");

		// Statementの生成および条件の設定
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(id, pass);

		ResultSet rs = stmt.executeQuery();

		// 主キー検索のため、0件、または1件と想定
		if (rs.next()) {
			entity = rowMapping(rs);
		}

		// 見つからなかった
		this.closeStatement();
		return entity;
	}
	
	public EmployeeInfo findEmployeeByPramaryKey(int id) throws SQLException {
		EmployeeInfo employeeInfo = null;
		Employee employee = null;
		StringBuilder sql = new StringBuilder();
		String[] pkList = this.getPrimaryKey();


		// SQLを生成
		sql.append(" SELECT");
		sql.append("      e.id");
		
		sql.append("     ,e.name");
		sql.append("     ,t.id");
		sql.append("     ,t.todo");
		sql.append("     ,t.employeeList_id");
		sql.append(" FROM");
		sql.append("     employeeList e LEFT JOIN todoList t");
		sql.append("         ON e.id = t.employeeList_id");
		
		sql.append(" WHERE t.id = ?");

		// Statementの生成および条件の設定
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(id);

		ResultSet rs = stmt.executeQuery();

		// 検索結果の取得
				
				if (rs.next()) {
					employeeInfo = new EmployeeInfo(rowMapping2(rs));
					employeeInfo.setEmployee(rs.getString("name"));
					employeeInfo.setId(rs.getInt("e.id"));
					
				}
		
		

		// 見つからなかった
		this.closeStatement();
		return employeeInfo;
	}
	
	/**
	 * 社員IDでの検索を行う
	 * @param ID 検索するID
	 * @return 検索結果
	 */
	public Employee findByID(int id) throws SQLException {
		Employee entity = null;
		StringBuilder sql = new StringBuilder();

		// SQLの生成
		sql.append(" SELECT * FROM " + this.getTableName());
		sql.append(" WHERE id = ?");

		// Statementの生成および条件の設定
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(id);

		ResultSet rs = stmt.executeQuery();

		// 検索結果の取得
		if (rs.next()) {
			entity = rowMapping(rs);
		}

		this.closeStatement();
		return entity;
	}

	@Override
	protected String getTableName() {
		return "employeeList";
	}

	@Override
	protected Employee rowMapping(ResultSet rs) throws SQLException {
		Employee emp = new Employee();
		emp.setIdEmployee(rs.getInt("id"));
		emp.setPassword(rs.getString("password"));
		emp.setNmEmployee(rs.getString("name"));
		return emp;
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
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	protected String[] getPrimaryKey() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	
	

}
