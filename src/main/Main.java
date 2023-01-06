package main;

import java.util.Scanner;

import DAO.AccountDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		AccountDAO dao = new AccountDAO();
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		loop : while(true) {
			System.out.println("\n====가계부 프로그램====");
			// menu
			System.out.println("1. 검색\n2. 기입\n3. 수정\n4. 삭제\n5. 종료");
			System.out.print("\n메뉴를 선택해주세요 > ");
			
			int menu = scanner.nextInt();
			
			switch(menu) {
				case 1 : dao.select();
				break;
				case 2 : dao.insert();
				break;
				case 3 : dao.update();
				break;
				case 4 : dao.delete();
				break;
				case 5 : break loop;
			} // end of switch
			
		} // end of while 
		
	} // end of main
} // end of class