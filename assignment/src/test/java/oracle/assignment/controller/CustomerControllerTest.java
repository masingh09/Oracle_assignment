package oracle.assignment.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CustomerControllerTest {

    @Test
    public void shouldReturnSuccessResponseForValidRequest() {
        final CustomerController customerController = new CustomerController();
        String testData = "2343225,2345,us_east,RedTeam,ProjectApple,3445s";
        assertThat(customerController.processCustomerData(testData).getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void shouldReturnFailedResponseForEmptyRequest() {
        final CustomerController customerController = new CustomerController();
        assertThat(customerController.processCustomerData(null).getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}