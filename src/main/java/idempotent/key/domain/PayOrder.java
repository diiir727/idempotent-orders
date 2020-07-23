package idempotent.key.domain;

import javax.xml.bind.DatatypeConverter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PayOrder {
    private String orderUuid;
    private BigDecimal sum;
    private String sign;
    private String secretKey;
    private int scale;

    public PayOrder(Order order, String secretKey) throws NoSuchAlgorithmException {
        this.orderUuid = order.getUuid().toString();
        this.sum = order.getSum();
        this.secretKey = secretKey;
        this.scale = 2;
        this.sign = createSign();
    }

    private String createSign() throws NoSuchAlgorithmException {
        var str = getClearSum() + ":" + secretKey + ":" + orderUuid;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toLowerCase();
    }

    public String getClearSum() {
        return sum.setScale(scale, RoundingMode.UP).toString();
    }

    public String getOrderUuid() {
        return orderUuid;
    }

    public String getSign() {
        return sign;
    }

}
