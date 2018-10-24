package app.exam.domain.entities;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "order_items")
@Check(constraints = "quantity > 0")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Item.class)
    private Item item;

    @ManyToOne(targetEntity = Order.class, cascade = CascadeType.ALL)
    private Order order;

    @Column(nullable = false)
    private Integer quantity;

    public OrderItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
