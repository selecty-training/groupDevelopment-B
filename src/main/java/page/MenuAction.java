package page;

import javax.servlet.annotation.WebServlet;

public class MenuAction {
	/**
	 * メニュー（トップ）画面から何かしらの処理を行うためのクラスです。
	 * 今回の対象システムでは不要ですが、SPAなどを作成する場合はまとめましょう
	 * @author IT-College
	 *
	 */
	@WebServlet(name="menu", urlPatterns={"/menu"})
	public class MenuAction extends BaseServlet {
		@Override
		protected String getPageName() {
			return "menu";
		}

		@Override
		protected String doAction() throws Exception {
			return this.getPageName();
		}
	}

}
