package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class MenuUpdate {

		public int priceUpdate(String name, int price) {

			int result = 0;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //주소
		String uid = "JORDER"; //계정
		String upw = "1234"; //비밀번호
		
		String sql = "update menu set price = ? where name = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connection
			conn = DriverManager.getConnection(url, uid, upw);		
			//statement 객체
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(2,name );
			pstmt.setInt(1, price);
			System.out.println();

			result = pstmt.executeUpdate(); //성공.실패 결과 반환
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
