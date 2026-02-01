package javaFund.practice.controlflow.priority;

public class LeapLike02 {

	public static void main(String[] args) {
		 /*
         * [Priority-02] 이벤트 적용 우선순위
         *
         * 입력:
         * - int price (결제 금액)
         * - boolean isVip (VIP 여부)
         * - boolean isFirstPurchase (첫 구매 여부)
         *
         * 규칙(우선순위가 핵심):
         * 1) price <= 0 이면 "INVALID"
         * 2) isVip == true 이면 무조건 30% 할인 (다른 할인 무시)
         * 3) VIP가 아니면:
         *    - 첫 구매면 20% 할인
         *    - 첫 구매 아니면 할인 없음
         *
         * 출력:
         * - "pay=____" (정수로 출력, 퍼센트는 정수 계산)
         *
         * TODO:
         * - isFirstPurchase를 먼저 처리하면 VIP 규칙이 깨진다
         * - "예외(=VIP)가 일반 규칙(첫구매)보다 먼저" 오게 만들어라
         */
		
		int price = 1000;
		boolean isVip = false;
		boolean isFirstPurchase = false;
		
		if (price <= 0) {
			System.out.println("INVALID"); 
			return;
		}
		if (isVip) {
			int pay = price * 70/100;
			 System.out.println("pay=" + pay);
	            return;
		}
		
		if (isFirstPurchase) {
			int pay = price * 80 / 100;
			System.out.println("pay = "+price);
		} else {
			 System.out.println("pay=" + price);
        }
		

	}

}
