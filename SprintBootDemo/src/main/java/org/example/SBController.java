package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/demo") // Base path
public class SBController {

    @GetMapping("/orders/exception/{id}")
    public ResponseEntity<String> getOrdersException(
            @PathVariable Integer id) {
        if(id==123){
            throw new ResourceNotFoundException("This id data is not present");
        }
        return ResponseEntity.ok("Orders for id: "+id);
    }

    // 1️⃣ SIMPLE GET (no params)
    // ✅ URL: GET /api/demo/hello
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    // 2️⃣ PATH VARIABLE (single)
    // ✅ URL: GET /api/demo/user/101
    // If path variable name in path is different than the parameter to be mapped in method,
    // explicitly provide name like -> @PathVariable("id") Long userId
    @GetMapping("/user/{id}")
    public ResponseEntity<String> getUserById(@PathVariable("id") Long userId) {
        return ResponseEntity.ok("User ID: " + userId);
    }

    // 3️⃣ MULTIPLE PATH VARIABLES (same variable names)
    // ✅ URL: GET /api/demo/order/55/item/7
    @GetMapping("/order/{orderId}/item/{itemId}")
    public ResponseEntity<String> getOrderItem(
            @PathVariable Long orderId,
            @PathVariable Integer itemId) {
        return ResponseEntity.ok("Order " + orderId + ", Item " + itemId);
    }

    // ✅ URL: GET /api/demo/order/55/item/7 (different variable names in method)
    @GetMapping("/order/{oId}/item/{iId}")
    public String getOrderItemWithDiffVarNames(
            @PathVariable("oId") Long orderId,
            @PathVariable("iId") Integer itemId) {
        return "Order: " + orderId + ", Item: " + itemId;
    }

    // 4️⃣ OPTIONAL PATH VARIABLE
    // ✅ URL: GET /api/demo/greet
    // ✅ URL: GET /api/demo/greet/John
    @GetMapping({"/greet", "/greet/{name}"})
    public String greet(@PathVariable(required = false) String name) {
        return "Hello " + (name != null ? name : "Guest");
    }

    // 5️⃣ PATH VARIABLE WITH REGEX (only numeric allowed)
    // ✅ URL: GET /api/demo/product/12345
    // ❌ URL: /api/demo/product/abc → 404
    @GetMapping("/product/{code:\\d+}")
    public String getProductByCode(@PathVariable String code) {
        return "Product code: " + code;
    }

    // 6️⃣ QUERY PARAMS (required + optional + renamed)
    // ✅ URL: GET /api/demo/search?keyword=laptop&q=electronics
    // ✅ URL: GET /api/demo/search?keyword=mobile&limit=5&q=phones
    @GetMapping("/search")
    public String search(
            @RequestParam String keyword,                       // required by default
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(name = "q") String qparam) {
        return "Searching for: " + keyword + " with limit: " + limit + " Qparam: " + qparam;
    }

    // 7️⃣ MULTIPLE QUERY PARAMS AS MAP
    // ✅ URL: GET /api/demo/filter?brand=apple&price=1000&color=black
    @GetMapping("/filter")
    public Map<String, String> filter(@RequestParam Map<String, String> params) {
        return params; // returns all query params as JSON
    }

    // 8️⃣ POST with REQUEST BODY
    // ✅ URL: POST /api/demo/user
    // ✅ BODY: {"name":"Alice","age":25}
    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return ResponseEntity.ok("Created user: " + user.getName() + ", age: " + user.getAge());
    }

    // 9️⃣ PUT with PATH + BODY
    // ✅ URL: PUT /api/demo/user/101
    // ✅ BODY: {"name":"Bob","age":30}
    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(
            @PathVariable Long id,
            @RequestBody User user) {
        return ResponseEntity.ok("Updated user " + id + " to: " + user.getName());
    }

    // 🔟 DELETE with PATH VARIABLE
    // ✅ URL: DELETE /api/demo/user/101
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok("Deleted user with ID: " + id);
    }

    // 1️⃣1️⃣ MIX: PATH + QUERY PARAMS + LIST
    // ✅ URL: GET /api/demo/orders/active?sortBy=price&sortBy=date
    @GetMapping("/orders/{status}")
    public ResponseEntity<String> getOrders(
            @PathVariable String status,
            @RequestParam List<String> sortBy) {
        return ResponseEntity.ok("Orders with status: " + status + " sorted by: " + sortBy);
    }
}

// Simple DTO for POST/PUT
class User {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

