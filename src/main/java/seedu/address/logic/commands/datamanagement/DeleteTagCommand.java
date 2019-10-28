package seedu.address.logic.commands.datamanagement;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.tag.UserTag;

/**
 * Deletes a module tag completely from the study plan.
 */
public class DeleteTagCommand extends Command {

    public static final String COMMAND_WORD = "deletemodtag";
    public static final String HELP_MESSAGE = COMMAND_WORD + ": Deleting a module tag";
    public static final String MESSAGE_USAGE = COMMAND_WORD + " : Deletes the module tag with the specified tag name "
            + "Parameters: "
            + "TAG_NAME \n"
            + "Example: "
            + "deletemodtag exchange";

    public static final String MESSAGE_SUCCESS = "Tag %1$s has been deleted";
    public static final String MESSAGE_TAG_NOT_FOUND = "There is no [%1$s] tag in this study plan";
    public static final String MESSAGE_INVALID_DEFAULT_TAG_MODIFICATION = "Default tags cannot be deleted";

    private final String tagName;

    /**
     * Creates an {@code DeleteTagCommand} to delete the module tag with the given name.
     * @param tagName
     */
    public DeleteTagCommand(String tagName) {
        requireNonNull(tagName);
        this.tagName = tagName;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (!UserTag.isValidTagName(tagName)) {
            throw new CommandException(MESSAGE_INVALID_DEFAULT_TAG_MODIFICATION);
        }

        if (!model.activeSpContainsModuleTag(tagName)) {
            throw new CommandException(String.format(MESSAGE_TAG_NOT_FOUND, tagName));
        }

        UserTag toDelete = (UserTag) model.getModuleTagFromActiveSp(tagName);

        model.deleteModuleTagFromActiveSp(toDelete);
        model.addToHistory();

        return new CommandResult(String.format(MESSAGE_SUCCESS, toDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteTagCommand // instanceof handles nulls
                && tagName.equals(((DeleteTagCommand) other).tagName)); // state check
    }

}
