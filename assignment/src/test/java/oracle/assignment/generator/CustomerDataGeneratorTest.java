package oracle.assignment.generator;

import oracle.assignment.modal.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDataGeneratorTest {

    @Test
    void shouldGenerateValidCustomer() {
        String testData = "2343225,2345,us_east,RedTeam,ProjectApple,3445s";
        CustomerDataGenerator dataGenerator = new CustomerDataGenerator();
        Optional<List<Customer>> data = dataGenerator.generate(testData);

        assertFalse(data.isEmpty());
        assertEquals(1, data.get().size());
        assertEquals("2343225", data.get().get(0).getCustomerID());
        assertEquals("2345", data.get().get(0).getContractId());
        assertEquals("us_east", data.get().get(0).getZone());
        assertEquals("RedTeam", data.get().get(0).getTeamCode());
        assertEquals("ProjectApple", data.get().get(0).getProjectCode());
        assertEquals("3445", data.get().get(0).getBuildDuration());
    }

    @Test
    void shouldGenerateValidCustomersFromMultipleRecords() {
        String testData = """
                2343225,2345,us_east,RedTeam,ProjectApple,3445s
                1223456,2345,us_west,BlueTeam,ProjectBanana,2211s
                3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s
                1233456,2345,us_west,BlueTeam,ProjectDate,2221s
                3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s
                """;
        CustomerDataGenerator dataGenerator = new CustomerDataGenerator();
        Optional<List<Customer>> data = dataGenerator.generate(testData);

        assertFalse(data.isEmpty());
        assertEquals(5, data.get().size());
    }

}