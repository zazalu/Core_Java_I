package com.zazalu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.Annotation;
import java.util.Iterator;

import org.junit.Test;

public class Testreflection {
	//how to get various part of the methods(如何获取方法的修饰符，返回值类型，注解，方法名，形参列表，异常)
	@Test
	public void test7(){
		Class class1 = Person.class;
		Method[] m1 = class1.getMethods();
		for (Method method : m1) {
			//1.Annotation（注释）
			java.lang.annotation.Annotation[] an1 = method.getAnnotations();
			for (java.lang.annotation.Annotation annotation : an1) {
				System.out.println(annotation);
			}
			//2.Modifiers（修饰符）
			String string = Modifier.toString(method.getModifiers());
			System.out.print(string);
			//3.Return type（返回类型）
			Class c1 = method.getReturnType();
			System.out.println(c1.getName() + " ");
			//4.method name （方法名）
			System.out.print(method.getName() + " ");
			//5.Parameter list（形参）
			System.out.println("(");
			Class[] c2 = method.getParameterTypes();
			for (Class class2 : c2) {
				System.out.print(class2.getName());
			}
			//6.Exception list（异常）
			Class[] c3 = method.getExceptionTypes();
			for (Class class2 : c3) {
				System.out.println(class2.getName());
			}
			System.out.println();
		}
	}
//	//get the runtimeClass's method
	//如何获取运行时类的方法
	@Test
	public void test6(){
		//1.getMethods() can get all the public！ methods from this class and superClass, superInterface
		//getMethods() 可以获取运行时类及其父类中所有的声明为public修饰符的方法
		Class class1 = Person.class;
		Method[] m1 = class1.getMethods();
		for (Method method : m1) {
			System.out.println(method);
		}
		//2.getDeclaredMethods() can get all the declared method only from this class
		//getDeclaredMedthods() 可以获取运行时类的所有定义过的方法，不能获取其父类
		Method[] m2 = class1.getDeclaredMethods();
		for (Method method : m2) {
			System.out.println(method);
		}
		
	}
//	//how to get various part of the filed(如何获取属性的修饰符，类型，和名字)
	@Test
	public void test5(){
		Class class1 = Person.class;
		Field[] f2 = class1.getDeclaredFields();
		for(Field i : f2){
			//1.getModifiers（获取修饰符）
			int mod = i.getModifiers(); //number 1 means public,2 means private, 0 means default
			String str1 = Modifier.toString(mod);//Modifier.toString(number),can change number 1 2 0 to the public,private or default 
			System.out.println(str1);
			//2.getType（获取属性的类型）
			Class type = i.getType();
			System.out.println(type.getName());
			//3.getName（获取属性的方法）
			System.out.println(i.getName());
			System.out.println();
			
		}
		
	}
//	//get the correspond runtimeClass's filed 
	@Test
	public void test4() throws Exception{
		//1.getFields(),can get the accessible public fields into an array(include its  superclass)
		//getFields只能获取运行时类及其父类中的public修饰的属性
		Class class1 = Person.class;
		Field[] f1 = class1.getFields();//Only can get the accessible public field!
		for (int i = 0; i < f1.length; i++) {
			System.out.println(f1[i]);
		}
		System.out.println();
		//2.getDeclaredFields,can get all the fields declared by this! class(include private or default)
		//getDeclaredFields只能获取当前类的所有声明的属性，无视修饰符，但是不能获取其父类的属性
		Field[] f2 = class1.getDeclaredFields();
		for(Field i : f2){
			System.out.println(i);
		}
	}
	@Test
	public void test3() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		String className = "com.zazalu.reflection.Person";
		Class class1 = Class.forName(className);
		//create a runtimeClass object(创建一个运行时类的对象)
		//要想能够创建成功，1.如果你使用newInstance(),要求运行时类要有空参的构造器。2.构造器的权限要是public 或者default（缺省）
		Object o1 = class1.newInstance(); //Actually invoke the Person's Constructor
		Person person = (Person) o1;
		System.out.println(person);
	}
	//get all the constructor 
	//获取所有构造器
	@Test
	public void test8() throws Exception{
		String className = "com.zazalu.reflection.Person";
		Class class1 = Class.forName(className);
		
		Constructor[] c1 = class1.getConstructors();
		for(Constructor c : c1){
			System.out.println(c);
		}
	}
	@Test
	public void test2() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		//How to get the Class's examples
		//1.invoke the method[.class] to get（调用运行时类本身的.class属性，这个class属性是所有类都有的属性）
		Class class1 = Person.class;
		System.out.println(class1.getName());
		//2.by the runtimeClass's Object(通过运行时对象获取）
		Person p1 = new Person("zaza",23);
		Class c1 = p1.getClass();
		//3.by using static method in the Class [Class.forName](通过Class类的一个静态方法获取)
		String className = "com.zazalu.reflection.Person";
		Class class2 = Class.forName(className);
		Field f1 = class2.getField("name");
		f1.setAccessible(true);
		f1.set(p1, "zazalu");
		System.out.println(p1);
		//4.(just know it)by the Class loader (了解)通过类的加载器
		String s1 = "com.zazalu.reflection.Person";
		ClassLoader cl1 = this.getClass().getClassLoader();
		Class class3 = cl1.loadClass(s1);
		
	}
	
	@Test
	public void test1() throws Exception{
		//create a Reflection object
		Person p2 = new Person("zazalu1", 20);
		Class clazz1 = p2.getClass();
		Field fi1 = clazz1.getField("name");
		System.out.println(p2);
		Class<Person> clazz = Person.class;
		Person p1 = clazz.newInstance();
		//invoke Object Person's property ,name(now it is public)
		Field f1 = clazz.getField("name");
		f1.set(p1, "zazalu");
		//invoke Object Person"s property, age(now it is private)
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p1, 23);
		System.out.println(p1); 
		//invoke Object Person's method, show(),display()
		Method m1 = clazz.getMethod("show");
		m1.invoke(p1);
		
		Method m2 = clazz.getMethod("display", String.class);
		m2.invoke(p1, "China");
		
	}
}
