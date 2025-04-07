// This file contains material supporting section 2.8 of the textbook:
// "Object-Oriented Software Engineering" and is issued under the open-source license

package postalcode;

/**
 * This class is a subclass of PostalCode used to handle and verify
 * US ZIP codes.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2001
 */
public class USZipCode extends PostalCode
{
    //Constructors ****************************************************

    /**
     * Constructs a ZIP Code type object.  Calls the superclass
     * constructor.
     *
     * @param code The postal code to be analysed.
     */
    public USZipCode(String code) throws PostalCodeException
    {
        super(code);
    }


    //Instance methods ************************************************

    /**
     * This method returns the country of origin of this code.
     *
     * @return A String containing the country of origin of the code.
     */
    public String getCountry()
    {
        return "American";
    }

    /**
     * This method validates the postal code.
     *
     * @throws PostalCodeException If the code is invalid.
     */
    protected void validate() throws PostalCodeException
    {
        String postCode = getCode();
        switch(postCode.length())
        {
            // If the code is 5 or 10 characters long
            case 5:
            case 10:
                for (int i = 0; i < postCode.length(); i++) //Check chars
                {
                    if (((i == 5) && (postCode.charAt(i) != '-'))
                            || ((i != 5) && (!(Character.isDigit(postCode.charAt(i))))))
                    {
                        // Checks both 5 and 10 characters
                        // If all the characters except the 6th are not numbers
                        // If the 6th character (in 10 characters) is not a dash
                        throwException("Invalid character in code.");
                        break;
                    }
                }
                break;

            default:
                //Any other case, the code is invalid.
                throwException("Invalid code length.");
        }

        setDestination(computeDestination());
    }

    /**
     * This method will return a String indicating the location of the
     * destination address.  10 character codes have destinations in major
     * cities, while 5 character codes have destination in minor cities.
     *
     * @return A String indicating the size of the city where the destination
     *         is located.
     */
    private String computeDestination()
    {
        if (getCode().length() == 10)
            return "in a major US city.";
        else
            return "in a small US city.";
    }
}

