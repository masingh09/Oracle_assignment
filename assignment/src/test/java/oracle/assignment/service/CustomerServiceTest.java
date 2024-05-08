package oracle.assignment.service;

import oracle.assignment.generator.CustomerDataGenerator;
import oracle.assignment.modal.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerServiceTest {

    final String testData = """
                2343225,2345,us_east,RedTeam,ProjectApple,3445s
                1223456,2345,us_west,BlueTeam,ProjectBanana,2211s
                3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s
                1233456,2345,us_west,BlueTeam,ProjectDate,2221s
                3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s
                """;

    CustomerDataGenerator mockGenerator = mock(CustomerDataGenerator.class);

    @Test
    void shouldGenerateCorrectReport() {
        CustomerService service = new CustomerService();
        when(mockGenerator.generate(anyString())).thenReturn(buildCustomerList());

        String report = service.generateReport(testData);
        Assertions.assertFalse(report.isBlank());
        Assertions.assertFalse(report.isEmpty());
    }

    private Optional<List<Customer>> buildCustomerList() {
        var customers = new ArrayList<Customer>();
        Customer customer = new Customer("234567", "1234", "us_east", "TestTeam", "ProjectTest", "1233s");
        customers.add(customer);
        return Optional.of(customers);
    }
}