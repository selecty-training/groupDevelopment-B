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

	protected TodoDao(Connection con) {
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
	
	
	
	
	
	
	
	
	

	@Override
	protected String getTableName() {
		return "todoList";
	}

	@Override
	protected Employee rowMapping(ResultSet rs) throws SQLException {
		Employee employee = new Employee();
		employee.setIdEmployee(rs.getInt("id_employee"));
		employee.setNmEmployee(rs.getString("nm_employee"));
		employee.setKnEmployee(rs.getString("kn_employee"));
		employee.setMailAddress(rs.getString("mail_address"));
		employee.setPassword(rs.getString("password"));
		employee.setIdDepartment(rs.getInt("id_department"));
		return employee;
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
