package javaFund.inheri;

public class Duck extends Animal implements Fly {
	public String name;
	public String breed;

	public Duck(String name, String breed) {
		super("duck");
		this.breed = breed;
		this.name = name;
	}

	public String toString() {
		return super.toString() + " 이름은 " + name + " 품종은 " + breed;
	}

	// sound() 오버라이드
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("꽥꽥");

	}

	// 오리가 알을 낳는 기능을 추가한다.
	public void layEggs() {
		System.out.println("오리 알 낳다");

	}

	@Override
	public void fly() {
		System.out.println("오리가 " + BirdVelocity.DUCK_VELOCITY + " 날다");

	}

}
