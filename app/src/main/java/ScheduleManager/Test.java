package ScheduleManager;

import ScheduleManager.DailySchedule;
import ScheduleManager.State;

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

    }
}
