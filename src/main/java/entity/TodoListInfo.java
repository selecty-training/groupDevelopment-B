package entity;

import entity.BaseEntity.BaseEntity;

public class TodoListInfo implements BaseEntity{
	public static final String TITLE_NM = "ToDo";

	/** リストID（No.） */
	private  Integer idTodo;
	/** ToDo内容 */
	private String todo;
	/** 社員ID */
	private Integer employeeList_id;
	
	/**
	 * リストID（No.）を取得します
	 * @return リストID（No.）
	 */
	public Integer getIdToDo() {
		return idTodo;
	}
	/**
	 * リストID（No.）を設定します
	 * @param リストID（No.）
	 */
	public void setIdToDo(Integer idToDo) {
		this.idTodo = idToDo;
	}
	/**
	 * ToDo内容を取得します
	 * @return ToDo内容
	 */
	public String getTodo() {
		return todo;
	}
	/**
	 * ToDo内容を設定します
	 * @param ToDo内容
	 */
	public void setTodo(String todo) {
		this.todo = todo;
	}
	/**
	 * 社員IDを取得します
	 * @return 社員ID
	 */
	public Integer getEmployeeList_id() {
		return employeeList_id;
	}
	/**
	 * 社員IDを設定します
	 * @param 社員ID
	 */
	public void setEmployeeList_id(Integer employeeList_id) {
		this.employeeList_id = employeeList_id;
	}
}
