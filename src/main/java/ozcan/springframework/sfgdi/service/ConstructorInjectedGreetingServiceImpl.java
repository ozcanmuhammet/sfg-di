package ozcan.springframework.sfgdi.service;

import org.springframework.stereotype.Service;

@Service
public class ConstructorInjectedGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - Constructor injected";
    }
}
