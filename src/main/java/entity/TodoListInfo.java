package entity;

import entity.BaseEntity.BaseEntity;

public class TodoListInfo implements BaseEntity{
	public static final String TITLE_NM = "ToDo";

	/** リストID（No.） */
	private  Integer idToDo;
	/** ToDo内容 */
	private String todo;
	/** 社員ID */
	private Integer workinglist_id;

//	public TodoListInfo() {}
//	public TodoListInfo(Employee emp) {
//		this.idToDo = emp;
//	}
	
	
	
	/**
	 * リストID（No.）を取得します
	 * @return リストID（No.）
	 */
	public Integer getIdToDo() {
		return idToDo;
	}
	/**
	 * リストID（No.）を設定します
	 * @param リストID（No.）
	 */
	public void setIdToDo(Integer idToDo) {
		this.idToDo = idToDo;
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
	public Integer getWorkinglist_id() {
		return workinglist_id;
	}
	/**
	 * 社員IDを設定します
	 * @param 社員ID
	 */
	public void setWorkinglist_id(Integer workinglist_id) {
		this.workinglist_id = workinglist_id;
	}
}
