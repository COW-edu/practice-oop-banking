package Banking;
import java.math.BigDecimal;
import java.util.Scanner;

import Account.AccountType;

public class BankingApplication {
	public static void main(String[] args) {
		BankingApplication banking = new BankingApplication();
		banking.run();
	}
	
	private CentralBank centralBank;
	public BankingApplication() {
		this.centralBank = CentralBank.getInstance();
	}
	private String getMenuString() {
		return 	  "[선택 메뉴]\n"
				+ "1. 계좌 생성\n"
				+ "2. 출금\n"
				+ "3. 입금\n"
				+ "4. 송금\n"
				+ "5. 계좌 정보 확인\n"
				+ "6. 이자 확인\n"
				+ "7. 계좌 삭제\n"
				+ "8. 종료";
	}
	public void run() {
		Scanner scanner = new Scanner(System.in);
		boolean isRunning = true;
		int selectedMenu;
		while(isRunning) {
			selectedMenu = getInputInt(getMenuString(), scanner);
			switch(selectedMenu) {
			case 1:
				addAccount(scanner);
				break;
			case 2:
				withdrawal(scanner);
				break;
			case 3:
				deposit(scanner);
				break;
			case 4:
				remittance(scanner);
				break;
			case 5:
				getAccountInfo(scanner);
				break;
			case 6:
				getInterest(scanner);
				break;
			case 7:
				deleteAccount(scanner);
				break;
			case 8:
				System.out.println("시스템을 종료합니다.");
				isRunning = false;
				break;
			default :
				System.out.println("잘못된 입력값입니다. 다시 입력해주세요.");
				break;
			}
		}
		scanner.close();
	}
	/**
	 * 사용자로부터 문자열을 입력받는 메소드
	 * @param printMsg 출력하려는 문장
	 * @param scanner 입력받을 Scanner
	 * @return 입력받은 문장
	 */
	private String getInputString(String printMsg, Scanner scanner) {
		System.out.println(printMsg);
		String input = scanner.next();
		return input;
	}
	/**
	 * 사용자로부터 정수를 입력받는 메소드
	 * @param printMsg 출력하려는 문장
	 * @param scanner 입력받을 Scanner
	 * @return 입력받은 문장
	 */
	private int getInputInt(String printMsg, Scanner scanner) {
		System.out.println(printMsg);
		boolean validData = false;
		int inputInt = 0;
		do {
			try {
				String input = scanner.next();
				inputInt = Integer.parseInt(input);
				if(inputInt < 0) System.out.println("0보다 큰 숫자를 입력해주세요.");
				else validData = true;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			}
		} while(!validData);
		return inputInt;
	}
	/**
	 * 계좌 번호를 입력받는 함수
	 * @param addPrintMsg 앞에 추가하려는 메시지
	 * @param scanner 입력받으려는 Scanner
	 * @return 존재하지 않는 계좌번호라면 null, 존재한다면 계좌 번호를 반환한다.
	 */
	private String getAccountNumber(String addPrintMsg, Scanner scanner) {
		String accountNumber = getInputString(addPrintMsg + "계좌 번호를 입력해주세요.", scanner);
		if(!this.centralBank.checkAccountNumber(accountNumber)) {
			System.out.println("존재하지 않는 계좌 번호입니다.");
			return null;
		}
		return accountNumber;
	}
	/*
	 * 계좌 생성
	 */
	private void addAccount(Scanner scanner) {
		AccountType accountType = null;
		boolean validData = false;
		int inputInt;
		do {
			inputInt = getInputInt("생성하려는 계좌 종류를 입력해주세요\n1. 일반 예금 계좌\n2. 적금 계좌\n3. 계좌 생성 취소", scanner);
			switch(inputInt) {
			case 1:
				accountType = AccountType.NORMAL_ACCOUNT;
				validData = true;
				break;
			case 2:
				accountType = AccountType.SAVING_ACCOUNT;
				validData = true;
				break;
			case 3:
				System.out.println("계좌 생성을 취소합니다.");
				return;
			default:
				System.out.println("잘못된 입력값입니다. 다시 입력해주세요.");
				break;
			}
		} while(!validData);
		validData = false;
		String owner = getInputString("생성하려는 계좌주의 이름을 입력해주세요", scanner);
		String accountNumber = null;
		switch(accountType) {
		case NORMAL_ACCOUNT:
			accountNumber = centralBank.makeAccount(accountType, owner);
			break;
		case SAVING_ACCOUNT:
			inputInt = getInputInt("목표 금액을 입력해주세요.", scanner);
			BigDecimal targetAmount = new BigDecimal(inputInt);
			accountNumber = centralBank.makeAccount(accountType, owner, targetAmount);
			break;
		default:
			break;
		}
		if(accountNumber != null)
			System.out.println("성공적으로 생성되었습니다.\n"+centralBank.getAccountInfo(accountNumber));
		else
			System.out.println("계정 생성에 실패하였습니다");
	}
	/*
	 * 출금
	 */
	private void withdrawal(Scanner scanner) {
		String accountNumber = getAccountNumber("출금할 ", scanner);
		if(accountNumber == null) return;
		int inputInt = getInputInt("출금할 금액을 입력해주세요.", scanner);
		BigDecimal withdrawalAmount = new BigDecimal(inputInt);
		if(centralBank.withdrawal(accountNumber, withdrawalAmount))
			System.out.println("출금에 성공하셨습니다.");
		else
			System.out.println("출금에 실패하였습니다.");
		System.out.println(centralBank.getAccountInfo(accountNumber));
	}
	/*
	 * 입금
	 */
	private void deposit(Scanner scanner) {
		String accountNumber = getAccountNumber("입금할 ", scanner);
		if(accountNumber == null) return;
		int inputInt = getInputInt("입금할 금액을 입력해주세요.", scanner);
		BigDecimal depositAmount = new BigDecimal(inputInt);
		centralBank.deposit(accountNumber, depositAmount);
		System.out.println("입금에 성공하셨습니다.");
		System.out.println(centralBank.getAccountInfo(accountNumber));
	}
	/*
	 * 송금
	 */
	private void remittance(Scanner scanner) {
		String withdrawalAccountNumber = getAccountNumber("출금할 ", scanner);
		if(withdrawalAccountNumber == null) return;
		String depositAccountNumber = getAccountNumber("입금할 ", scanner);
		if(depositAccountNumber == null) return;

		int inputInt = getInputInt("송금할 금액을 입력해주세요.", scanner);
		BigDecimal remittanceAmount = new BigDecimal(inputInt);
		if(!centralBank.withdrawal(withdrawalAccountNumber, remittanceAmount)) {
			System.out.println("송금에 실패하였습니다.");
			return;
		}
		centralBank.deposit(depositAccountNumber, remittanceAmount);
		System.out.println("송금에 성공하셨습니다.");
	}
	/*
	 * 계좌 정보 확인
	 */
	private void getAccountInfo(Scanner scanner) {
		String accountNumber = getAccountNumber("정보를 확인할 ", scanner);
		if(accountNumber == null) return;
		System.out.println(centralBank.getAccountInfo(accountNumber));
	}
	/*
	 * 이자 확인
	 */
	private void getInterest(Scanner scanner) {
		String accountNumber = getAccountNumber("이자를 확인할 ", scanner);
		if(accountNumber == null) return;
		System.out.println("￦" + centralBank.getInterest(accountNumber));
	}
	/*
	 * 계좌 삭제
	 */
	private void deleteAccount(Scanner scanner) {
		String accountNumber = getAccountNumber("삭제하려는 ", scanner);
		if(accountNumber == null) return;
		boolean result = centralBank.deleteAccount(accountNumber);
		if(result)
			System.out.println("삭제에 성공하였습니다.");
		else
			System.out.println("삭제에 실패하였습니다.");
	}
}
