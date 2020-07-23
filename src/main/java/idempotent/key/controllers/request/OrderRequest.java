package idempotent.key.controllers.request;

import idempotent.key.domain.Bucket;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public class OrderRequest {

    private int serviceId;
    private int userId;
    @Min(1)
    private int quantity;
    @NotEmpty
    private String link;
    private String uuid;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Bucket map() {
        return new Bucket(quantity, serviceId, userId, link, UUID.fromString(uuid));
    }

}
