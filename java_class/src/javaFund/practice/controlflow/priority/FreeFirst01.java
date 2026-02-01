package javaFund.practice.controlflow.priority;

public class FreeFirst01 {

	public static void main(String[] args) {
		/*
		 * [Priority-01] 주차 요금 계산
		 *
		 * 입력(테스트 값으로 바꿔가며): - int minutes (주차 시간, 분) - boolean hasTicket (무료권 여부)
		 *
		 * 규칙: 1) minutes <= 0 이면 "INVALID" 2) hasTicket == true 이면 요금 0원 (시간 상관없이 무료)
		 * 3) minutes <= 30 이면 0원 (무료 주차) 4) 그 외: - 기본요금 1000원 + (초과 10분당 500원) - 초과분
		 * 계산은 올림 처리(예: 31분이면 초과 1분 -> 10분 1회로 계산)
		 *
		 * 출력: - "fee=____"
		 *
		 * TODO: - 예외/특수 케이스를 먼저 처리하지 않으면 요금이 틀리게 나오도록 되어있음 - return 또는 else 구조로
		 * "실패/무료"를 먼저 종료/분리해라
		 */

		int minutes = 30;
		boolean hasTicket = false;

		if (minutes <= 0) {
			System.out.println("INVALID");
			return;
		}

		// 2) 최강 예외
		if (hasTicket) {
			System.out.println("fee=0");
			return;
		}

		// 3) 무료 케이스
		if (minutes <= 30) {
			System.out.println("fee=0");
			return;
		}

		// 4) 일반 케이스
		int extraMinutes = minutes - 30;

		int unit = (extraMinutes + 9) / 10;

		int fee = 1000 + unit * 500;

		System.out.println("fee=" + fee);

	}

}
