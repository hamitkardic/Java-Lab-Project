package postalcode;

/**
 * This class is a subclass of PostalCode used to deal with Canadian
 * postal codes.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2001
 */
public class CanadianPostalCode extends PostalCode
{
    //Constructors ****************************************************

    /**
     * Constructs a Canadian postal code object.
     *
     * @param code The code to be analysed.
     */
    public CanadianPostalCode(String code) throws PostalCodeException
    {
        super(code.toUpperCase().trim()); // Normalize input to uppercase and remove whitespace
    }

    //Instance methods ************************************************

    /**
     * Returns the country of origin of the code.
     *
     * @return A String containing the country of origin of the code.
     */
    public String getCountry()
    {
        return "Canadian";
    }

    /**
     * This method will verify the validity of the postal code.
     *
     * @throws PostalCodeException If the code is found to be invalid.
     */
    protected void validate() throws PostalCodeException
    {
        String postCode = getCode();
        // Check code format, throw an exception if it is invalid.
        if ((postCode.length() == 0)
                || (!Character.isLetter(postCode.charAt(0)))
                || (!Character.isDigit(postCode.charAt(1)))
                || (!Character.isLetter(postCode.charAt(2)))
                || (!Character.isWhitespace(postCode.charAt(3)))
                || (!Character.isDigit(postCode.charAt(4)))
                || (!Character.isLetter(postCode.charAt(5)))
                || (!Character.isDigit(postCode.charAt(6)))
                || (postCode.length() > 7))
        {
            throwException("Sequence of characters not like A9A 9A9");
        }
        else
        {
            setDestination(computeDestination());
        }
    }

    /**
     * This method will return the destination of the postal code.
     *
     * @throws PostalCodeException If the code has an invalid letter
     *                             to indicate a destination.
     */
    private String computeDestination() throws PostalCodeException
    {
        char firstLetter;  // first letter designates the destination

        // If the postal code is valid, get its first letter
        firstLetter = getCode().charAt(0);

        // Determine the area the postal code refers to
        switch (firstLetter)
        {
            case 'A':
                return "in Newfoundland";
            case 'B':
                return "in Nova Scotia";
            case 'C':
                return "in PEI";
            case 'E':
                return "in New Brunswick";
            case 'G':
                return "in Quebec";
            case 'H':
                return "in Metropolitan Montreal";
            case 'J':
                return "in Western Quebec";
            case 'K':
                return "in Eastern Ontario";
            case 'L':
                return "in Central Ontario";
            case 'M':
                return "in Metropolitan Toronto";
            case 'N':
                return "in Southwestern Ontario";
            case 'P':
                return "in Northern Ontario";
            case 'R':
                return "in Manitoba";
            case 'S':
                return "in Saskatchewan";
            case 'T':
                return "in Alberta";
            case 'V':
                return "in British Columbia";
            case 'X':
                return "in the Northwest Territories or Nunavut";
            case 'Y':
                return "in the Yukon Territories";
            default:
                throwException("Invalid first letter");
        }
        return "";
    }
}
