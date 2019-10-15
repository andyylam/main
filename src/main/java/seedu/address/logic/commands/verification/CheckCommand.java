package seedu.address.logic.commands.verification;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Checks if requirements are met for the study plan.
 */
public class CheckCommand extends Command {

    public static final String COMMAND_WORD = "check";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Checks if requirements are met for your study plan.\n"
            + "Parameters: MODULE (must be a valid module code)\n"
            + "Example: " + COMMAND_WORD + " CS2040S";

    private final String moduleCode;

    public CheckCommand(String moduleCode) {
        requireAllNonNull(moduleCode);
        this.moduleCode = moduleCode;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        String result = model.getModuleInformation(this.moduleCode);
        if (result == null) {
            throw new CommandException("Module not found!");
        }
        return new CommandResult(result);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CheckCommand)) {
            return false;
        }

        // state check
        CheckCommand e = (CheckCommand) other;
        return moduleCode.equals(e.moduleCode);
    }
}