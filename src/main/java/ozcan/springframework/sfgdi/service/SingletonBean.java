package ozcan.springframework.sfgdi.service;


import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean(){
        System.out.println("Creating Singleton bean...");
    }

    public String getMyScope(){
        return "I'm a singleton bean...";
    }
}
