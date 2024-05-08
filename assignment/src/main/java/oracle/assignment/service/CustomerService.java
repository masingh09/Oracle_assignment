package oracle.assignment.service;

import oracle.assignment.modal.Customer;
import oracle.assignment.generator.CustomerDataGenerator;
import oracle.assignment.utils.Constants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class CustomerService {
    public String generateReport(String data) {
        // generate customer data
        final CustomerDataGenerator dataGenerator = new CustomerDataGenerator();
        var customers = dataGenerator.generate(data);

        // generate the report
        String report = Constants.COUNT_UNIQUE_CUSTOMER_PER_CONTRACT + countOfUniqueCustomerIdForContractIds(customers.get()) + Constants.NEW_LINE
                      + Constants.COUNT_UNIQUE_CUSTOMER_PER_GEOZONE + countOfUniqueCustomerIdPerGeo(customers.get()) + Constants.NEW_LINE
                      + Constants.AVG_BUILD_DURATION_PER_GEO + getAvgBuildDurationPerGeo(customers.get()) + Constants.NEW_LINE
                      + Constants.UNIQUE_CUSTOMER_LIST_PER_GEO + getCustomerListPerGeo(customers.get());
        return report;
    }

    private Map<String, Long> countOfUniqueCustomerIdForContractIds(List<Customer> customer) {
        return customer.stream()
                .collect(Collectors.groupingBy(Customer::getContractId, Collectors.counting()));
    }

    private Map<String,Long> countOfUniqueCustomerIdPerGeo(List<Customer> customers) {

        return customers.stream()
                .collect(Collectors.groupingBy(Customer::getZone,Collectors.counting()));
    }

    private Map<String,Double>  getAvgBuildDurationPerGeo(List<Customer> customers){

        return customers.stream()
                .collect(Collectors.groupingBy(Customer::getZone,
                        Collectors.averagingDouble(c -> Double.parseDouble(c.getBuildDuration()))));
    }

    private Map<String,List<String>> getCustomerListPerGeo(List<Customer> customers) {

        return customers.stream()
                .collect(Collectors.groupingBy(Customer::getZone,
                        Collectors.mapping(Customer::getCustomerID,Collectors.toList())));
    }
}
