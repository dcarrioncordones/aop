package aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonService {
	
	private Person person;
	
	@Autowired
	public PersonService(Person person) {
		this.person = person;
	}
	
	public Person getPerson() {
		return person;
	}

	public void printPerson(Person person) {
		System.out.println(person);
	}
	
	public void throwException() {
		try {
			person.throwException();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
