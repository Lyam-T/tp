package voyatrip.command;

import java.util.ArrayList;

import voyatrip.command.exceptions.InvalidCommand;
import voyatrip.command.types.AccommodationCommand;
import voyatrip.command.types.CommandAction;
import voyatrip.command.types.CommandTarget;
import voyatrip.command.types.ExitCommand;
import voyatrip.command.types.ItineraryCommand;
import voyatrip.command.types.Command;
import voyatrip.command.types.TransportationCommand;
import voyatrip.command.types.TripsCommand;

public class Parser {
    private CommandTarget currentTarget;
    private String currentTrip;

    public Parser() {
        currentTarget = CommandTarget.TRIP;
        currentTrip = "";
    }

    /**
     * Set the current target page the user is in.
     *
     * @param target The current target page the user is in.
     */
    public void setCurrentTarget(CommandTarget target) {
        currentTarget = target;
    }

    /**
     * Set the current trip the user is in.
     *
     * @param trip The current trip the user is in.
     */
    public void setCurrentTrip(String trip) {
        currentTrip = trip;
    }

    public String getCurrentPath() {
        if (currentTarget == CommandTarget.TRIP) {
            return "~ >";
        } else {
            return "~/" + currentTrip + "/" + currentTarget + " >";
        }
    }

    /**
     * Parse the input command.
     * The return is an abstract Command object that represents the input command.
     *
     * @param command Input command.
     * @return Command object that represents the input command.
     * @throws InvalidCommand If the input command is invalid.
     */
    public Command parse(String command) throws InvalidCommand {
        CommandAction commandAction = extractCommandAction(command);

        if (commandAction.equals(CommandAction.EXIT)) {
            return new ExitCommand();
        }

        ArrayList<String> arguments = extractCommandArguments(command);
        CommandTarget commandTarget = extractCommandTargetType(command, commandAction);

        boolean isIncorrectScope = !commandTarget.equals(CommandTarget.TRIP) && currentTarget == CommandTarget.TRIP;
        if (isIncorrectScope) {
            throw new InvalidCommand();
        }

        return matchCommand(commandAction, commandTarget, arguments);
    }

    private ArrayList<String> extractCommandArguments(String command) throws InvalidCommand {
        String[] doubleHyphenSeparatedTokens = command.strip().split("(^--|\\s+--)(?=\\w+\\s+\\w+)");
        ArrayList<String> arguments = new ArrayList<>();
        for (int i = 1; i < doubleHyphenSeparatedTokens.length; i++) {
            if (!doubleHyphenSeparatedTokens[i].isEmpty()) {
                arguments.add(doubleHyphenSeparatedTokens[i]);
            }
        }
        return arguments;
    }

    private CommandAction extractCommandAction(String command) throws InvalidCommand {
        String commandAction = null;
        try {
            commandAction = command.strip().split("\\s+")[0].toLowerCase();
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidCommand();
        }
        return switch (commandAction) {
        case "add", "a", "make", "mk" -> CommandAction.ADD;
        case "delete", "d", "remove", "rm" -> CommandAction.DELETE_BY_INDEX;
        case "list", "l" -> CommandAction.LIST;
        case "cd" -> CommandAction.CHANGE_DIRECTORY;
        case "exit", "quit", "bye" -> CommandAction.EXIT;
        default -> throw new InvalidCommand();
        };
    }

    private CommandTarget extractCommandTargetType(String command, CommandAction commandAction) throws InvalidCommand {
        String[] spaceSeparatedTokens = command.strip().split("\\s+");
        if (spaceSeparatedTokens.length == 1) {
            return currentTarget;
        }

        String commandTarget = spaceSeparatedTokens[1].toLowerCase();

        // exception case: cd ..
        if (commandAction.equals(CommandAction.CHANGE_DIRECTORY) && commandTarget.equals("..")) {
            return CommandTarget.TRIP;
        }

        return switch (commandTarget) {
        case "trip" -> CommandTarget.TRIP;
        case "itinerary", "itin", "i" -> CommandTarget.ITINERARY;
        case "activity", "act" -> CommandTarget.ACTIVITY;
        case "accommodation", "accom" -> CommandTarget.ACCOMMODATION;
        case "transportation", "tran" -> CommandTarget.TRANSPORTATION;
        default -> currentTarget;
        };
    }

    private Command matchCommand(CommandAction commandAction, CommandTarget commandTarget, ArrayList<String> arguments)
            throws InvalidCommand {
        return switch (commandTarget) {
        case TRIP -> new TripsCommand(commandAction, commandTarget, arguments);
        case ITINERARY, ACTIVITY -> new ItineraryCommand(commandAction, commandTarget, currentTrip, arguments);
        case ACCOMMODATION -> new AccommodationCommand(commandAction, commandTarget, currentTrip, arguments);
        case TRANSPORTATION -> new TransportationCommand(commandAction, commandTarget, currentTrip, arguments);
        default -> throw new InvalidCommand();
        };
    }
}
