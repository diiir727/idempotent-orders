package idempotent.key.domain;

import java.util.UUID;

public class Bucket {

    private Integer count;
    private Integer serviceId;
    private int userId;
    private String link;
    private UUID idempotentKey;

    public Bucket(Integer count, Integer serviceId, int userId, String link, UUID idempotentKey) {
        this.count = count;
        this.serviceId = serviceId;
        this.userId = userId;
        this.link = link;
        this.idempotentKey = idempotentKey;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public int getUserId() {
        return userId;
    }

    public String getLink() {
        return link;
    }

    public UUID getIdempotentKey() {
        return idempotentKey;
    }
}
