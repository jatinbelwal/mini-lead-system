package backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import backend.dto.LeadRequest;
import backend.model.Lead;
import backend.model.LeadAssignment;
import backend.model.Provider;
import backend.repository.LeadAssignmentRepository;
import backend.repository.LeadRepository;
import backend.repository.ProviderRepository;

@Service
public class LeadService {

    private final LeadRepository leadRepository;

    private final ProviderRepository providerRepository;

    private final LeadAssignmentRepository assignmentRepository;

    public LeadService(
            LeadRepository leadRepository,
            ProviderRepository providerRepository,
            LeadAssignmentRepository assignmentRepository
    ) {
        this.leadRepository = leadRepository;
        this.providerRepository = providerRepository;
        this.assignmentRepository = assignmentRepository;
    }

    public String assignLead(LeadRequest request) {

        Lead lead = new Lead();

        lead.setName(request.getName());
        lead.setPhone(request.getPhone());
        lead.setCity(request.getCity());
        lead.setServiceType(request.getServiceType());
        lead.setDescription(request.getDescription());

        leadRepository.save(lead);

        List<Provider> selectedProviders = new ArrayList<>();

        List<Provider> allProviders = providerRepository.findAll();

        switch (request.getServiceType()) {
            case "Service 1" -> {
                addProviderByName("Provider 1", allProviders, selectedProviders);
                addFairProviders(
                        List.of("Provider 2", "Provider 3", "Provider 4"),
                        allProviders,
                        selectedProviders
                );
            }
            case "Service 2" -> {
                addProviderByName("Provider 5", allProviders, selectedProviders);
                addFairProviders(
                        List.of("Provider 6", "Provider 7", "Provider 8"),
                        allProviders,
                        selectedProviders
                );
            }
            case "Service 3" -> {
                addProviderByName("Provider 1", allProviders, selectedProviders);
                addProviderByName("Provider 4", allProviders, selectedProviders);
                addFairProviders(
                        List.of(
                                "Provider 2",
                                "Provider 3",
                                "Provider 5",
                                "Provider 6",
                                "Provider 7",
                                "Provider 8"
                        ),
                        allProviders,
                        selectedProviders
                );
            }
            default -> {
                // No providers assigned for unknown service type
            }
        }

        // SAVE ASSIGNMENTS
        for (Provider provider : selectedProviders) {

            provider.setUsedQuota(provider.getUsedQuota() + 1);

            providerRepository.save(provider);

            LeadAssignment assignment = new LeadAssignment();

            assignment.setLeadId(lead.getId());

            assignment.setProviderName(provider.getName());

            assignmentRepository.save(assignment);
        }

        return "Lead assigned to " + selectedProviders.size() + " providers";
    }

    private void addProviderByName(
            String providerName,
            List<Provider> allProviders,
            List<Provider> selectedProviders
    ) {

        for (Provider provider : allProviders) {

            if (
                    provider.getName().equals(providerName)
                            && provider.getUsedQuota() < provider.getMonthlyQuota()
            ) {

                selectedProviders.add(provider);

                return;
            }
        }
    }

    private void addFairProviders(
            List<String> pool,
            List<Provider> allProviders,
            List<Provider> selectedProviders
    ) {

        for (Provider provider : allProviders) {

            if (
                    pool.contains(provider.getName())
                            && provider.getUsedQuota() < provider.getMonthlyQuota()
                            && selectedProviders.size() < 3
            ) {

                selectedProviders.add(provider);
            }
        }
    }
}