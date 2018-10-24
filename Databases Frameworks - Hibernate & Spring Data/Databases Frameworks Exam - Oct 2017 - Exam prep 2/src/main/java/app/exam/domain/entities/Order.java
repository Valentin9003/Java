package app.exam.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String customer;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false, columnDefinition = "varchar(50) default 'ForHere'")
    @Enumerated(EnumType.STRING)
    private OrderType type;

    @ManyToOne(targetEntity = Employee.class)
    private Employee employee;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @Transient
    private BigDecimal totalPrice;

    public Order() {
        this.orderItems = new ArrayList<>();
    }

    public Order(String customer, Date date, OrderType type) {
        this.customer = customer;
        this.date = date;
        this.type = type;
        this.orderItems = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public BigDecimal getTotalPrice() {
        this.totalPrice = BigDecimal.ZERO;
        for (OrderItem orderItem : this.orderItems) {
            BigDecimal quantity = BigDecimal.valueOf(orderItem.getQuantity());
            BigDecimal itemPrice = orderItem.getItem().getPrice();
            this.totalPrice = this.totalPrice.add(itemPrice.multiply(quantity));
        }
        return this.totalPrice;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
