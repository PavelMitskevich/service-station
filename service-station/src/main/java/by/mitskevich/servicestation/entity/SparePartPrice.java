package by.mitskevich.servicestation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "spare_part_price", schema = "car_service_station")
public class SparePartPrice implements Serializable {

    @Serial
    private static final long serialVersionUID = 851777120105557999L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "vendor_code")
    private String vendorCode;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "discount")
    private double discount;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "total_price", joinColumns = @JoinColumn(name = "spare_part_price_id"),
            inverseJoinColumns = @JoinColumn(name = "work_order_id"))
    private List<WorkOrder> workOrders;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "total_price", joinColumns = @JoinColumn(name = "spare_part_price_id"),
            inverseJoinColumns = @JoinColumn(name = "work_price_id"))
    private List<WorkPrice> workPrices;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SparePartPrice that = (SparePartPrice) o;

        if (id != that.id) return false;
        if (Double.compare(that.discount, discount) != 0) return false;
        if (!Objects.equals(brand, that.brand)) return false;
        if (!Objects.equals(vendorCode, that.vendorCode)) return false;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (vendorCode != null ? vendorCode.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SparePartPrice{");
        sb.append("id=").append(id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", vendorCode='").append(vendorCode).append('\'');
        sb.append(", price=").append(price);
        sb.append(", discount=").append(discount);
        sb.append('}');
        return sb.toString();
    }
}
