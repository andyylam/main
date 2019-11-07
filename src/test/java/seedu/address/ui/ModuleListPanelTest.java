//package seedu.address.ui;
//
//import static seedu.address.testutil.TypicalModule.CS1101S;
//import static seedu.address.testutil.TypicalModule.CS2102;
//import static seedu.address.testutil.TypicalModule.ST2334;
//import static seedu.address.ui.testutil.GuiTestAssert.assertCardDisplaysModule;
//import static seedu.address.ui.testutil.GuiTestAssert.assertCardEquals;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import org.junit.jupiter.api.Test;
//
//import guitests.guihandles.ModuleCardHandle;
//import guitests.guihandles.ModuleListPanelHandle;
//import javafx.beans.property.SimpleObjectProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import seedu.address.model.module.Module;
//
//public class ModuleListPanelTest extends GuiUnitTest {
//    private static final ObservableList<Module> TYPICAL_MODULES =
//            FXCollections.observableList(new ArrayList<>(Arrays.asList(CS1101S, CS2102, ST2334)));
//
//    private final SimpleObjectProperty<Module> selectedModule = new SimpleObjectProperty<>();
//    private ModuleListPanelHandle ModuleListPanelHandle;
//
//    @Test
//    public void display() {
//        initUi(TYPICAL_MODULES);
//
//        for (int i = 0; i < TYPICAL_MODULES.size(); i++) {
//            ModuleListPanelHandle.navigateToCard(TYPICAL_MODULES.get(i));
//            Module expectedModule = TYPICAL_MODULES.get(i);
//            ModuleCardHandle actualCard = ModuleListPanelHandle.getModuleCardHandle(i);
//
//            assertCardDisplaysModule(expectedModule, actualCard);
//        }
//    }
//
//    @Test
//    public void selection_modelSelectedModuleChanged_selectionChanges() {
//        initUi(TYPICAL_MODULES);
//        Module secondModule = TYPICAL_MODULES.get(1);
//        guiRobot.interact(() -> selectedModule.set(secondModule));
//        guiRobot.pauseForHuman();
//
//        ModuleCardHandle expectedModule = ModuleListPanelHandle.getModuleCardHandle(1);
//        ModuleCardHandle selectedModule = ModuleListPanelHandle.getHandleToSelectedCard();
//        assertCardEquals(expectedModule, selectedModule);
//    }
//
//    /**
//     * Initializes {@code ModuleListPanelHandler} with a {@code ModuleListPanel} backed by {@code backingList}.
//     * Also shows the {@code Stage} that displays only {@code ModuleListPanel}.
//     */
//    private void initUi(ObservableList<Module> backingList) {
//        ModuleListPanel ModuleListPanel = new ModuleListPanel(backingList);
//        uiPartExtension.setUiPart(ModuleListPanel);
//
//        ModuleListPanelHandle = new ModuleListPanelHandle(getChildNode(ModuleListPanel.getRoot(),
//                ModuleListPanelHandle.Module_LIST_VIEW_ID));
//    }
//}
