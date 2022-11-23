package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert {

	public static void main(String[] args) {

		//insert

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "hr"; //계정
		String upw = "hr"; //비밀번호

		String sql = "insert into auth values(seq_auth.nextval,?,?)";
		//첫번째 값 nextval, 두번째 값에는 name
		
		Connection conn = null;
		PreparedStatement pstmt = null;


		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//connection 객체 생성, = 앞에 connection 인터페이스
			conn = DriverManager.getConnection(url, uid, upw);

			System.out.println(conn);

			//statement 객체
			//conn.createStatement(); 도 사용 가능
			//함수 호출하고 객체 타입 반환
			pstmt = conn.prepareStatement(sql);

			//3. ?값을 세팅하기 - 첫번째부터 1번 순서
			//(setString, setInt, setDate, setTimeStamp-날짜 형식)
			//밑에 두 줄이 물음표(2,3번째) 값으로 들어감
			pstmt.setString(1, "홍길동");
			pstmt.setString(2, "프로그래머");

			//4. sql 실행
			//(select 문은 query 문장 실행, insert, delete, update문은 update 메서드로 실행)
			int result = pstmt.executeUpdate(); //위에 sql 들어가 있으니까 매개변수 없는 걸로 사용
			//성공과 실패를 반환
			
			if(result == 1) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}

		} catch (Exception e) {
			e.printStackTrace(); //에러 로그를 봐야하니까
		} finally { //(connection 해제 필수) - 오류가 생기면 꺼지지 않기 때문에 아래 finally에 써줘야 함.
			try {
				conn.close(); //finally 안에 try-catch문
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("close 에러");
			}
		}


	}

}
