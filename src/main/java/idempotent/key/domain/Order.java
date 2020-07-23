package idempotent.key.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Order {

    private int id;
    private PayStatus status;
    private int userId;
    private UUID uuid;
    private BigDecimal sum;

    public Order(PayStatus status, int userId, UUID uuid, BigDecimal sum) {
        this(0, status, userId, uuid, sum);
    }

    public Order(int id, PayStatus status, int userId, UUID uuid, BigDecimal sum) {
        this.id = id;
        this.status = status;
        this.userId = userId;
        this.uuid = uuid;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public PayStatus getStatus() {
        return status;
    }

    public int getUserId() {
        return userId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public BigDecimal getSum() {
        return sum;
    }
}
