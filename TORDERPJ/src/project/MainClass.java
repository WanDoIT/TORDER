package project;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		MenuUpdate menuupdate = new MenuUpdate();
		
		System.out.print("변경할 메뉴 이름 입력: ");
		String name = scan.next();
		System.out.println();
		System.out.print("변경 금액 입력:");
		int price = scan.nextInt();
		
		int result = menuupdate.priceUpdate(name, price);
		if(result ==1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		
	}
}
