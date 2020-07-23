package idempotent.key.controllers.response;

import idempotent.key.domain.Order;

import java.math.BigDecimal;

public class OrderResponse {
    private int id;
    private String uuid;
    private BigDecimal sum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public static OrderResponse of(Order order) {
        var resp = new OrderResponse();
        resp.setId(order.getId());
        resp.setSum(order.getSum());
        resp.setUuid(order.getUuid().toString());
        return resp;
    }
}
