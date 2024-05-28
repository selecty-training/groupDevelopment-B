package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.base.BaseDao;
import entity.Employee;

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
