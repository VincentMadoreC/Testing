package com.example.vincent.testing.ScheduleManager;

public class Test {
    public static void main(String[] args) {
        // Printing a blank schedule
        System.out.println("------ Blank schedule ------");
        DailySchedule schedule1 = new DailySchedule();
        System.out.println(schedule1);

        // Printing a basic schedule
        System.out.println("------ Basic schedule ------");
        DailySchedule schedule2 = new DailySchedule(480, 960, State.AVAILABLE);
        System.out.println(schedule2);

        // Merging a basic schedule with a TimeSlot
        System.out.println("------ Merged basic schedule ------");
        TimeSlot timeSlot = new TimeSlot(240, 720, State.UNAVAILABLE);
        schedule2 = schedule2.merge(timeSlot);
        System.out.println(schedule2);

        // Merging a basic schedule with a TimeSlot
        System.out.println("------ Merged basic schedule ------");
        DailySchedule schedule3 = new DailySchedule(480, 960, State.AVAILABLE);
        TimeSlot timeSlot3 = new TimeSlot(240, 720, State.AVAILABLE);
        schedule3 = schedule3.merge(timeSlot3);
        System.out.println(schedule3);

        // Merging a basic schedule with a TimeSlot
        System.out.println("------ Merged basic schedule with equal nodes ------");
        DailySchedule schedule4 = new DailySchedule(480, 960, State.AVAILABLE);
        TimeSlot timeSlot4 = new TimeSlot(240, 960, State.AVAILABLE);
        schedule4 = schedule4.merge(timeSlot4);
        System.out.println(schedule4);

        // Merging a basic schedule with a TimeSlot
        System.out.println("------ Merged basic schedule with equal nodes ------");
        DailySchedule schedule5 = new DailySchedule(480, 960, State.AVAILABLE);
        TimeSlot timeSlot5 = new TimeSlot(480, 960, State.UNAVAILABLE);
        schedule5= schedule5.merge(timeSlot5);
        System.out.println(schedule5);

    }
}
