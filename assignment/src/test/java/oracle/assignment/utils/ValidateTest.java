package oracle.assignment.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {

    @Test
    void shouldReturnTrueForValidCustomerData() throws Exception{
        String[] testData = {"2343225", "2345","us_east","RedTeam","ProjectApple","3445s"};
        Assertions.assertTrue(Validate.isValid(testData));
    }

    @Test
    void shouldThrowExceptionForInValidCustomerId() throws Exception{
        String[] testData = {"12345678901254", "2345","us_east","RedTeam","ProjectApple","3445s"};
        CustomerDetailsException ex = Assertions.assertThrows(CustomerDetailsException.class, () -> Validate.isValid(testData));
        assertTrue(ex.getMessage().equals("CustomerId : 12345678901254 is " + Constants.INVALID_INPUT));
    }

    @Test
    void shouldThrowExceptionForInValidContractId() throws Exception{
        String[] testData = {"2343225", "12rty","us_east","RedTeam","ProjectApple","3445s"};
        CustomerDetailsException ex = Assertions.assertThrows(CustomerDetailsException.class, () -> Validate.isValid(testData));
        assertTrue(ex.getMessage().equals("ContractId : 12rty is " + Constants.INVALID_INPUT));
    }

    @Test
    void shouldThrowExceptionForInValidGeoZone() throws Exception{
        String[] testData = {"2343225", "2345","usa_eastern","RedTeam","ProjectApple","3445s"};
        CustomerDetailsException ex = Assertions.assertThrows(CustomerDetailsException.class, () -> Validate.isValid(testData));
        assertTrue(ex.getMessage().equals("GeoZone : usa_eastern is " + Constants.INVALID_INPUT));
    }

    @Test
    void shouldThrowExceptionForInValidTeamCode() throws Exception{
        String[] testData = {"2343225", "2345","us_east","Team@#$5","ProjectApple","3445s"};
        CustomerDetailsException ex = Assertions.assertThrows(CustomerDetailsException.class, () -> Validate.isValid(testData));
        assertTrue(ex.getMessage().equals("TeamCode : Team@#$5 is " + Constants.INVALID_INPUT));
    }

    @Test
    void shouldThrowExceptionForInValidProjectCode() throws Exception{
        String[] testData = {"2343225", "2345","us_east","RedTeam","Project@#$","3445s"};
        CustomerDetailsException ex = Assertions.assertThrows(CustomerDetailsException.class, () -> Validate.isValid(testData));
        assertTrue(ex.getMessage().equals("ProjectCode : Project@#$ is " + Constants.INVALID_INPUT));
    }

    @Test
    void shouldThrowExceptionForInValidBuildDuration() throws Exception{
        String[] testData = {"2343225", "2345","us_east","RedTeam","ProjectApple","3445m"};
        CustomerDetailsException ex = Assertions.assertThrows(CustomerDetailsException.class, () -> Validate.isValid(testData));
        System.out.println(ex.getMessage());
        assertTrue(ex.getMessage().equals("BuildDuration : 3445m is " + Constants.INVALID_INPUT));
    }
}