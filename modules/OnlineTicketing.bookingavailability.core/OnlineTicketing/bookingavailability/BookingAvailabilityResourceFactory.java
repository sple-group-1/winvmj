package OnlineTicketing.bookingavailability;

import OnlineTicketing.bookingavailability.core.BookingAvailabilityResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class BookingAvailabilityResourceFactory{
    private static final Logger LOGGER = Logger.getLogger(BookingAvailabilityFactory.class.getName());

    public BookingAvailabilityResourceFactory()
    {

    }

    public static BookingAvailabilityResource createBookingAvailabilityResource(String fullyQualifiedName, Object ... base)
    {
        BookingAvailabilityResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (BookingAvailabilityResource) constructor.newInstance(base);
        } 
        catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of BookingAvailability.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e)
        {   LOGGER.severe("Failed to create instance of BookingAvailability.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.severe("Failed to create instance of BookingAvailability.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e)
        {
            LOGGER.severe("Failed to create instance of BookingAvailability.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}
