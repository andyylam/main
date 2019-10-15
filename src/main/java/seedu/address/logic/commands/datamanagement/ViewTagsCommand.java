package seedu.address.logic.commands.datamanagement;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.Set;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.module.Module;
import seedu.address.model.module.exceptions.ModuleNotFoundException;
import seedu.address.model.studyplan.StudyPlan;
import seedu.address.model.tag.UniqueTagList;

/**
 * Shows all tags attached to a specific module.
 */
public class ViewTagsCommand extends Command {

    public static final String COMMAND_WORD = "viewtags";

    public static final String MESSAGE_USAGE = COMMAND_WORD + " : Shows all tags attached to a specific module. "
            + "Parameters: "
            + "MODULE CODE \n"
            + "Example: "
            + "viewtags CS3230";

    public static final String MESSAGE_SUCCESS = "All tags for the module shown %1$s.";
    public static final String MESSAGE_INVALID_MODULE_CODE = "The provided module code is invalid";

    private final String moduleCode;

    /**
     * Creates an {@code ViewTagsCommand} to show all tags attached to the given module.
     */
    public ViewTagsCommand(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        StudyPlan activeStudyPlan = model.getActiveStudyPlan();

        Module module;
        try {
            module = getTargetModule(activeStudyPlan);
        } catch (ModuleNotFoundException exception) {
            throw new CommandException(MESSAGE_INVALID_MODULE_CODE);
        }

        UniqueTagList tags = module.getTags();

        return new CommandResult(String.format(MESSAGE_SUCCESS, tags));
    }

    private Module getTargetModule(StudyPlan activeStudyPlan) throws ModuleNotFoundException {
        HashMap<String, Module> moduleHashMap = activeStudyPlan.getModules();
        Set<String> moduleNames = moduleHashMap.keySet();
        for (String moduleName : moduleNames) {
            Module currentModule = moduleHashMap.get(moduleName);
            if (currentModule.getModuleCode().toString().equals(moduleCode)) {
                return currentModule;
            }
        }
        throw new ModuleNotFoundException();
    }

}