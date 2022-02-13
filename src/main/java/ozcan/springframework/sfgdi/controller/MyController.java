package ozcan.springframework.sfgdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ozcan.springframework.sfgdi.service.GreetingService;

@Controller
public class MyController {

    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }


    public String sayHello(){
        System.out.println("Hello World!");

        return "Hi Folks";
    }
}
