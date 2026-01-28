package javaFund.lecture;

/*
 * 자바 클래스: 클래스란 실제 어플리케이션이 수행할 때 사용되는 객체의 설계도이다.
 * 이 설계도에 우리가 목적하는 업무를 정의하고, 이를 객체화시켜서 수행하도록 하는데 목적이 있다.
 * 
 * 때문에 객체 지향에서는 클래스의 설계가 무척 중요한데, 클래스의 구조에 대해 먼저 알아보자.
 * 
 * 클래스는 크게 3형식의 구조로 되어있다
 * 
 * 1. 필드: 멤머 필드라고도 하며, 객체의 상태를 나타내는 변수이다.
 * 이 말은, 이 필드를 가지고 있는 객체의 상태가 어떤 것인지를 이 변수의 값에 따라서 확인할 수 있다는 뜻이다.
 * 이 필드는 클래스로부터 객체가 생성될 때 객체에 복사되어 들어가고, 초기 설정값을 지정하지 않으면 타입의 기본값으로 초기화된다.
 * 
 *  2. 생성자(constructor): 생성자는 메서드의 일종인데, 메서드와는 하는 일이 다르다.
 *  이 생성자가 하는 주 역할은, 클래스를 바탕으로 실제 객체를 생성하는 역할을 하고, 필요에 따라서
 *  객체 초기화 즉, 필드 초기화 역할을 한다. 목적에 따라서는 초기화 메서드를 호출하는 역할도 한다.
 *  
 *  (생성자 없으면 클래스x 꼭 있어야 한다.생성자는 객체를 만든다. 생성자는 클래스명과 같아야 하고,return 사용 x, )
 *  
 *  3. 메서드(method): 클래스 또는 객체가 수행할 행위를 이 메서드를 통해서 정의한다. 
 *  객체와의 유기적인 작업은 이 메서드를 이용해서 주로 하며(필요에 따라서는 필드를 통합), 필요에 따라서
 *  getter, setter를 통해 필드의 값을 get/set 하기도 한다. 
 */

// 우리반 학생들의 객체를 생성해서, 정보를 출력하는 클래스를 정의할 예정입니다.
// 즉, 정의된 클래스를 바탕으로 실제 학생 객체를 몇개 생성할 예정이란 뜻이다. 
// 클래스를 정의시, 이러한 객체들이 공통적으로 가지고 있는 공통 속성을 필드로 추출하는 작업부터한다. 

class FullStackStudent {
	/*
	 * 접근 제어자(Access Modifier): private(가장 좁음) / default / protected / public(가장 넓음)
	 * 이 중 클래스에는 default와 public만 사용할 수 있고,
	 * 필드, 생성자, 메서드에는 위 중 하나를 선언해서 클래스 내·외부에서 접근하는 것을 제어 할 수 있다.
	 * 
	 * 이중 가장 강력한 접근 제어는 private으로 오직 자신 클래스에서만 접근 가능하다.
	 * 이를 사용하는 가장 큰 목적은 선언된 구문의 접근을 오직 자신에게만 국한되게 할 때 사용된다.
	 * 외부에서 접근시엔 컴파일 에러를 유발한다. 이렇게 하는 것을 캡슐화라고 한다.
	 */
	private String name; // 객체가 가지고 잇는 필드들이다~해서 멤버필드
	private int age;
	private char grade;

	public FullStackStudent() {
		this.name = null;
		this.age = 0;
		this.grade = ' ';
	}

	public FullStackStudent(String name) {
		this();
		this.name = name;
	}

	public FullStackStudent(String name, int age) {
		this(name);
		this.age = age;
	}

	public FullStackStudent(String name, int age, char grade) {
		this(name, age);
		this.grade = grade;
	}

	public String getName() {
		return this.name;
	}

	public String getName(String id) {
		return this.name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class classExam {
	private double r1;
	private double r2;

	public classExam(double r1, double r2) {
		this.r1 = r1;
		this.r2 = r2;
	}

	// 면적을 구하도록 하는 메서드를 정의한다.
	public double getArea() {
		return r1 * r2 * InitExam.getPI();
	}

	public static void main(String[] args) {
		FullStackStudent hj = new FullStackStudent();
		FullStackStudent me = new FullStackStudent("민경");
		System.out.println(me.getName());
		System.out.println(hj.getName());
	}
}
