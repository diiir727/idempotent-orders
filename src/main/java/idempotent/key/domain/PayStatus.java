package idempotent.key.domain;

public enum PayStatus {
    CREATE(1),
    CANCEL(2),
    APPROVE(90);

    private int id;

    PayStatus(int id) {
        this.id = id;
    }

    public static PayStatus valueOf(int status) {
        for (PayStatus val: values()){
            if (val.id == status)
                return val;
        }
        throw new IllegalArgumentException("invalid pay type: " + status);
    }

    public int getId() {
        return id;
    }
}
