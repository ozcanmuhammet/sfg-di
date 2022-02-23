package ozcan.springframework.sfgdi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import ozcan.springframework.pets.PetService;
import ozcan.springframework.pets.PetServiceFactory;
import ozcan.springframework.sfgdi.datasource.FakeDatasource;
import ozcan.springframework.sfgdi.repository.EnglishGreetingRepository;
import ozcan.springframework.sfgdi.repository.EnglishGreetingRepositoryImpl;
import ozcan.springframework.sfgdi.service.*;

//@PropertySource("classpath:datasource.properties")
@EnableConfigurationProperties(SfgConstructorConfiguration.class)
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {


    @Bean
    FakeDatasource fakeDatasource(SfgConstructorConfiguration sfgConstructorConfiguration){
        FakeDatasource fakeDatasource = new FakeDatasource();
        fakeDatasource.setUserName(sfgConstructorConfiguration.getUserName());
        fakeDatasource.setPassword(sfgConstructorConfiguration.getPassword());
        fakeDatasource.setJdbcUrl(sfgConstructorConfiguration.getJdbcUrl());

        return fakeDatasource;
    }


/*    @Bean
    FakeDatasource fakeDatasource(@Value("${ozcan.username}") String userName,
                                  @Value("${ozcan.password}") String password,
                                  @Value("${ozcan.jdbcurl}") String jdbcUrl){
        FakeDatasource fakeDatasource = new FakeDatasource();
        fakeDatasource.setUserName(userName);
        fakeDatasource.setPassword(password);
        fakeDatasource.setJdbcUrl(jdbcUrl);

        return fakeDatasource;
    }
*/


    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return  petServiceFactory.getPetService("cat");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

/*    @Bean
    ConstructorInjectedGreetingService constructorInjectedGreetingService(){
        return new ConstructorInjectedGreetingService();
    }*/

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }


}
