package ozcan.springframework.sfgdi.controller;

import org.springframework.stereotype.Controller;
import ozcan.springframework.sfgdi.service.GreetingService;

@Controller
public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
