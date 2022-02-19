package ozcan.springframework.sfgdi.service;

import ozcan.springframework.sfgdi.repository.EnglishGreetingRepository;

public class I18nEnglishGreetingService implements GreetingService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return englishGreetingRepository.getGreetings();
    }
}
