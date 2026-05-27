package backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.model.Provider;
import backend.repository.ProviderRepository;

@RestController
@RequestMapping("/test-tools")
public class TestToolsController {

    private final ProviderRepository providerRepository;

    public TestToolsController(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @PostMapping("/reset-quotas")
    public String resetQuotas() {

        List<Provider> providers = providerRepository.findAll();

        for (Provider provider : providers) {

            provider.setUsedQuota(0);

            providerRepository.save(provider);
        }

        return "All provider quotas reset";
    }
}