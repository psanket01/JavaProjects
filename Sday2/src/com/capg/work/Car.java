package com.capg.work;

public class Car {
//	String name = "Ford";
//	int speed = 180;
//	
//	public static void main(String[] args) {
//		Car c1 = new Car();
//		Car c2 = new Car();
//		c1.name ="BMW";
//		c1.speed = 200;
//		
//		System.out.println(c1.name +" " + c1.speed);
//		System.out.println(c2.name +" " + c2.speed);
//	}
	
	
	
//	public void method() {
//		System.out.println("Method is working without using static");
//	}
//	
//	public static void main(String[] args) {
//		
//		Car c  = new Car();
//		c.method();
//	}
	
	
	
//	public static void method() {
//		System.out.println("Method is working, using static");
//	}
//	
//	public static void main(String[] args) {
//		method();
//	}
	
//	String s;
//	public Car() {
//		s = "Class Constructor";
//	}
//	
//	
//	public static void main(String[] args) {
//		Car c = new Car();
//		System.out.println(c.s);
//	}
	
	
	int x;
	public Car(int x) {
		this.x = x;
	}
	
	public static void main(String[] args) {
		Car c = new Car(15);
		System.out.println(c.x);
	}
	

}
