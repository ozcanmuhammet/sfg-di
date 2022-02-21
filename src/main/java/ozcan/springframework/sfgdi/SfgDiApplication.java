package ozcan.springframework.sfgdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ozcan.springframework.sfgdi.controller.*;
import ozcan.springframework.sfgdi.service.PrototypeBean;
import ozcan.springframework.sfgdi.service.SingletonBean;

//@ComponentScan(basePackages = {"ozcan.springframework.pets", "ozcan.springframework.sfgdi"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SfgDiApplication.class, args);
		MyController myController = (MyController) context.getBean("myController");

		String greetings = myController.sayHello();
		System.out.println(greetings);

		System.out.println("------------ Primary Bean");

		System.out.println(myController.getGreeting());

		System.out.println("------------ Property Injection");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) context.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("------------ Setter Injection");

		SetterInjectedController setterInjectedController = (SetterInjectedController) context.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("------------ Constructor Injection");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) context.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("--------------------------");
		System.out.println("------------ Using Profile");
		I18nController i18nController = (I18nController) context.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		PetController petController = context.getBean("petController", PetController.class);
		System.out.println(petController.whichPetIsTheBest());

		System.out.println("-------------Bean Scope-------------------");

		SingletonBean singletonBean1 = context.getBean("singletonBean", SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = context.getBean("singletonBean", SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = context.getBean("prototypeBean", PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = context.getBean("prototypeBean", PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

	}

}
