package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Timetable {

    private final Map<DayOfWeek, TreeMap<TimeOfDay, TrainingSession>> timetable;

    public Timetable() {
        this.timetable = new HashMap<>();
    }

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
        //как реализовать, тоже непонятно, но сложность должна быть О(1)
        return null;
    }

    public TrainingSession  getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        //как реализовать, тоже непонятно, но сложность должна быть О(1)
        return null;
    }

}
