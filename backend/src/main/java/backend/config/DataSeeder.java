package backend.config;

import backend.model.Provider;
import backend.repository.ProviderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedData(ProviderRepository providerRepository) {

        return args -> {

            if (providerRepository.count() == 0) {

                for (int i = 1; i <= 8; i++) {

                    Provider provider = new Provider();

                    provider.setName("Provider " + i);
                    provider.setMonthlyQuota(10);
                    provider.setUsedQuota(0);

                    providerRepository.save(provider);
                }

                System.out.println("Providers inserted successfully");
            }
        };
    }
}