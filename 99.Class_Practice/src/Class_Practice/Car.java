package Class_Practice;

public class Car {

	String company = "�����ڵ���";
	String model;
	String color;
	int maxSpeed;

	Car() { // ������
	}

	Car(String model) { // ������ �������̵� 1
		this(model, "����", 250);
	}

	Car(String model, String color) { // ������ �������̵� 2
		this(model, color, 250);
	}

	Car(String model, String color, int maxSpeed) { // ������ �������̵� 3
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
