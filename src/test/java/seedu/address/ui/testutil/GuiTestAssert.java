package seedu.address.ui.testutil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import guitests.guihandles.ModuleCardHandle;
import guitests.guihandles.ModuleListPanelHandle;
import guitests.guihandles.ModulePillHandle;
import guitests.guihandles.ResultDisplayHandle;
import seedu.address.model.module.Module;

/**
 * A set of assertion methods useful for writing GUI tests.
 */
public class GuiTestAssert {
    /**
     * Asserts that {@code actualCard} displays the same values as {@code expectedCard}.
     */
    public static void assertCardEquals(ModuleCardHandle expectedCard, ModuleCardHandle actualCard) {
        assertEquals(expectedCard.getMcCount(), actualCard.getMcCount());
        assertEquals(expectedCard.getPrereqs(), actualCard.getPrereqs());
        assertEquals(expectedCard.getName(), actualCard.getName());
        assertEquals(expectedCard.getTags(), actualCard.getTags());
    }

    /**
     * Asserts that {@code actualCard} displays the details of {@code expectedModule}.
     */
    public static void assertCardDisplaysModule(Module expectedModule, ModuleCardHandle actualCard) {
        assertEquals(expectedModule.getModuleCode() + " "
                + expectedModule.getName().toString(), actualCard.getName());
        assertEquals("" + expectedModule.getMcCount(), actualCard.getMcCount());
        assertEquals("Needs: " + expectedModule.getPrereqString(), actualCard.getPrereqs());
        assertEquals("" + expectedModule.getMcCount(), actualCard.getMcCount());
        assertEquals(expectedModule.getTags().asListOfStrings(), actualCard.getTags());
    }

    /**
     * Asserts that {@code actualCard} displays the details of {@code expectedModule}.
     */
    public static void assertPillDisplaysModule(Module expectedModule, ModulePillHandle actualPill) {
        assertEquals(expectedModule.getModuleCode().toString(), actualPill.getName());
    }

    /**
     * Asserts that the list in {@code personListPanelHandle} displays the details of {@code persons} correctly and
     * in the correct order.
     */
    public static void assertListMatching(ModuleListPanelHandle personListPanelHandle, Module... persons) {
        for (int i = 0; i < persons.length; i++) {
            personListPanelHandle.navigateToCard(i);
            assertCardDisplaysModule(persons[i], personListPanelHandle.getModuleCardHandle(i));
        }
    }

    /**
     * Asserts that the list in {@code personListPanelHandle} displays the details of {@code persons} correctly and
     * in the correct order.
     */
    public static void assertListMatching(ModuleListPanelHandle personListPanelHandle, List<Module> persons) {
        assertListMatching(personListPanelHandle, persons.toArray(new Module[0]));
    }

    /**
     * Asserts the size of the list in {@code personListPanelHandle} equals to {@code size}.
     */
    public static void assertListSize(ModuleListPanelHandle personListPanelHandle, int size) {
        int numberOfPeople = personListPanelHandle.getListSize();
        assertEquals(size, numberOfPeople);
    }

    /**
     * Asserts the message shown in {@code resultDisplayHandle} equals to {@code expected}.
     */
    public static void assertResultMessage(ResultDisplayHandle resultDisplayHandle, String expected) {
        assertEquals(expected, resultDisplayHandle.getText());
    }
}
