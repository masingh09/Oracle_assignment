package oracle.assignment.controller;

import oracle.assignment.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @PostMapping(value="/report", consumes = MediaType.TEXT_PLAIN_VALUE , produces= MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> processCustomerData(@RequestBody String data) {
        if (data != null && !data.trim().isEmpty() && !data.trim().isBlank()) {
            final CustomerService customerService = new CustomerService();
            String report = customerService.generateReport(data);
            return  ResponseEntity.ok(report);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
