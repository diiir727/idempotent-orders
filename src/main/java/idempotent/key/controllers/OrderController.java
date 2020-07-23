package idempotent.key.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import idempotent.key.controllers.request.OrderRequest;
import idempotent.key.controllers.response.NotPayTaskResponse;
import idempotent.key.controllers.response.OrderResponse;
import idempotent.key.domain.OrdersService;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrdersService taskService;

    @Autowired
    public OrderController(OrdersService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(produces = "application/json", path = "/pay")
    public NotPayTaskResponse saveNotPayTask(@RequestBody OrderRequest orderRequest) throws NoSuchAlgorithmException {
        var order = taskService.create(orderRequest.map());
        return NotPayTaskResponse.of(order);
    }

    @GetMapping(produces = "application/json")
    public List<OrderResponse> getAll(@RequestParam int user) {
        return taskService.getAll(user).stream()
                .map(OrderResponse::of)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }

}
