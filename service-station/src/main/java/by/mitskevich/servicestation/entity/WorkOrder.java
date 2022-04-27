package by.mitskevich.servicestation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "work_orders", schema = "car_service_station")
public class WorkOrder implements Serializable {
    @Serial
    private static final long serialVersionUID = 991146532083986514L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @Column(name = "start_time")
    private LocalDate startTime;
    @Column(name = "end_time")
    private LocalDate endTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id")
    private Worker worker;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "total_price", joinColumns = @JoinColumn(name = "work_order_id"),
            inverseJoinColumns = @JoinColumn(name = "work_price_id"))
    private List<WorkPrice> workPrices;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "total_price", joinColumns = @JoinColumn(name = "work_order_id"),
            inverseJoinColumns = @JoinColumn(name = "spare_part_price_id"))
    private List<SparePartPrice> sparePartPrices;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkOrder workOrder = (WorkOrder) o;

        if (id != workOrder.id) return false;
        if (!Objects.equals(startTime, workOrder.startTime)) return false;
        return Objects.equals(endTime, workOrder.endTime);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WorkOrder{");
        sb.append("id=").append(id);
        sb.append(", car=").append(car);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", worker=").append(worker);
        sb.append('}');
        return sb.toString();
    }
}
