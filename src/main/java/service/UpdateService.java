package service;

import java.util.ArrayList;
import java.util.List;

import dao.TodoDao;
import entity.Employee;
import service.BaseService.BaseService;
//
//import com.selecty.example.dao.EmployeeDao;
//import com.selecty.example.entity.Employee;
//import com.selecty.example.service.UpdateService.UPDATE_MODE;
//import com.selecty.example.service.base.BaseService;
//import com.selecty.example.util.DbUtil;
import util.DbUtil;

public class UpdateService extends BaseService {

	public UpdateService() throws Exception {
		super(false);
	}

	public enum UPDATE_MODE {
		 INSERT
		,UPDATE
	}

	/**
	 * 社員の登録・更新を行う
	 * @param emp
	 * @return
	 * @throws Exception
	 */
	public int registEmployee(Employee emp, UPDATE_MODE mode) throws Exception {
		TodoDao dao = new TodoDao(this.con);
		int count = -1;

		try {
			if (mode == UPDATE_MODE.INSERT) {
				count = dao.insertEmployee(emp);
			} else if (mode == UPDATE_MODE.UPDATE){
				// DAO -> List<Object>（DAO#updateを呼び出すため）
				List<Object> paramList = new ArrayList<>();
				paramList.add(emp.getIdEmployee());
				paramList.add(emp.getNmEmployee());
				paramList.add(emp.getPassword());
				
				
				count = dao.updateByPrimaryKey(paramList, emp.getIdEmployee());
			}
			this.con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
			throw new Exception("登録できませんでした:" + e.getMessage());
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return count;
	}

	/**
	 * 社員情報の物理削除を行う
	 * @param empId
	 * @return
	 * @throws Exception
	 */
	public int deleteEmployee(Integer empId) throws Exception {
		TodoDao dao = new TodoDao(this.con);
		int deleteCount = -1;

		try {
			deleteCount = dao.deleteByPrimaryKey(empId);
			this.con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
			throw new Exception("削除できませんでした:" + e.getMessage());
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return deleteCount;
	}

}


