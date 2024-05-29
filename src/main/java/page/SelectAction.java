package page;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.selecty.example.entity.EmployeeInfo;

import entity.Employee;
import page.base.BaseServlet;
import service.SearchService;

/**
 * Servlet implementation class SelectAction
 */
@WebServlet(name = "select", urlPatterns = { "/select" })
public class SelectAction extends BaseServlet {
	
	@Override
	protected String getPageName() {
		return "select";
	}

	@Override
	protected String doAction() throws Exception {
		String[] pageParam = super.getInputParameter(
				"idTodo" // 0
				, "todo" // 1
				, "empKn" // 2
				, "mail" // 3
				, "depId" // 4
		);
		
		Integer id = null;

		// 入力チェック
		/*
		 * IDが数値でない場合は検索しなくても0件
		 */
		if (pageParam[0].trim().length() > 0) {
			try {
				id = Integer.parseInt(pageParam[0]);
			} catch (NumberFormatException e) {
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
		}

		// 画面入力値 -> DTOへ
		Employee employee = new Employee();
		employee.setIdEmployee(id);
		employee.setNmEmployee(pageParam[1]);
		employee.setKnEmployee(pageParam[2]);
		employee.setMailAddress(pageParam[3]);
		if (!"".equals(pageParam[4])) {
			employee.setIdDepartment(Integer.parseInt(pageParam[4]));
		}

		// 検索を行う
		SearchService service = new SearchService();
		List<EmployeeInfo> empInfoList = service.searchEmployeeInfo(employee);

		// 検索結果の判定
		if (empInfoList.size() == 0) {
			throw new Exception("入力された条件で情報が見つかりませんでした");
		}

		// 取得した結果をセット
		super.request.setAttribute("empInfoList", empInfoList);
		return "selectResult";
	}

}
