package service.BaseService;

import java.sql.Connection;

import util.DbUtil;

public class BaseService {
	protected Connection con;

	/**
	 * コンストラクタでDBコネクションを生成。
	 * 検索系はfalse、更新系はtrueを引数で指定する
	 * @param autoCommitFlg(true:自動コミット有効、false:自動コミット無効(トランザクション開始))
	 * @throws Exception
	 */
	protected BaseService(boolean autoCommitFlg) throws Exception {
		try {
			this.con = DbUtil.getConnection(autoCommitFlg);
		} catch(Exception e) {
			throw new Exception("データベースに接続できません");
		}
	}
}



