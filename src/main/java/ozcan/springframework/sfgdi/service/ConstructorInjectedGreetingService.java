package ozcan.springframework.sfgdi.service;

import org.springframework.stereotype.Service;

public class ConstructorInjectedGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - Constructor injected";
    }
}
