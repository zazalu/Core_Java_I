package day11_07;

import java.util.Scanner;

abstract class Employee{
	private String name;
	private int number;
	private MyDate birthday;
	
	
	
	public Employee(String name, int number, MyDate birthday) {
		super();
		this.name = name;
		this.number = number;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}

	public abstract int earnings();

	@Override
	public String toString() {
		return "Employee [name=" + name + ", number=" + number + ", birthday=" + birthday.toDateString() + "]";
	} 
	
	public void setSalary(int m) {
		
	}
	
	
}

class MyDate{
	private int month = 3;
	private int day = 26;
	private int year = 2016;
	
	
	
	public MyDate(int month, int day, int year) {
		super();
		this.month = month;
		this.day = day;
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public String toDateString() {
		String s = new String();
		s = year + "年" + month + "月" + day + "天";
		return s;
	}
}

class SalariedEmployee extends Employee{
	private int monthlySalary;
	
	public SalariedEmployee(String name, int number, MyDate birthday, int monthlySalary) {
		super(name, number, birthday);
		this.monthlySalary = monthlySalary;
	}

	public int earnings() {
		return monthlySalary;
	}
	public void setSalary(int m) {
		this.monthlySalary += m;
	} 
	public String toString() {
		return "SalariedEmployee [name=" + this.getName() + ", number=" + this.getNumber() + ", birthday=" + this.getBirthday() + ", monthlySalary=" + this.earnings() + "]";
	} 
	
	
}

class HourlyEmployee extends Employee{
	private int wage;
	private int hour;
	private int hourlySalary;
	
	public HourlyEmployee(String name, int number, MyDate birthday, int wage, int hour) {
		super(name, number, birthday);
		this.wage = wage;
		this.hour = hour;
	}
	public int earnings() {
		hourlySalary = wage*hour;
		return hourlySalary;
	}
	
	public String toString() {
		return "HourlyEmployee [name=" + this.getName() + ", number=" + this.getNumber() + ", birthday=" + this.getBirthday() + 
				", HourlySalary=" + this.earnings() + "]";
	}

	public void setSalary(int h) {
		this.hourlySalary += h;
	} 
	
}

public class Salary{
	public static void main(String[] args){
	Employee[] e1 = new Employee[5];
	
	e1[0] = new SalariedEmployee("zazalu1",1,new MyDate(11,3,1994),2000);
	e1[1] = new SalariedEmployee("zazalu2",1,new MyDate(12,3,1994),2001);
	e1[2] = new SalariedEmployee("zazalu3",1,new MyDate(1,3,1994),2002);
	e1[3] = new HourlyEmployee("zazalu2",1,new MyDate(9,3,1994),10,19);
	e1[4] = new HourlyEmployee("zazalu2",1,new MyDate(8,3,1994),20,10);
	
	for(int i = 0;i < 5;i++){
		System.out.println(e1[i].toString());
	}
	Scanner s = new Scanner(System.in);
	int s1 = s.nextInt();
	s.close();
	for(int j = 0;j < 5;j++){
		if(e1[j].getBirthday().getMonth() == s1){
			e1[j].setSalary(100);
				
			System.out.println(e1[j].getName() + "你是本月的寿星，给你100元大洋奖励！");
		}
	}
}
	
}







