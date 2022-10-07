package de.neuefische.backend.respository;

import de.neuefische.backend.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepo extends MongoRepository <Movie,String> {

}
