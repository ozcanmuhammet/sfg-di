package ozcan.springframework.sfgdi.repository;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {

    @Override
    public String getGreetings(){
        return "Hello World - EN";
    }

}
