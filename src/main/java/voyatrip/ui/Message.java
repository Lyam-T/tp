package voyatrip.ui;

/**
 * This class store all the user interface messages that will be displayed to the user.
 */
public class Message {
    // user message
    static final String WELCOME_MESSAGE = "Welcome to VoyaTrip! How can I help you today?";
    static final String GOODBYE_MESSAGE = "Goodbye! Wish you have a lovely trip!";
    static final String ADD_TRIP_MESSAGE = "The following trip has been added to your list! ";
    static final String ADD_ACTIVITY_MESSAGE = "The following activity has been added to your list! ";
    static final String ADD_ACCOMMODATION_MESSAGE = "The following accommodation has been added to your list! ";
    static final String ADD_TRANSPORTATION_MESSAGE = "The following transportation has been added to your list! ";
    static final String DELETE_TRIP_MESSAGE = "The following trip has been deleted from your list! ";
    static final String DELETE_ACCOMMODATION_MESSAGE = "The following accommodation has been deleted from your list! ";
    static final String DELETE_ALL_ACCOMMODATIONS_MESSAGE = "All accommodations have been deleted.";
    static final String DELETE_TRANSPORTATION_MESSAGE = "The following transportation has been deleted from" +
            " your list! ";
    static final String MODIFY_TRANSPORTATION_MESSAGE = "The following transportation has been modified!";
    static final String MODIFY_ACCOMMODATION_MESSAGE = "The following accommodation has been modified to: ";
    static final String LIST_ACCOMMODATION_MESSAGE = "Here is the accommodation: ";
    static final String LIST_TRANSPORTATION_MESSAGE = "Here is the transportation: ";
    static final String DELETE_ACTIVITY_MESSAGE = "The following activity has been deleted from your list! ";
    static final String NEXT_COMMAND_MESSAGE = "What would you like to do next? ";
    static final String EMPTY_TRIP_LIST_MESSAGE = "There is no trip in your list. Please add a trip first.";

    // Trip Modification
    static final String MODIFY_TRIP_MESSAGE = "The following trip has been modified to: ";
    static final String INVALID_MODIFICATION_DATES_MESSAGE = "Invalid modification dates. Please try again.";
    static final String SAME_TRIP_NAME_MESSAGE = "The trip name is the same as the original trip name.";
    static final String SAME_TRIP_START_DATE_MESSAGE =
            "The trip start date is the same as the original trip start date.";
    static final String SAME_TRIP_END_DATE_MESSAGE =
            "The trip end date is the same as the original trip end date.";
    static final String SAME_TRIP_NUM_DAYS_MESSAGE =
            "The trip number of days is the same as the original trip number of days.";
    static final String SAME_TRIP_BUDGET_MESSAGE = "The trip budget is the same as the original trip budget.";
    static final String SAME_TRIP_MESSAGE = "The trip is the same as the original trip.";


    // budget
    static final String EXCEED_TOTAL_BUDGET_BY_MESSAGE = "Please checkout your total budget."
            + "It seems like you have exceeded your total budget by: ";
    static final String BUDGET_PER_DAY_MESSAGE = "The budget for each day is: ";
    static final String BUDGET_PER_TRANSPORTATION_MESSAGE = "The budget for each transportation is: ";
    static final String BUDGET_PER_ACCOMMODATION_MESSAGE = "The budget for each accommodation is: ";

    // list
    static final String LIST_ALL_TRANSPORTATIONS_MESSAGE = "Here are all the transportations under your trip: ";
    static final String LIST_ALL_ACCOMMODATIONS_MESSAGE = "Here are all the accommodations under your trip: ";

    // exception
    static final String ACCOMMODATION_NOT_FOUND_MESSAGE = "Accommodation not found. Please try again.";
    static final String ACTIVITY_NOT_FOUND_MESSAGE = "Activity not found. Please try again.";
    static final String DUPLICATED_NAME_MESSAGE = "Duplicate name. Please try again.";
    static final String INVALID_ARGUMENT_KEYWORD_MESSAGE = "Invalid argument keyword. Please try again.";
    static final String INVALID_ARGUMENT_VALUE_MESSAGE = "Invalid argument value. Please try again.";
    static final String INVALID_BUDGET_MESSAGE = "Invalid budget. Please try again.";
    static final String INVALID_COMMAND_MESSAGE = "Invalid command. Please try again.";
    static final String INVALID_COMMAND_ACTION_MESSAGE = "Invalid command action. Please try again.";
    static final String INVALID_COMMAND_TARGET_MESSAGE = "Invalid command target. Please try again.";
    static final String INVALID_DATE_MESSAGE = "Invalid date. Please try again.";
    static final String INVALID_DAY_MESSAGE = "Invalid day. Please try again.";
    static final String INVALID_INDEX_MESSAGE = "Invalid index. Please try again.";
    static final String INVALID_NAME_MESSAGE = "Invalid name. Please try again.";
    static final String INVALID_NUMBER_FORMAT_MESSAGE = "Invalid number format. Please try again.";
    static final String MISSING_ARGUMENT_MESSAGE = "Missing argument. Please try again.";
    static final String MISSING_COMMAND_KEYWORD_MESSAGE = "Missing command keyword. Please try again.";
    static final String TRANSPORTATION_NOT_FOUND_MESSAGE = "Transportation not found. Please try again.";
    static final String TRIP_NOT_FOUND_MESSAGE = "Trip not found. Please try again.";
    static final String INVALID_TIME_FORMAT_MESSAGE = "Invalid time format. Please try again.";
    static final String INVALID_DUPLICATE_ACTIVITY = "The activity already exists. Pleas try again.";
    static final String EXTRA_ARGUMENT_MESSAFE = "Extra argument. Please try again.";

    // Getters
    public static String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public static String getGoodbyeMessage() {
        return GOODBYE_MESSAGE;
    }

    public static String getInvalidCommandMessage() {
        return INVALID_COMMAND_MESSAGE;
    }
}
