package ozcan.springframework.sfgdi.service;

import org.springframework.stereotype.Service;

public class SetterInjectedGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World - Setter injected";
    }
}
