package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.studyplan.StudyPlan;

/**
 * The API of the Model component.
 */
public interface Model_ {
    /**
     * {@code Predicate} that always evaluate to true
     */
    Predicate<StudyPlan> PREDICATE_SHOW_ALL_STUDY_PLANS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getModulePlannerFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setModulePlannerFilePath(Path ModulePlannerFilePath);

    /**
     * Replaces address book data with the data in {@code ModulePlanner}.
     */
    void setModulePlanner(ReadOnlyModulePlanner ModulePlanner);

    /**
     * Returns the ModulePlanner
     */
    ReadOnlyModulePlanner getModulePlanner();

    /**
     * Returns true if a StudyPlan with the same identity as {@code StudyPlan} exists in the address book.
     */
    boolean hasStudyPlan(StudyPlan StudyPlan);

    /**
     * Deletes the given StudyPlan.
     * The StudyPlan must exist in the address book.
     */
    void deleteStudyPlan(StudyPlan target);

    /**
     * Adds the given StudyPlan.
     * {@code StudyPlan} must not already exist in the address book.
     */
    void addStudyPlan(StudyPlan StudyPlan);

    /**
     * Replaces the given StudyPlan {@code target} with {@code editedStudyPlan}.
     * {@code target} must exist in the address book.
     * The StudyPlan identity of {@code editedStudyPlan} must not be the same as another existing StudyPlan in the address book.
     */
    void setStudyPlan(StudyPlan target, StudyPlan editedStudyPlan);

    /**
     * Returns an unmodifiable view of the filtered StudyPlan list
     */
    ObservableList<StudyPlan> getFilteredStudyPlanList();

    /**
     * Updates the filter of the filtered StudyPlan list to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredStudyPlanList(Predicate<StudyPlan> predicate);
}


///**
// * The API of the Model component.
// */
//public interface Model {
//    /**
//     * {@code Predicate} that always evaluate to true
//     */
//    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;
//
//    /**
//     * Replaces user prefs data with the data in {@code userPrefs}.
//     */
//    void setUserPrefs(ReadOnlyUserPrefs userPrefs);
//
//    /**
//     * Returns the user prefs.
//     */
//    ReadOnlyUserPrefs getUserPrefs();
//
//    /**
//     * Returns the user prefs' GUI settings.
//     */
//    GuiSettings getGuiSettings();
//
//    /**
//     * Sets the user prefs' GUI settings.
//     */
//    void setGuiSettings(GuiSettings guiSettings);
//
//    /**
//     * Returns the user prefs' address book file path.
//     */
//    Path getAddressBookFilePath();
//
//    /**
//     * Sets the user prefs' address book file path.
//     */
//    void setAddressBookFilePath(Path addressBookFilePath);
//
//    /**
//     * Replaces address book data with the data in {@code addressBook}.
//     */
//    void setAddressBook(ReadOnlyAddressBook addressBook);
//
//    /**
//     * Returns the AddressBook
//     */
//    ReadOnlyAddressBook getAddressBook();
//
//    /**
//     * Returns true if a person with the same identity as {@code person} exists in the address book.
//     */
//    boolean hasPerson(Person person);
//
//    /**
//     * Deletes the given person.
//     * The person must exist in the address book.
//     */
//    void deletePerson(Person target);
//
//    /**
//     * Adds the given person.
//     * {@code person} must not already exist in the address book.
//     */
//    void addPerson(Person person);
//
//    /**
//     * Replaces the given person {@code target} with {@code editedPerson}.
//     * {@code target} must exist in the address book.
//     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
//     */
//    void setPerson(Person target, Person editedPerson);
//
//    /**
//     * Returns an unmodifiable view of the filtered person list
//     */
//    ObservableList<Person> getFilteredPersonList();
//
//    /**
//     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
//     *
//     * @throws NullPointerException if {@code predicate} is null.
//     */
//    void updateFilteredPersonList(Predicate<Person> predicate);
//}