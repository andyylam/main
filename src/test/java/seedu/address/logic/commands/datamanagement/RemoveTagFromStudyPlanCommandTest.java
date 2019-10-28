package seedu.address.logic.commands.datamanagement;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.studyplan.StudyPlan;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.ModulePlannerBuilder;
import seedu.address.testutil.StudyPlanBuilder;
import seedu.address.testutil.TagBuilder;
import seedu.address.testutil.TypicalModulesInfo;

public class RemoveTagFromStudyPlanCommandTest {

    @Test
    public void constructor_nullPriorityLevel_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TagStudyPlanCommand(null, 1));
    }

    @Test
    public void execute_tagInStudyPlan_removeSuccessful() {
        // construct priority tag
        Tag validTagOne = new TagBuilder().buildPriorityHighTag();

        // construct model containing study plan with the tag
        StudyPlan studyPlan = new StudyPlanBuilder().withStudyPlanTags(validTagOne).build();
        Model model = new ModelManager(new ModulePlannerBuilder().withStudyPlan(studyPlan).build(),
                new UserPrefs(), TypicalModulesInfo.getTypicalModulesInfo());

        // construct expected model containing study plan with no tags
        StudyPlan expectedStudyPlan = new StudyPlanBuilder().build();
        Model expectedModel = new ModelManager(new ModulePlannerBuilder().withStudyPlan(studyPlan).build(),
                new UserPrefs(), TypicalModulesInfo.getTypicalModulesInfo());
        expectedModel.deleteStudyPlan(studyPlan);
        expectedModel.addStudyPlan(expectedStudyPlan);
        expectedModel.addToHistory();

        // construct command to remove the tag
        RemoveTagFromStudyPlanCommand removeTagFromStudyPlanCommand =
                new RemoveTagFromStudyPlanCommand("HIGH", 1);
        assertCommandSuccess(removeTagFromStudyPlanCommand, model,
                String.format(RemoveTagFromStudyPlanCommand.MESSAGE_SUCCESS, validTagOne, studyPlan), expectedModel);
    }

    @Test
    public void execute_tagNotInStudyPlan_throwsCommandException() {
        // construct priority tag
        Tag validTagOne = new TagBuilder().buildPriorityHighTag();

        // construct model containing study plan with no tag
        StudyPlan studyPlan = new StudyPlanBuilder().build();
        Model model = new ModelManager(new ModulePlannerBuilder().withStudyPlan(studyPlan).build(),
                new UserPrefs(), TypicalModulesInfo.getTypicalModulesInfo());

        // construct command to remove the tag
        RemoveTagFromStudyPlanCommand removeTagFromStudyPlanCommand =
                new RemoveTagFromStudyPlanCommand("HIGH", 1);
        assertThrows(CommandException.class, () -> removeTagFromStudyPlanCommand.execute(model),
                RemoveTagFromStudyPlanCommand.MESSAGE_TAG_DOES_NOT_EXIST);
    }

    @Test
    public void equals() {
        RemoveTagFromStudyPlanCommand removeTagFromStudyPlanCommand =
                new RemoveTagFromStudyPlanCommand("HIGH", 1);
        RemoveTagFromStudyPlanCommand removeTagFromOtherStudyPlanCommand =
                new RemoveTagFromStudyPlanCommand("HIGH", 2);
        RemoveTagFromStudyPlanCommand removeOtherTagFromStudyPlanCommand =
                new RemoveTagFromStudyPlanCommand("MEDIUM", 1);

        // same object -> returns true
        assertTrue(removeTagFromStudyPlanCommand.equals(removeTagFromStudyPlanCommand));

        // same values -> returns true
        RemoveTagFromStudyPlanCommand removeTagFromStudyPlanCommandCopy =
                new RemoveTagFromStudyPlanCommand("HIGH", 1);
        assertTrue(removeTagFromStudyPlanCommand.equals(removeTagFromStudyPlanCommandCopy));

        // different types -> returns false
        assertFalse(removeTagFromStudyPlanCommand.equals(1));

        // null -> returns false
        assertFalse(removeTagFromStudyPlanCommand.equals(null));

        // different priority tag -> returns false
        assertFalse(removeTagFromStudyPlanCommand.equals(removeOtherTagFromStudyPlanCommand));

        // different study plan -> returns false
        assertFalse(removeTagFromStudyPlanCommand.equals(removeTagFromOtherStudyPlanCommand));

    }

}
