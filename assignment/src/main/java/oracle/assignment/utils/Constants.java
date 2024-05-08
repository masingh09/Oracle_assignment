package oracle.assignment.utils;

import java.util.regex.Pattern;

public class Constants {

    // Constants for the report
    public static String COUNT_UNIQUE_CUSTOMER_PER_CONTRACT = "The number of unique customerId for each contractId : ";
    public static String COUNT_UNIQUE_CUSTOMER_PER_GEOZONE = "The number of unique customerId for each geozone : ";
    public static String AVG_BUILD_DURATION_PER_GEO = "The average buildduration for each geozone : ";
    public static String UNIQUE_CUSTOMER_LIST_PER_GEO = "The list of unique customerId for each geozone : ";
    public static String NEW_LINE = "\n";

    // Regular expressions to validate input data

    public static Pattern REG_EX_CONTRACT_ID = Pattern.compile("^\\d{4}$");
    public static Pattern REG_EX_CUSTOMER_ID = Pattern.compile("^\\d{7}$");
    public static Pattern REG_EX_GEOZONE = Pattern.compile("^[a-z]{2}_[a-z]{4,5}");
    public static Pattern REG_EX_CODE = Pattern.compile("^[A-Za-z0-9]{1,20}");
    public static Pattern REG_EX_BUILD_DURATION = Pattern.compile("^\\d+s");

    public static final String INVALID_INPUT = "Invalid Input";

}
