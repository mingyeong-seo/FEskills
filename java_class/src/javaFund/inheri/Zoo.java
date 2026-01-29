package inheri;

public class Zoo {

	public static void main(String[] args) {
		// Animal animal = new Animal("동물");
		// System.out.println("이것은 " + animal.type);

		Animal dog = new Dog("두부", "비숑");
		System.out.println(dog);

		Animal cat = new Cat("냥이", "길고양이");
		System.out.println(cat);

		Animal duck = new Duck("덕덕", "외국 오리");
		System.out.println(duck);

		dog.sound();
		cat.sound();
		duck.sound();

		// 다형성: 상속 관계에서 instance를 발생 시, super 타입으로 하위 instance를 생성하는 형태를 알림
		// 이렇게하면, 타입은 super로 해당 인스턴스의 외형은 자식으로, 내부에는 부모 인스턴스가 생성이 되어진다.
		// 호출되는 메서드나 필드는 강의했던 대로, 제일 먼저 걸리는 애들이 호출된다.

		Animal[] animals = { dog, cat, duck };
		for (Animal animal : animals) {
			System.out.println(animal);
			animal.sound();
		}

		((Duck) duck).layEggs();

		for (int i = 0; i < animals.length; i++) {
			Animal ani = animals[(int) (Math.random() * animals.length)]; // 랜덤한 동물이 선택되도록 정의함
			System.out.println(ani);
			ani.sound();

			if (ani instanceof Duck) {
				((Duck) ani).layEggs();
				((Duck) ani).fly();
			}

		}

		Fly fly = new Duck("", "");

		// final : 고정의 의미를 담고 있음
		// 클래스앞에 선언되면 상속금지, 메서드 앞에 선언되면 오버라이드 금지, 변수앞에 선언되면 값 변경 금지, static final로 선언되면
		// 상수로 표현되는 의미로 사용된다

		Object eagle1 = new Eagle("독수리");
		Animal eagle2 = new Eagle("독수리");
		Eagle eagle3 = new Eagle("독수리");
		Fly eagle4 = new Eagle("독수리");
		BirdVelocity eagle5 = new Eagle("독수리");

		// 익명 구현 객체: 이름이 없는 객체를 말함..
		// 일반적으로 사용하는 이유는 특정 추상 or 인터페이스의 하위 객체를 한번만 만들어서 사용하고 버릴때임
		// 이름 그대로, 이름이 없는 객체로 모든 추상 메서드를 오버라이드를 필요에 따라서 오버라이드하면서 사용한다.

		BirdInter bi = new BirdInter() {

			@Override
			public void fly() {

			}
		};

	}

}
