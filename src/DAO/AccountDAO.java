package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DTO.AccountDTO;
import main.Main;

public class AccountDAO {

	Scanner scanner = new Scanner(System.in);
	
	// list 생성
	private List<AccountDTO> list = new ArrayList<AccountDTO>();

	// 기본 생성자
	public AccountDAO() {
		// 샘플데이터
		list.add(new AccountDTO("22/12/24", "영화관람", "지출", 25000, "아바타2"));
		list.add(new AccountDTO("22/12/27", "월급", "수입", 3000000, "12월급여"));
		list.add(new AccountDTO("22/12/25", "용돈", "수입", 50000, "12월용돈2"));
		list.add(new AccountDTO("22/12/30", "용돈", "수입", 100000, "12월용돈1"));
		list.add(new AccountDTO("23/01/06", "용돈", "수입", 50000, "새해용돈"));
		list.add(new AccountDTO("23/01/06", "용돈", "수입", 50000, "새해용돈"));
	}
	
	
	/*
	 *	@SELECT
	 */
	// 검색 기준 : 년월별 결산
	public void selectDate() {
		
	}
	// 검색 기준 : 용도
	public void usage() {
		System.out.print("용도를 입력해주세요 > ");
		String usage = scanner.next();

		int index = searchMethod(usage);
		
		if(index == -1) 
			System.out.println("해당하는 데이터를 찾을 수 없습니다.");
		select();
	} // end of usage


	public int searchMethod(String usage) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if(usage.equals(list.get(i).getUse())) {
				index = i;
				System.out.println(list.get(index));
				break;
			} // end of if
		} // end of for
		return index;
	}
	
	// 검색 기준 : 용도
	public void select() {
		System.out.println("\n1. 년월별 결산\n2. 수입/지출별\n3. 용도별\n4. 종료");
		System.out.print("\n검색 기준을 선택해주세요 > ");
		int menu = scanner.nextInt();
		
		switch(menu) {
			case 1: selectDate();
				break;
			case 2:
				break;
			case 3: usage();
				break;
			case 4: return;
		} // end of switch
			
	} // end of select()

	/*
	 *	@INSERT 
	 */
	public void insert() {
		System.out.println("가계부 기입을 시작합니다.\n.\n.\n");
		
		System.out.print("날짜를 입력해주세요 > ");
		String date = scanner.next();
		
		System.out.print("용도를 입력해주세요 > ");
		String use = scanner.next();
		
		System.out.print("수입ㆍ지출을 구분해주세요 > ");
		String classify = scanner.next();
		
		System.out.print("금액을 입력해주세요 > ");
		int money = scanner.nextInt();
		
		System.out.print("내용을 입력해주세요 > ");
		String memo = scanner.next();
		
		System.out.println("\n기입이 완료되었습니다!");
		
		AccountDTO dto = new AccountDTO(date, use, classify, money, memo);
		list.add(dto);
	}
	
	/*
	 * @UPDATE
	 */
	public void update() {
		System.out.print("수정할 데이터의 용도를 입력해주세요 > ");
		String usage = scanner.next();
		
		int index = searchMethod(usage);
		System.out.println("\n변경할 항목을 골라주세요.\n\n1. 날짜\n2. 용도\n3. 수입/지출\n4. 금액\n5. 메모");
		int num = scanner.nextInt();
		
		switch(num) {
			case 1: 
				System.out.print("날짜를 수정해주세요 > ");
				String date = scanner.next();
				list.get(index).setDate(date);
				System.out.println(".\n.\n.\n날짜가 성공적으로 변경되었습니다.");
				break;
			case 2:
				System.out.print("용도를 수정해주세요 > ");
				String use = scanner.next();
				list.get(index).setUse(use);
				System.out.println(".\n.\n.\n용도가 성공적으로 변경되었습니다.");
				break;
			case 3:
				System.out.print("수입/지출을 수정해주세요 > ");
				String classify = scanner.next();
				list.get(index).setClassify(classify);
				System.out.println(".\n.\n.\n수입/지출이 성공적으로 변경되었습니다.");
				break;
			case 4:
				System.out.print("금액을 수정해주세요 > ");
				int money = scanner.nextInt();
				list.get(index).setMoney(money);
				System.out.println(".\n.\n.\n금액이 성공적으로 변경되었습니다.");
				break;
			case 5:
				System.out.print("내용을 수정해주세요 > ");
				String memo = scanner.next();
				list.get(index).setMemo(memo);
				System.out.println(".\n.\n.\n내용이 성공적으로 변경되었습니다.");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
		}
	}
	
	/*
	 *	@DELETE 
	 */
	public void delete() {
		System.out.print("삭제할 데이터의 용도를 입력해주세요 > ");
		String usage = scanner.next();
		
		int index = searchMethod(usage);
		System.out.print("위의 데이터를 삭제하시겠습니까?(Y/N) ");
		String answer = scanner.next();
		if(answer.equalsIgnoreCase("Y")) {
			list.remove(index);
			System.out.println(".\n.\n.\n데이터가 성공적으로 삭제되었습니다.");
		} else if(answer.equalsIgnoreCase("N")) {
			delete();
		} else System.out.println("잘못 입력하셨습니다.");
		
		if(index == -1) {
			System.out.println("해당하는 데이터를 찾을 수 없습니다.");
		}
		
	} // end of delete()
	
} // end of class
