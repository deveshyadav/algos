# Advanced AOP in Spring: Transactional Aspects, Custom Annotations, and Hybrid AOP-ControllerAdvice

## 📌 1. Introduction

Spring provides **advanced AOP features** such as:
- **Transactional aspects** using `@Transactional`.
- **Custom Annotations** to define reusable AOP behaviors.
- **Combining AOP with `@ControllerAdvice`** for a hybrid approach.

This guide explains **how to implement these concepts** with detailed **code examples**.

---

## 📌 2. Implementing Transactional Aspects Using `@Transactional`

### 2.1 What is `@Transactional`?
- `@Transactional` ensures **atomicity** of database operations.
- It **rolls back** transactions in case of **failures**.
- It can be applied at the **class level** (all methods) or **method level**.

### 2.2 Adding Spring Transaction Dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

### 2.3 Service Layer with `@Transactional`

```java
package com.example.service;

import com.example.repository.OrderRepository;
import com.example.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void placeOrder(Order order) {
        orderRepository.save(order);
        System.out.println("Order placed successfully!");
        // Simulating an error to cache rollback
        if (order.getProduct().equals("error")) {
            throw new RuntimeException("Error occurred, rolling back transaction!");
        }
    }
}
```

### 2.4 Testing Transaction Rollback

```java
package com.example;

import com.example.service.OrderService;
import com.example.model.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionalAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionalAopApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ApplicationContext context) {
        return args -> {
            OrderService orderService = context.getBean(OrderService.class);
            try {
                orderService.placeOrder(new Order("Laptop")); // Success
                orderService.placeOrder(new Order("error"));  // Triggers rollback
            } catch (Exception e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
        };
    }
    //We can use this property to check logs. It will show the rollback is happening
    //logging.level.org.springframework.transaction=DEBUG
}
```

---

## 📌 3. Exploring Custom Annotations for AOP

### 3.1 Why Use Custom Annotations?
- Allows defining reusable **AOP behaviors** with **annotations**.
- Keeps the **service layer clean** by abstracting concerns.

### 3.2 Creating a Custom Annotation

```java
package com.example.aspect;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {
}
```

### 3.3 Creating an Aspect for the Custom Annotation

```java
package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Around("@annotation(com.example.aspect.LogExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        
        Object result = joinPoint.proceed(); // Execute target method fetchProductDetails()
        
        long end = System.currentTimeMillis();
        System.out.println("Execution time of " + joinPoint.getSignature() + ": " + (end - start) + " ms");
        
        return result;
    }
}
```

### 3.4 Applying Custom Annotation in Service

```java
package com.example.service;

import com.example.aspect.LogExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @LogExecutionTime
    public String fetchProductDetails(String productId) {
        // Simulate processing time
        try { Thread.sleep(1000); } catch (InterruptedException e) { }
        return "Product details for " + productId;
    }
}
```

### 3.5 Testing Custom Annotation

```java
package com.example;

import com.example.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomAopApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ApplicationContext context) {
        return args -> {
            ProductService productService = context.getBean(ProductService.class);
            System.out.println(productService.fetchProductDetails("P123"));
        };
    }
}
```

**Expected Output:**
```
Execution time of fetchProductDetails: 1001 ms
Product details for P123
```

---

## 📌 4. Combining Spring AOP and `@ControllerAdvice` for a Hybrid Approach

### 4.1 Why Combine AOP and `@ControllerAdvice`?
- **AOP handles cross-cutting concerns** (logging, performance tracking).
- **`@ControllerAdvice` handles exceptions globally**.
- A hybrid approach **improves modularity and reusability**.

### 4.2 Creating Global Exception Handler with Logging

```java
package com.example.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Aspect
@RestControllerAdvice
public class GlobalExceptionHandlerAspect {

    @AfterThrowing(pointcut = "execution(* com.example.controller.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        System.out.println("Exception in method: " + joinPoint.getSignature().getName());
        System.out.println("Exception Message: " + ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBadRequest(IllegalArgumentException ex) {
        return "{ "error": "" + ex.getMessage() + "" }";
    }
}
```

### 4.3 Sample Controller to Trigger Hybrid Approach

```java
package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/{id}")
    public String getOrder(@PathVariable String id) {
        if (id.equals("0")) {
            throw new IllegalArgumentException("Order ID cannot be zero!");
        }
        return "Order details for ID: " + id;
    }
}
```

### 4.4 Expected Output for `/order/0`

```
Exception in method: getOrder
Exception Message: Order ID cannot be zero!
```

**JSON Response:**
```json
{
  "error": "Order ID cannot be zero!"
}
```

### 4.5 Weaving Happens Here
Spring AOP dynamically creates a proxy object of OrderService, injecting the aspect into it.

So instead of directly calling:

```java
OrderService orderService = new OrderService();
```

Spring creates a proxy object like this:

```java
OrderService orderService = (OrderService) Proxy.newProxyInstance(...);
```

Now, when placeOrder() is called:

1. Spring intercepts the call.
2. The LoggingAspect executes @Before advice.
3. The actual placeOrder() method executes.
4. The LoggingAspect executes @After advice.

---

## 📌 5. Summary

| Feature | Spring AOP | `@Transactional` | Custom Annotations | Hybrid AOP + ControllerAdvice |
|---------|------------|-----------------|-------------------|-------------------------------|
| **Purpose** | Handles cross-cutting concerns | Ensures atomic DB transactions | Enables reusable behavior | Global exception handling + AOP |
| **Annotations** | `@Before`, `@After`, `@Around` | `@Transactional` | Custom annotation (`@LogExecutionTime`) | `@RestControllerAdvice`, `@ExceptionHandler` |
| **Use Case** | Logging, Security, Performance | Ensures data consistency | Logging, Validation, Metrics | Logs + Exception handling in controllers |

---

## 📌 6. Conclusion

- **Spring AOP** is ideal for handling cross-cutting concerns like **logging, security, and performance monitoring**.
- **Transactional Aspects** ensure **database consistency** with `@Transactional`.
- **Custom Annotations** allow defining **reusable AOP behaviors**.
- **Hybrid AOP and `@ControllerAdvice`** enables **powerful exception handling and logging**.

---

## 📌 7. Next Steps
- Implement **Security Aspects** for role-based access control.
- Explore **Caching with AOP**.
- Use **Spring Events for advanced monitoring**.
