package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.ui.testutil.GuiTestAssert.assertPillDisplaysModule;

import org.junit.jupiter.api.Test;

import guitests.guihandles.ModulePillHandle;
import seedu.address.model.module.Module;
import seedu.address.testutil.ModuleBuilder;

public class ModulePillTest extends GuiUnitTest {

    @Test
    public void display() {
        Module module = new ModuleBuilder().build();
        ModulePill ModulePill = new ModulePill(module);
        uiPartExtension.setUiPart(ModulePill);
        assertPillDisplay(ModulePill, module);
    }

    @Test
    public void equals() {
        Module module = new ModuleBuilder().build();
        ModulePill ModulePill = new ModulePill(module);

        ModulePill copy = new ModulePill(module);
        assertTrue(ModulePill.equals(copy));

        assertTrue(ModulePill.equals(ModulePill));

        assertFalse(ModulePill.equals(null));

        // different types -> returns false
        assertFalse(ModulePill.equals(0));
    }

    /**
     * Asserts that {@code ModulePill} displays the details of {@code expectedModule} correctly and matches
     * {@code expectedId}.
     */
    private void assertPillDisplay(ModulePill ModulePill, Module expectedModule) {
        guiRobot.pauseForHuman();

        ModulePillHandle ModulePillHandle = new ModulePillHandle(ModulePill.getRoot());

        // verify module details are displayed correctly
        assertPillDisplaysModule(expectedModule, ModulePillHandle);
    }
}
