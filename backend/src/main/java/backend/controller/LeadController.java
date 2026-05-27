package backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.LeadRequest;
import backend.service.LeadService;

@RestController
@RequestMapping("/api/leads") 
// Restrict CORS to trusted origins instead of allowing all origins
@CrossOrigin(origins = "http://localhost:3000")
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping
    public String createLead(@RequestBody LeadRequest request) {

        return leadService.assignLead(request);
    }
}