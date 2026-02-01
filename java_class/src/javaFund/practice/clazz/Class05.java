package javaFund.practice.clazz;

class Account {
    private int balance;

    // 기본 생성자
    public Account() {
        balance = 0;
    }

    // 입금
    public void deposit(int money) {
        balance += money;
    }

    // 잔액 조회
    public int getBalance() {
        return balance;
    }
}

public class Class05 {

	public static void main(String[] args) {
		/*
		 * [Class-05] 접근 제한자
		 *
		 * 목표: - private 필드 - public 메서드
		 *
		 * 요구사항: 1) Account 클래스 정의 - private 필드: balance(int) 2) deposit(int money) 메서드
		 * 3) getBalance() 메서드 4) main에서 입금 후 잔액 출력
		 *
		 * TODO: - 필드 직접 접근 금지
		 */

		Account p1 = new Account();

		p1.deposit(5000);

		System.out.println(p1.getBalance());

	}

}
