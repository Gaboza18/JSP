package Class_Practice;

public class Car {

	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;

	Car() { // 생성자
	}

	Car(String model) { // 생성자 오버라이딩 1
		this(model, "은색", 250);
	}

	Car(String model, String color) { // 생성자 오버라이딩 2
		this(model, color, 250);
	}

	Car(String model, String color, int maxSpeed) { // 생성자 오버라이딩 3
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
