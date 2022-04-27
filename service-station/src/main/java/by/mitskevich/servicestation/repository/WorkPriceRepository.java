package by.mitskevich.servicestation.repository;

import by.mitskevich.servicestation.entity.WorkPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkPriceRepository extends JpaRepository<WorkPrice,Long> {
}
