package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;


public class MainClass {
	
	public static final String URL = "jdbc:oracle:thin:@172.30.1.18:1521:xe";
	public static final String UID = "JORDER";
	public static final String UPW = "1234";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		JoinDAO joinDAO = new JoinDAO();
		OrderListDAO orderlist = new OrderListDAO();
		
		while(true) {

			try {
				System.out.println("인생술집");
				System.out.println("[1. 가입 2. 메뉴 3. 주문 4. 주문내역 확인 5. 관리자 모드]");
				String menu = scan.next();

				switch (menu.trim()) {

				case "1":

					System.out.print("이름>");
					String name = scan.next();
					
					System.out.print("핸드폰 번호>");
					String phonenumber = scan.next();
					
					
					int result = joinDAO.insertEx(name, phonenumber);
					
					if(result == 1) {
						System.out.println("정상 입력되었습니다.");
						System.out.println("이제 인생 맥주의 소식과 쿠폰을 받을 수 있습니다!");
					} else {
						System.out.println("입력 오류 발생");
					}
					
					break;
					
				case "2":
				
					
					
					break;
					
				case "3":
					break;
					
				case "4":
					System.out.println("테이블 번호를 선택해주세요.");
					String tablenum = scan.next();
					orderlist.tablenum(tablenum);
					
					
					break;
					
				case "5":
					System.out.println("관리자 모드로 들어갑니다");
					System.out.println("아이디와 비밀번호를 입력하세요");
					System.out.println("아이디: ");
					String manager_id = scan.next();
					System.out.println("비밀번호: ");
					int manager_password = scan.nextInt();
					if(manager_id.equals("hr") && manager_password == 1234) {
						System.out.println("로그인 성공");
						System.out.println("관리자 메뉴를 선택하세요");
						System.out.println("1. 일자별 집계 2. 전체 고객 내역 확인 3. 메뉴 변경");
						int managermenuselect = scan.nextInt();
						
						switch (managermenuselect) {
						
						case 1:
							System.out.println("1. 일자별 집계 내역 확인");
							//동민이꺼 연결해서 넣기
							
							break;
							
						case 2: 
							System.out.println("2. 전체 고객 내역 확인");
							ArrayList<JoinVO> list1 = joinDAO.selectEx();
							for(JoinVO vo : list1) {
								System.out.println(vo.toString());
							}
							
						case 3:
							System.out.println("3. 메뉴 변경");
							//Scanner scan1 = new Scanner(System.in);
							MenuUpdate menuupdate = new MenuUpdate();
							
							System.out.print("변경할 메뉴 이름 입력: ");
							//메뉴 보여주기
							String name2 = scan.next();
							System.out.println();
							System.out.print("변경 금액 입력:");
							int price = scan.nextInt();
							
							int result2 = menuupdate.priceUpdate(name2, price);
							if(result2 ==1) {
								System.out.println("성공");
							} else {
								System.out.println("실패");
								
							}
							
						default:
							break;
						}
						
					} else {
						System.out.println("로그인 실패");
					}
					
					
					break;

				default:
					break;
				}

			} catch (Exception e) {
				e.printStackTrace(); //에러가 나도 멈추지 않음.
			}



		}


	}

}
