package postalcode;

/**
 * This class is a subclass of PostalCode used to deal with Ootumlia
 * postal codes.
 */
public class OotumliaPostalCode extends PostalCode {
    // Constructor
    /**
     * Constructs an Ootumlia postal code object.
     *
     * @param code The code to be analysed.
     * @throws PostalCodeException If the code is found to be invalid.
     */
    public OotumliaPostalCode(String code) throws PostalCodeException {
        super(code.trim()); // Normalize input by trimming whitespace
    }

    // Instance methods
    /**
     * Returns the country of origin of the code.
     *
     * @return A String containing the country of origin of the code.
     */
    public String getCountry() {
        return "Ootumlia";
    }

    /**
     * This method will verify the validity of the postal code.
     *
     * @throws PostalCodeException If the code is found to be invalid.
     */
    protected void validate() throws PostalCodeException {
        String postCode = getCode();
        // Check the format of the postal code
        if (!postCode.matches("^[A-Za-z]{1,2} \\d{2}$")) {
            throwException("Invalid postal code format. It should be in the format of 'A 12' or 'AB 34'.");
        }
    }
}
