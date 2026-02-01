package javaFund.practice.controlflow.priority;

public class Combo05 {
	public static void main(String[] args) {
		/*
		 * [Priority-05] 영화관 티켓 가격
		 *
		 * 입력: - int age - boolean isMorning (조조 여부) - boolean hasCoupon (쿠폰 여부)
		 *
		 * 기본요금: 12000원
		 *
		 * 규칙(우선순위가 핵심): 1) age <= 0 이면 "INVALID" 2) 쿠폰(hasCoupon) 있으면 무조건 5000원 (조조/나이
		 * 할인 무시) 3) 쿠폰이 없으면: - age <= 12 : 50% 할인 - age >= 65 : 40% 할인 - 그 외 할인 없음 4)
		 * 그리고 마지막으로 조조(isMorning)가 true면 최종금액에서 2000원 추가 할인 단, 최종 금액은 최소 0원 (음수면 0원)
		 *
		 * 출력: - "ticket=____"
		 *
		 * TODO: - 쿠폰을 먼저 처리하지 않으면 항상 꼬이게 설계됨 - 조조 할인은 "마지막"에만 적용해야 함 (중간에 적용하면 틀릴 수 있음)
		 */
		int age = 13;
		boolean isMorning = true;
		boolean hasCoupon = false;
		int ticket = 12000;

		if (age <= 0) {
			System.out.println("INVALID");
			return;
		}

		if (hasCoupon) {
			ticket = 5000;
			System.out.println("ticket=" + ticket);
			return;
		} else {
			if (age <= 12) {
				System.out.println("ticket=" + ticket * 50 / 100);
			} else if (age >= 65) {
				System.out.println("ticket=" + ticket * 60 / 100);
			}

		}

		if (isMorning) {
            ticket -= 2000;
            if (ticket < 0) ticket = 0;
        }
		
		
        System.out.println("ticket=" + ticket);


	}

}
