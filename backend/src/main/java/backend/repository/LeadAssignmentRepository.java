package backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.model.LeadAssignment;

public interface LeadAssignmentRepository extends MongoRepository<LeadAssignment, String> {
}