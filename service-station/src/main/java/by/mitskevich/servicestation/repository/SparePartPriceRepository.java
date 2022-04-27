package by.mitskevich.servicestation.repository;

import by.mitskevich.servicestation.entity.SparePartPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartPriceRepository extends JpaRepository<SparePartPrice,Long> {
}
