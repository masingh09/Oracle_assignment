package oracle.assignment.utils;


public class Validate {
    public static boolean isValid(String[] data) throws CustomerDetailsException {
        return isCustomerIdValid(data[0])
                && isContractIdValid(data[1])
                && isGeoZoneValid(data[2])
                && isTeamCodeValid(data[3])
                && isProjectCodeValid(data[4])
                && isBuildDurationValid(data[5]);
    }
    private static boolean isCustomerIdValid(String customerId) throws CustomerDetailsException {
        if (customerId.trim().isEmpty()
                || customerId.trim().isBlank()
                || !Constants.REG_EX_CUSTOMER_ID.matcher(customerId.trim()).matches()) {
            throw new CustomerDetailsException("CustomerId : " + customerId + " is " + Constants.INVALID_INPUT);
        }
        return true;
    }

    private static boolean isContractIdValid(String contractId) throws CustomerDetailsException {
        if (contractId.trim().isEmpty()
                || contractId.trim().isBlank()
                || !Constants.REG_EX_CONTRACT_ID.matcher(contractId).matches()) {
            throw new CustomerDetailsException("ContractId : " + contractId + " is " + Constants.INVALID_INPUT);
        }
        return true;
    }

    private static boolean isGeoZoneValid(String geoZone) throws CustomerDetailsException {
        if (geoZone.trim().isEmpty()
                || geoZone.trim().isBlank()
                || !Constants.REG_EX_GEOZONE.matcher(geoZone).matches()) {
            throw new CustomerDetailsException("GeoZone : " + geoZone + " is " + Constants.INVALID_INPUT);
        }
        return true;
    }

    private static boolean isTeamCodeValid(String teamCode) throws CustomerDetailsException {
        if (teamCode.trim().isEmpty()
                || teamCode.trim().isBlank()
                || !Constants.REG_EX_CODE.matcher(teamCode).matches()) {
            throw new CustomerDetailsException("TeamCode : " + teamCode + " is " + Constants.INVALID_INPUT);
        }
        return true;
    }

    private static boolean isProjectCodeValid(String project) throws CustomerDetailsException {
        if (project.trim().isEmpty()
                || project.trim().isBlank()
                || !Constants.REG_EX_CODE.matcher(project).matches()) {
            throw new CustomerDetailsException("ProjectCode : " + project + " is " + Constants.INVALID_INPUT);
        }
        return true;
    }

    private static boolean isBuildDurationValid(String duration) throws CustomerDetailsException {
        if (duration.trim().isEmpty()
                || duration.trim().isBlank()
                || !Constants.REG_EX_BUILD_DURATION.matcher(duration).matches()) {
            throw new CustomerDetailsException("BuildDuration : " + duration + " is " + Constants.INVALID_INPUT);
        }
        return true;
    }
}
