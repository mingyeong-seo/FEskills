package javaFund.practice.controlflow.priority;

public class Boundary03 {

	public static void main(String[] args) {
		/*
		 * [Priority-03] 택배 배송비
		 *
		 * 입력: - int weight (g 단위) - boolean isJeju (제주 여부)
		 *
		 * 규칙: 1) weight <= 0 이면 "INVALID" 2) 제주면 추가비용 +3000원 (기본 배송비 계산 후 마지막에 더해도 되지만,
		 * "무료배송 예외" 때문에 순서가 중요) 3) 무료배송: - weight <= 2000g 이고, 제주가 아니면 배송비 0원 4) 그 외 기본
		 * 배송비: - 2000g 초과: 2500원
		 *
		 * 출력: - "ship=____"
		 *
		 * TODO: - "제주 추가비"를 무조건 먼저 더하면, 무료배송 케이스가 깨지게 설계됨 - 무료배송/INVALID 같은 특수 케이스를 먼저
		 * 잡아라
		 */

		int weight = 1500;
		boolean isJeju = false;
		int ship;

		if (weight <= 0) {
			System.out.println("INVALID");
			return;
		}

		if (weight <= 2000 && !isJeju) {
			ship = 0;
			System.out.println("ship = " + ship);
			return;
		}

		if (weight > 2000 && !isJeju) {
			ship = 2500;
			System.out.println("ship = " + ship);
		} else if (weight <= 2000 && isJeju) {
			ship = 3000;
			System.out.println("ship = " + ship);
		} else {
			ship = 3000 + 2500;
			System.out.println("ship = " + ship);

		}
	}

}
