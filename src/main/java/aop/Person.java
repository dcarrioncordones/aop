package aop;

public class Person {

	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Name: " + name;
	}
	
	public void throwException() throws Exception {
		throw new Exception("Exception in person");
	}

}
