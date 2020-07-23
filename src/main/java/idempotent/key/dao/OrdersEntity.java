package idempotent.key.dao;

import idempotent.key.domain.PayStatus;
import idempotent.key.domain.Order;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrdersEntity {
    private int id;
    private int status;
    private String uuid;
    private BigDecimal orderSum;
    private Integer userId;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "uuid")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "order_sum")
    public BigDecimal getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(BigDecimal orderSum) {
        this.orderSum = orderSum;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return id == that.id &&
                status == that.status &&
                Objects.equals(uuid, that.uuid) &&
                Objects.equals(orderSum, that.orderSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, uuid, orderSum);
    }

    public Order map() {
        return new Order(id, PayStatus.valueOf(status), userId, UUID.fromString(uuid), orderSum);
    }
}
