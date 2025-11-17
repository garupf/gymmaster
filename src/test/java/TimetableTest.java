import org.example.*;
import org.junit.jupiter.api.Test;
import org.example.Timetable;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimetableTest {

    @Test
    void testGetTrainingSessionsForDaySingleSession() {
        Timetable timetable = new Timetable();

        Group group = new Group("Акробатика для детей", Age.CHILD, 60);
        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");
        TrainingSession singleTrainingSession = new TrainingSession(group, coach,
                DayOfWeek.MONDAY, new TimeOfDay(13, 0));

        timetable.addNewTrainingSession(singleTrainingSession);
        List<TrainingSession> mondaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY);
        assertEquals(1, mondaySessions.size());
        List<TrainingSession> tuesdaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.TUESDAY);
        assertTrue(tuesdaySessions.isEmpty());

    }

    @Test
    void testGetTrainingSessionsForDayMultipleSessions() {
        Timetable timetable = new Timetable();

        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");

        Group groupAdult = new Group("Акробатика для взрослых", Age.ADULT, 90);
        TrainingSession thursdayAdultTrainingSession = new TrainingSession(groupAdult, coach,
                DayOfWeek.THURSDAY, new TimeOfDay(20, 0));

        timetable.addNewTrainingSession(thursdayAdultTrainingSession);

        Group groupChild = new Group("Акробатика для детей", Age.CHILD, 60);
        TrainingSession mondayChildTrainingSession = new TrainingSession(groupChild, coach,
                DayOfWeek.MONDAY, new TimeOfDay(13, 0));
        TrainingSession thursdayChildTrainingSession = new TrainingSession(groupChild, coach,
                DayOfWeek.THURSDAY, new TimeOfDay(13, 0));
        TrainingSession saturdayChildTrainingSession = new TrainingSession(groupChild, coach,
                DayOfWeek.SATURDAY, new TimeOfDay(10, 0));

        timetable.addNewTrainingSession(mondayChildTrainingSession);
        timetable.addNewTrainingSession(thursdayChildTrainingSession);
        timetable.addNewTrainingSession(saturdayChildTrainingSession);

        List<TrainingSession> mondaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY);
        assertEquals(1, mondaySessions.size());
        List<TrainingSession> thursdaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.THURSDAY);
        assertEquals(13, thursdaySessions.get(0).getTimeOfDay().getHours());
        assertEquals(0, thursdaySessions.get(0).getTimeOfDay().getMinutes());
        assertEquals(20, thursdaySessions.get(1).getTimeOfDay().getHours());
        assertEquals(0, thursdaySessions.get(1).getTimeOfDay().getMinutes());
        List<TrainingSession> tuesdaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.TUESDAY);
        assertTrue(tuesdaySessions.isEmpty());
    }

    @Test
    void testGetTrainingSessionsForDayAndTime() {
        Timetable timetable = new Timetable();

        Group group = new Group("Акробатика для детей", Age.CHILD, 60);
        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");
        TrainingSession singleTrainingSession = new TrainingSession(group, coach,
                DayOfWeek.MONDAY, new TimeOfDay(13, 0));

        timetable.addNewTrainingSession(singleTrainingSession);

        List<TrainingSession> mondaySessions = timetable.getTrainingSessionsForDay(DayOfWeek.MONDAY);
        assertEquals(1, mondaySessions.size());
        assertEquals(13, mondaySessions.get(0).getTimeOfDay().getHours());
        assertEquals(0, mondaySessions.get(0).getTimeOfDay().getMinutes());
        assertTrue(timetable.getTrainingSessionsForDayAndTime(DayOfWeek.MONDAY, new TimeOfDay(14, 0)).isEmpty());

    }

    //вернуть тренера и количество занятий у него
    @Test
    void testGetTrainingSessionsForSingleCoach() {
        Timetable timetable = new Timetable();
        Group group = new Group("Акробатика для детей", Age.CHILD, 60);
        Coach coach = new Coach("Васильев", "Николай", "Сергеевич");
        TrainingSession singleTrainingSession = new TrainingSession(group, coach,
                DayOfWeek.MONDAY, new TimeOfDay(13, 0));

        timetable.addNewTrainingSession(singleTrainingSession);

        Map<Coach, Integer> coachSessions = timetable.getCountByCoaches();

        assertEquals(1, coachSessions.size());
        assertTrue(coachSessions.containsKey(coach));
        assertEquals(1, coachSessions.get(coach));

    }
    //вернуть несколько тренеров и количество занятий у каждого
    @Test
    void testGetTrainingSessionsForMultipleCoaches() {
        Timetable timetable = new Timetable();

    }
    //вернуть пустую коллекцию если нет тренировок

}

