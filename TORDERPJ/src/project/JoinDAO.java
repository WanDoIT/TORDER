package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JoinDAO {

	//접근 제한자가 붙은 멤버 변수로 만들어줌
	private String url = MainClass.URL;
	private String uid = MainClass.UID; //계정
	private String upw = MainClass.UPW; //비밀번호

	//insert 메서드화
	public int insertEx(String name, String phonenumber) {

		int result = 0;

		//여기서부터 끝까지 메서드로 만들기
		String sql = "insert into JOIN (name, phonenumber) values (?, ?)";

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
			pstmt.setString(1, name);
			pstmt.setString(2, phonenumber);

			//4. sql 실행
			//(select 문은 query 문장 실행, insert, delete, update문은 update 메서드로 실행)
			result = pstmt.executeUpdate(); //위에 sql 들어가 있으니까 매개변수 없는 걸로 사용
			//result를 반환 받아서 가지고 나갈 것이기 때문에 성공, 실패에 대한 것은 없어도 됨.

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

		return result;
	}	

	//select 메서드화
	public ArrayList<JoinVO> selectEx(){
		JoinVO joinVO = new JoinVO();
		ArrayList<JoinVO> list = new ArrayList<>();
		String sql = "select * from join";

		Connection conn = null;
		PreparedStatement pstmt = null;
		//결과 저장 객체
		ResultSet rs = null; //select 결과를 반환 받을 객체

		try {
			//드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connection 연결
			conn = DriverManager.getConnection(url, uid, upw);
			//stmt
			pstmt = conn.prepareStatement(sql);
			//? 값에 대한 처리

			//sql 실행(select의 실행) 
			rs = pstmt.executeQuery();

			while (rs.next()) { 
				//다음행이 있으면 true를 반환 받아서 while문 실행
				//한 행에 대한 처리(getInt, getString, getDouble, getTimestamp, getDate)
				String name = rs.getString("name");
				String phonenumber = rs.getString("phonenumber"); //컬럼명

				//VO에 행 데이터 저장
				//VO를 list에 저장
				JoinVO vo = new JoinVO(name, phonenumber);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //(connection 해제 필수) - 오류가 생기면 꺼지지 않기 때문에 아래 finally에 써줘야 함.
			try {
				conn.close(); //finally 안에 try-catch문
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("close 에러");
			}

		}


		return list;

	}
}

