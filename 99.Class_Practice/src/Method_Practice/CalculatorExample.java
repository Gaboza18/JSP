package Method_Practice;

public class CalculatorExample {

	public static void main(String[] args) {

		Calculator myCal = new Calculator();

		myCal.powerOn();

		int result = myCal.plus(2, 4);
		System.out.println("Calculator의 plus 메소드 결과:" + result);

		double result2 = myCal.divide(6, 3);
		System.out.println("Calculator의 divide 메소드 결과:" + result2);

		byte x = 12;
		byte y = 6;

		double result3 = myCal.divide(x, y);
		System.out.println(result3);
	}
}
