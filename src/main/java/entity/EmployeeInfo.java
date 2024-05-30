package entity;

import entity.BaseEntity.BaseEntity;

public class EmployeeInfo implements BaseEntity {
	public static final String TITLE_NM_DEPARTMENT = "ToDo";

//	/** 社員情報 */
//	private Employee employee;
//	/** todo */
//	private String todo;
//
//	public EmployeeInfo() {}
//	public EmployeeInfo(Employee emp) {
//		this.employee = emp;
//	}
//
//	/**
//	 * 社員情報を取得します
//	 * @return 社員情報
//	 */
//	public Employee getEmployee() {
//		return employee;
//	}
//	/**
//	 * 社員情報を設定します
//	 * @param employee 社員情報
//	 */
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//	/**
//	 * todoを取得します
//	 * @return
//	 */
//	public String getTodo() {
//		return todo;
//	}
//	/**
//	 * todoを設定します
//	 * @param nmDepartment
//	 */
//	public void settodo(String todo) {
//		this.todo = todo;
//	}
	/** 社員ID */
	private Integer id;
	
	/** 社員名 */
	private String name;
	/** todo */
	private TodoListInfo todo;
	

	public EmployeeInfo() {}
	public EmployeeInfo(TodoListInfo todo) {
		this.todo = todo;
	}

	/**
	 * 社員名を取得します
	 * @return 社員名
	 */
	public String getEmployee() {
		return name;
	}
	/**
	 * 社員名を設定します
	 * @param employee 社員名
	 */
	public void setEmployee(String name) {
		this.name = name;
	}
	/**
	 * todoを取得します
	 * @return
	 */
	public TodoListInfo getTodo() {
		return todo;
	}
	/**
	 * todoを設定します
	 * @param nmDepartment
	 */
	public void setTodo(TodoListInfo todo) {
		this.todo = todo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
