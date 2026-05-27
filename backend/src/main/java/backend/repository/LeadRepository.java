package backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.model.Lead;

public interface LeadRepository extends MongoRepository<Lead, String> {
}