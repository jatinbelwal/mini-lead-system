package backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.LeadRequest;
import backend.model.Provider;
import backend.repository.ProviderRepository;
import backend.service.LeadService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/test-tools")
public class TestToolsController {

    private final ProviderRepository providerRepository;

    private final LeadService leadService;

    public TestToolsController(
            ProviderRepository providerRepository,
            LeadService leadService
    ) {

        this.providerRepository = providerRepository;
        this.leadService = leadService;
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

    @PostMapping("/generate-leads")
    public String generateLeads() {

        for (int i = 1; i <= 10; i++) {

            LeadRequest request = new LeadRequest();

            request.setName("Test User " + i);

            request.setPhone("99999999" + i);

            request.setCity("Delhi");

            request.setServiceType("Service 1");

            request.setDescription("Test lead");

            leadService.assignLead(request);
        }

        return "10 test leads generated";
    }
}