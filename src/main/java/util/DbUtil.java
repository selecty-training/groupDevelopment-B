package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	// 定数定義（共通）
	private static final String DB_HOST = "127.0.0.1";
	private static final String DB_NAME = "selectydb";
	private static final String DB_USER = "selectyuser";
	private static final String DB_PASS = "selecty_2024";

	// 定数定義（MySQL用）
	private static final String DBMS ="mysql";
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_PORT = "3306";
	private static final String DB_URL = "jdbc:" + DBMS + "://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
	//		+ "?serverTimezone=JST";	//JDBCドライバのバージョン8.0.22以前を利用する場合は必要

	// インスタンス化の禁止
	private DbUtil() {}

	// Connectionを単一のインスタンスとする
	private static Connection con;

	/**
	 * DBのコネクションを取得
	 * @return DBコネクション
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection(boolean autoCommitFlg) throws ClassNotFoundException, SQLException {
		if (con == null || con.isClosed()) {
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		}
		con.setAutoCommit(autoCommitFlg);
		return con;
	}

	/**
	 * DBとのコネクションを切断
	 * @param con DBコネクション
	 * @throws SQLException
	 */
	public static void closeConnection(Connection con) throws SQLException {
		if (con != null && con.isClosed() != false) { con.close(); }
	}
}
