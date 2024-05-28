package entity;

import entity.BaseEntity.BaseEntity;

public class Employee extends BaseEntity{
	public static final String TITLE_ID_EMPLOYEE = "社員ID";
	public static final String TITLE_NM_EMPLOYEE = "社員名";
	public static final String TITLE_PASSWORD = "パスワード";

	/** 社員ID */
	private Integer idEmployee;
	/** 社員名 */
	private String nmEmployee;
	/** パスワード */
	private String password;

	/**
	 * 社員IDを取得します
	 * @return 社員ID
	 */
	public Integer getIdEmployee() {
		return idEmployee;
	}
	/**
	 * 社員IDを設定します
	 * @param idEmployee 社員ID
	 */
	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}
	/**
	 * 社員名を取得します
	 * @return 社員名
	 */
	public String getNmEmployee() {
		return nmEmployee;
	}
	/**
	 * 社員名を設定します
	 * @param nmEmployee 社員名
	 */
	public void setNmEmployee(String nmEmployee) {
		this.nmEmployee = nmEmployee;
	}
	/**
	 * パスワードを取得します
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * パスワードを設定します
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
