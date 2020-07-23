package idempotent.key.dao;

import idempotent.key.domain.OrdersDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import idempotent.key.domain.Order;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrdersDaoImpl implements OrdersDao {

    private SessionFactory sessionFactory;

    @Autowired
    public OrdersDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Order create(Order order) {
        var entity = new OrdersEntity();
        entity.setOrderSum(order.getSum());
        entity.setStatus(order.getStatus().getId());
        entity.setUuid(order.getUuid().toString());
        entity.setUserId(order.getUserId());

        this.sessionFactory.getCurrentSession()
                .save(entity);
        return entity.map();
    }

    @Override
    public Optional<Order> get(String uuid) {
        var entity = this.sessionFactory.getCurrentSession()
                .createQuery("from OrdersEntity where uuid=:uuid", OrdersEntity.class)
                .setParameter("uuid", uuid)
                .uniqueResultOptional();
        return entity.map(OrdersEntity::map);
    }

    @Override
    public List<Order> getAll(int userId) {
        return this.sessionFactory.getCurrentSession()
                .createQuery("FROM OrdersEntity where userId=:userId", OrdersEntity.class)
                .setParameter("userId", userId)
                .getResultList()
                .stream()
                .map(OrdersEntity::map)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Order order) {
        var entity = this.sessionFactory.getCurrentSession().find(OrdersEntity.class, order.getId());
        entity.setStatus(order.getStatus().getId());
        this.sessionFactory.getCurrentSession()
                .update(entity);
    }

}
