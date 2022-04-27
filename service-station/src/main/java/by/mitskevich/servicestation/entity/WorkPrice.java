package by.mitskevich.station.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "work_price", schema = "car_service_station")
public class WorkPrice implements Serializable {
    @Serial
    private static final long serialVersionUID = -8722012032330901328L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "discount")
    private double discount;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "total_price", joinColumns = @JoinColumn(name = "work_price_id"),
            inverseJoinColumns = @JoinColumn(name = "work_order_id"))
    private List<WorkOrder> workOrders;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "total_price", joinColumns = @JoinColumn(name = "work_price_id"),
            inverseJoinColumns = @JoinColumn(name = "spare_part_price_id"))
    private List<SparePartPrice> sparePartPrices;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkPrice workPrice = (WorkPrice) o;

        if (id != workPrice.id) return false;
        if (Double.compare(workPrice.price, price) != 0) return false;
        if (Double.compare(workPrice.discount, discount) != 0) return false;
        return name.equals(workPrice.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + name.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WorkPrice{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price='").append(price).append('\'');
        sb.append(", discount='").append(discount).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
