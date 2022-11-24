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

	private String url2 = MainClass.URL;
	private String uid2 = MainClass.UID;
	private String upw2 = MainClass.UPW;
	
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
		public ArrayList<OrderList> selectEx(int num) {
			ArrayList<OrderList> list = new ArrayList<>();
			
			String sql = "SELECT SUM(M.PRICE * ORDERCOUNT) PRICE, ORDERCOUNT, O.NAME, TABLE_NO  \r\n"
					+ "FROM ORDERINFO O\r\n"
					+ "LEFT OUTER JOIN MENU M\r\n"
					+ "ON O.NAME = M.NAME\r\n"
					+ "WHERE TABLE_NO = ?\r\n"
					+ "GROUP BY TABLE_NO , O.NAME , ORDERCOUNT";
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
				pstmt.setInt(1, num);
				
				//sql 실행 (select의 실행)
				rs = pstmt.executeQuery();
				
				while(rs.next()) { //다음 row가 있다면 true 
					//한 행에 대한 처리
					int price = rs.getInt("PRICE");
					int ordercount = rs.getInt("ORDERCOUNT");
					String name = rs.getString("NAME");
					int tableno = rs.getInt("TABLE_NO");
					
					
					//
					OrderList ordervo = new OrderList(price, ordercount,name,tableno);
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
		
	public void tablenum(int tablenum) {
		OrderListDAO orderlist = new OrderListDAO();
		switch (tablenum) {
		case 1: {
			ArrayList<OrderList> list = orderlist.selectEx(1);
			for(OrderList a : list) {
				System.out.println(a.toString());
			}
			break;
		}
		case 2: {
			ArrayList<OrderList> list = orderlist.selectEx(2);
			for(OrderList a : list) {
				System.out.println(a.toString());
			}
			break;
		}
		case 3: {
			ArrayList<OrderList> list = orderlist.selectEx(3);
			for(OrderList a : list) {
				System.out.println(a.toString());
			}
			break;
		}
		case 4: {
			ArrayList<OrderList> list = orderlist.selectEx(4);
			for(OrderList a : list) {
				System.out.println(a.toString());
			}
			break;
		}
		case 5: {
			ArrayList<OrderList> list = orderlist.selectEx(5);
			for(OrderList a : list) {
				System.out.println(a.toString());
			}
			break;
		}
		default:
			System.out.println("테이블 번호를 잘못 입력 했습니다.");
			break;
		}
	}

}
