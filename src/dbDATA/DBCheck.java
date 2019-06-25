package dbDATA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCheck {

	// 아이디를 검색한다.
	public static String dbIDSelect(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet res;
		String sql = "select ID From Member where id='" + id + "'";
		String result = " ";

		int su = 0;

		try {

			conn = DBConnection.getConnection();

			// 연결된 값을 Statement 즉 SQL문을 보낼수 있는 객체로 변경한다.
			stmt = conn.createStatement();
			System.out.println("sql 동작되는 객체로");
			// ResultSet쿼리에 의해 생성 된 데이터를 포함 하는 객체를 만든다.
			System.out.println(sql);
			// sql문 입력
			res = stmt.executeQuery(sql);
			// 여기 까지 동작이됨

			while (res.next()) {
				result = res.getString("ID");
			}

			// row 다음줄 확인

			return result;
		} catch (SQLException e) {
			System.out.println("문제발생");
			return "에러";
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {

			}

		}

	}

	// 해당 칼럼을 DTO로 넣은다
	public static MiniDTO dbSelectDTOSettion(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet res = null;
		String sql = "select * from Member where id='" + id + "'";
		int su = 0;
		String vID, vPW, vNick;
		int vbase_Problem_Check, vMiddel_Problem_Check, vComplete_Problem_Check;
		MiniDTO Dto = new MiniDTO();

		try {

			conn = DBConnection.getConnection();

			// 연결된 값을 Statement 즉 SQL문을 보낼수 있는 객체로 변경한다.
			stmt = conn.createStatement();

			// ResultSet쿼리에 의해 생성 된 데이터를 포함 하는 객체를 만든다.
			res = stmt.executeQuery(sql);

			// row 다음줄 확인
			// 해당 컬럼을 받고 해당값을 다음 변수에 입력받는다.
			while (res.next()) {
				vID = res.getString("id");
				vPW = res.getString("pw");
				vNick = res.getString("nick");
				vbase_Problem_Check = res.getInt("base_Problem_Check");
				vMiddel_Problem_Check = res.getInt("Middel_Problem_Check");
				vComplete_Problem_Check = res.getInt("Complete_Problem_Check");

				Dto = new MiniDTO(vID, vPW, vNick, vbase_Problem_Check, vMiddel_Problem_Check, vComplete_Problem_Check);
			}
			return Dto;
		} catch (SQLException e) {
			System.out.println("문제발생");
			return Dto;
		} finally {
			try {
				res.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {

			}

		}

	}

	// 회원 수정
	public static void dbMemberUpdate(String getPW, String getNick, String getID) {
		Connection conn = null;
		Statement stmt = null;

		int su = 0;

		try {
			String sql = "update Member set pw = '" + getPW + "', nick = '" + getNick + "' where id'" + getID + "' ";
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			su = stmt.executeUpdate(sql);
			if (su != 0) {
				System.out.println("수정완료");
			}

		} catch (SQLException e) {
			System.out.println("문제발생");
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {

			}

		}

	}

	// 회원가입
	public static void dbNewMemberInsert(String getID, String getPw, String getNick) {
		Connection conn = null;
		Statement stmt = null;

		int su = 0;

		try {
			String sql = "insert into Member values('" + getID + "', '" + getPw + "', '" + getNick + "', 0, 0, 0)";
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			su = stmt.executeUpdate(sql);
			if (su != 0) {
				System.out.println("생성완료");
			}

		} catch (SQLException e) {
			System.out.println("문제발생");
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {

			}

		}

	}

	// 게임 종료후 값을 데이터에 기입
	public static void dbGameInsert(int base_Problem_Check, int Middel_Problem_Check, int Complete_Problem_Check,
			String id) {
		Connection conn = null;
		Statement stmt = null;

		int su = 0;

		try {
			String sql = "UPDATE Member set base_Problem_Check =" + base_Problem_Check + "," + " Middel_Problem_Check ="
					+ Middel_Problem_Check + ",Complete_Problem_Check=" + Complete_Problem_Check + " where ID='" + id
					+ "'";
			System.out.println(sql);
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			su = stmt.executeUpdate(sql);
			if (su != 0) {
				System.out.println("생성완료");
			}

		} catch (SQLException e) {
			System.out.println("문제발생");
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {

			}

		}

	}

	// 회원 탈퇴
	public static void dbDelete(String getID) {
		Connection conn = null;
		Statement stmt;

		int su = 0;

		try {
			String sql = "Delete From Member where ID='" + getID + "'";
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			su = stmt.executeUpdate(sql);
			if (su != 0) {
				System.out.println("삭제완료");
			}

		} catch (SQLException e) {
			System.out.println("문제발생");
		}

	}

}
