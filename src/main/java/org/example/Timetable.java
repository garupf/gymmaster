package org.example;

import java.util.*;

public class Timetable {

    public Timetable() {
        this.timetable = new HashMap<>();
    }

    private final Map<DayOfWeek, TreeMap<TimeOfDay, TrainingSession>> timetable;

    public void addNewTrainingSession(TrainingSession trainingSession) {
        if (this.timetable.containsKey(trainingSession.getDayOfWeek())) {
            DayOfWeek dayOfWeek = trainingSession.getDayOfWeek();
        } else {
            this.timetable.put(trainingSession.getDayOfWeek(), new TreeMap<>());
        }
        TreeMap<TimeOfDay, TrainingSession> map = timetable.get(trainingSession.getDayOfWeek());
        TimeOfDay time = trainingSession.getTimeOfDay();
        map.put(time, trainingSession);
    }

    public List<TrainingSession> getTrainingSessionsForDay(DayOfWeek dayOfWeek) {
        if (dayOfWeek != null) {
            TreeMap<TimeOfDay, TrainingSession> map = timetable.get(dayOfWeek);
            if (map == null) {
                return new ArrayList<>();
            } else {
                return new ArrayList<>(map.values());
            }
        }
        return new ArrayList<>();
    }

    public List<TrainingSession>  getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        TreeMap<TimeOfDay, TrainingSession> map = timetable.get(dayOfWeek);
        if (map == null) {
            return new ArrayList<>();
        }
        TrainingSession trainingSession = map.get(timeOfDay);
        if (trainingSession == null) {
            return new ArrayList<>();
        } else {
            List<TrainingSession> trainingSessions = new ArrayList<>();
            trainingSessions.add(trainingSession);
            return trainingSessions;
        }
    }

}
