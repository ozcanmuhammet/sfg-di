package ozcan.springframework.sfgdi.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ozcan.springframework.sfgdi.service.GreetingService;

@Controller
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    // Can use @Autowire but with constructor it's not necessary
    public ConstructorInjectedController(@Qualifier("constructorInjectedGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }

}
