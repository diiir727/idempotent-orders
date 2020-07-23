package idempotent.key.controllers.response;

import idempotent.key.domain.PayOrder;

public class NotPayTaskResponse {

    private String orderUuid;
    private String sum;
    private String sign;

    public static NotPayTaskResponse of(PayOrder order) {
        var resp = new NotPayTaskResponse();
        resp.setOrderUuid(order.getOrderUuid());
        resp.setSum(order.getClearSum());
        resp.setSign(order.getSign());
        return resp;
    }

    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
