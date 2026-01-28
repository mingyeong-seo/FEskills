package javaFund.lecture;

import javax.swing.JOptionPane;

//1. 가위바위보 입력 과정(사용자 입력 -> 조건 확인 -> userVal에 저장 or 조건 맞을때까지 재입력)
//2. 사용자 승 체크(컴퓨터 랜덤값 -> 사용자와 컴퓨터 값 비교 -> 판단)
//3. 출력 
class Gbb {

	private int userVal;
	private int comVal;
	private int win;
	private int draw;
	private int lose;
	private int total;

	// 생성자
	public Gbb() {
		this.userVal = 0;
		this.comVal = 0;
		this.win = 0;
		this.draw = 0;
		this.lose = 0;
		this.total = 0;
	}

	// 사용자에게 값 받기
	public void inputSomething() {
		boolean isInputOk = false;

		while (!isInputOk) {
			String input = JOptionPane.showInputDialog("가위(1), 바위(2), 보(3)");

			try {
				userVal = Integer.parseInt(input);
			} catch (Exception e) {
				switch (input) {
				case "가위":
					userVal = 1;
					break;
				case "바위":
					userVal = 2;
					break;
				case "보":
					userVal = 3;
					break;
				default:
					userVal = 0;
				}
			}

			if (userVal >= 1 && userVal <= 3) {
				isInputOk = true;
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 다시 입력하세요.");
			}
		}
	}

	// 승패 판단
	public void isWin() {
		comVal = (int) (Math.random() * 3 + 1);

		if (comVal == userVal) {
			draw++;
		} else if ((comVal == 1 && userVal == 2) || (comVal == 2 && userVal == 3) || (comVal == 3 && userVal == 1)) {
			win++;
		} else {
			lose++;
		}
		total++;
	}

	// 결과
	public int getWin() {
		return win;
	}

	public int getDraw() {
		return draw;
	}

	public int getLose() {
		return lose;
	}

	public int getComVal() {
		return comVal;
	}

	public int getUserVal() {
		return userVal;
	}
}

public class GawibawiboVer2 {
	public static void main(String[] args) {

		Gbb game = new Gbb();

		JOptionPane.showMessageDialog(null, "가위바위보 게임 시작");

		game.inputSomething(); // 1. 입력
		game.isWin(); // 2. 승패 판단

		// 3. 출력하기
		System.out.println("사용자: " + game.getUserVal());
		System.out.println("컴퓨터: " + game.getComVal());
		System.out.println("승: " + game.getWin());
		System.out.println("무: " + game.getDraw());
		System.out.println("패: " + game.getLose());
	}
}
