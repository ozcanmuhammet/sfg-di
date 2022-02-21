package ozcan.springframework.sfgdi.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {

    public PrototypeBean(){
        System.out.println("Creating Prototype bean...");
    }

    public String getMyScope(){
        return "I'm a prototype bean...";
    }
}
