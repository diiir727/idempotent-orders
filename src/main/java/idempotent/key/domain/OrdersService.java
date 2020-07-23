package idempotent.key.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@Transactional
public class OrdersService {

    private String secretWord;
    private OrdersDao ordersDao;


    @Autowired
    public OrdersService(OrdersDao ordersDao, @Value("${secret.word}") String secretWord) {
        this.ordersDao = ordersDao;
        this.secretWord = secretWord;
    }

    public List<Order> getAll(int userId) {
        return ordersDao.getAll(userId);
    }

    public PayOrder create(Bucket bucket) throws NoSuchAlgorithmException {
        Order order;
        var oldOrder = ordersDao.get(bucket.getIdempotentKey().toString());
        if (oldOrder.isPresent()) {
            order = oldOrder.get();
        } else {
            order = new Order(PayStatus.CREATE, bucket.getUserId(), bucket.getIdempotentKey(), getCost(bucket));
            ordersDao.create(order);
            //todo также тут создаются задания
        }

        return new PayOrder(order, secretWord);
    }

    private BigDecimal getCost(Bucket bucket) {
        return BigDecimal.valueOf(25.5 * bucket.getCount());
    }


}
