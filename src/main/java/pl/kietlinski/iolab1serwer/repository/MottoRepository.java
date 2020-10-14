package pl.kietlinski.iolab1serwer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.kietlinski.iolab1serwer.entity.Motto;

import java.util.List;

@Repository
public interface MottoRepository extends MongoRepository<Motto, String> {

    @Override
    List<Motto> findAll();
}
