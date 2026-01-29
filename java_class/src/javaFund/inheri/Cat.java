package inheri;

public class Cat extends Animal {
	public String name;
	public String breed;

	public Cat(String name, String breed) {
		super("cat");
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
		System.out.println("야옹");

	}
}
