package backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import backend.model.Provider;

public interface ProviderRepository extends MongoRepository<Provider, String> {
}