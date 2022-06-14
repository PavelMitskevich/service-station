package by.mitskevich.servicestation.repository;

import by.mitskevich.servicestation.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder,Long> {

    List<WorkOrder> findWorkOrdersByCarId(Long id);

    List<WorkOrder> findWorkOrdersByCarUser_IdIsContaining(Long id);
}
