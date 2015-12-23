package aop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import aop.paquete.Clase;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class Application {
	Clase c;
	@Bean
	public Person person() {
		return new Person("Dan Jose Carrion");
	}
	@Bean
	public Resource getResource() throws MalformedURLException {
		return new UrlResource("http://google.com.do");
	}
	
	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		URL url = context.getBean(Resource.class).getURL();
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		
		String content;
		while ((content = br.readLine()) != null) {
			System.out.println(content);
		}
		
		br.close();
		
		PersonService ps = context.getBean(PersonService.class);
		ps.printPerson(ps.getPerson());
		ps.throwException();
		context.close();
	}

}
