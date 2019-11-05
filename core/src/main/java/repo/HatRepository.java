package repo;

import domain.Hat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HatRepository extends JpaRepository<Hat, Integer> {

}
