package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Timetable {

    public Timetable() {
        this.timetable = new HashMap<>();
    }

    private final Map<DayOfWeek, TreeMap<TimeOfDay, TrainingSession>> timetable;

        //private /* как это хранить??? */ timetable//

    public void addNewTrainingSession(TrainingSession trainingSession) {
        if (this.timetable.containsKey(trainingSession.getDayOfWeek())) {
            DayOfWeek dayOfWeek = trainingSession.getDayOfWeek();
        } else {
            this.timetable.put(trainingSession.getDayOfWeek(), new TreeMap<>());
        }
        TreeMap<TimeOfDay, TrainingSession> map = this.timetable.get(trainingSession.getDayOfWeek());
        TimeOfDay time = trainingSession.getTimeOfDay();
        map.put(time, trainingSession);
        //сохраняем занятие в расписании
    }

    public TrainingSession getTrainingSessionsForDay(DayOfWeek dayOfWeek) {
        if (dayOfWeek != null) {
            TreeMap<TimeOfDay, TrainingSession> map = this.timetable.get(dayOfWeek);
            if (map == null) {
                return null;
            } else {
                TimeOfDay timeOfDay = map.firstKey();
            }
        }

        //как реализовать, тоже непонятно, но сложность должна быть О(1)
        return null;
    }

    public TrainingSession  getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        //как реализовать, тоже непонятно, но сложность должна быть О(1)
        return null;
    }

}
