package idempotent.key.domain;

import java.util.List;
import java.util.Optional;

public interface OrdersDao {
    Order create(Order order);
    Optional<Order> get(String uuid);
    List<Order> getAll(int userId);
    void update(Order order);
}
