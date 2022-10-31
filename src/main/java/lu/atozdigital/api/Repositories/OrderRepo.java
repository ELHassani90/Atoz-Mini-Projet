package lu.atozdigital.api.Repositories;

import lu.atozdigital.api.Entities.Ordr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Ordr,Long> {
}
