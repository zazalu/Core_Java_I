package com.zazalu.reflection;

@MyAnnotation(value = "biehzaozheda") 
public class Person extends Creature<String> implements Comparable,Myinterface{
	public String name;
	private int age;
	
	public Person() {
		super();
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@MyAnnotation(value = "abc123")
	public void show(){
		System.out.println(name + " " + age);
	}
	
	private void display(String nation) throws Exception{
		System.out.println("My nation is " + nation);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	class Bird{
		
	}
	
	
	
	
}
