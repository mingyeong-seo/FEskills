//package java_Fund.threadex;
//
//import java.awt.Toolkit;
//
//public class ThreadEx1 {
//	public static void main(String[] args) {
//		// 시스템의 소리를 내도록 하는 API를 사용해 봅니다. 
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		
//		Thread thread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				Toolkit toolkit = Toolkit.getDefaultToolkit();
//				for(int i = 0;i <5;i++) {
//					toolkit.beep();
//				try {
//					Tread.sleep(500);
//				} catch (InterruptedException  e) {
//					e.printStackTrace();
//				}
//				}
//				
//			}
//		});
//	
//	}
//
//}
