package oracle.assignment.generator;

import oracle.assignment.modal.Customer;
import oracle.assignment.utils.CustomerDetailsException;
import oracle.assignment.utils.Validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CustomerDataGenerator {
    public Optional<List<Customer>> generate(String values) {
        var customerDataList = new ArrayList<Customer>();
        List<String> dataList = Arrays.asList(values.split("\n"));

        for (String data : dataList) {
            String[] record = data.split(",");
            try {
                if (Validate.isValid(record)) {
                    var customer = new Customer(record[0], record[1], record[2], record[3], record[4], record[5]);
                    customerDataList.add(customer);
                }
            } catch (CustomerDetailsException ex) {
                // To do
            }
        }
        return Optional.ofNullable(customerDataList);
    }
}
