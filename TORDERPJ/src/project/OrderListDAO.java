package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import project.OrderList;

public class OrderListDAO {
	private String url2 = MainClass.URL2;
	private String uid2 = MainClass.UID2;
	private String upw2 = MainClass.UPW2;
	
	public int insert(String order_no,String phone_number ) {
		int result = 0;
		Scanner scan = new Scanner(System.in);
		
		String sql = "insert into Order_list values(order_list_seq , sysdate, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connection
			conn = DriverManager.getConnection(url2 , uid2 , upw2);
			//statement 객체
			pstmt = conn.prepareStatement(sql);
			//3. ?값 세팅 - 첫번째부터 1번 순서 (setString, setInt, setDate, setTimestmp)
			pstmt.setString(1, order_no);
			pstmt.setString(2, phone_number);
			
			
			
			//4. sql 실행 (Select 문은 query 문장 실행 , i, d, u 문은 update메서드로 실행)
			result = pstmt.executeUpdate(); //성공 ,실패 반환
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	//조회메서드
		public ArrayList<OrderList> selectEx() {
			ArrayList<OrderList> list = new ArrayList<>();
			
			String sql = "select * from order_list";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null; //select 결과를 반환받을 객체
			
			try {
				//드라이버 로드 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//conn
				conn=DriverManager.getConnection(url2, uid2, upw2 );
				
				//stmt
				pstmt = conn.prepareStatement(sql);
				
				//?값에 대한 처리
				
				
				//sql 실행 (select의 실행)
				rs = pstmt.executeQuery();
				
				while(rs.next()) { //다음 row가 있다면 true 
					//한 행에 대한 처리
					int OrderNo = rs.getInt("ORDER_NO");
					String OrderDate = rs.getString("ORDER_DATE");
					
					
					//
					OrderList ordervo = new OrderList(OrderNo, OrderDate);
					list.add(ordervo);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			return list;
		}
	
	
}
