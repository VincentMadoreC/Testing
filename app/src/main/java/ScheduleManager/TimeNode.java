package ScheduleManager;

public class TimeNode {
    private int time; // the minute of the day (0 - 1440)
    private TimeNode next;
    private State state;

    public TimeNode(int time, TimeNode next, State state) {
        this.time = time;
        this.next = next;
        this.state = state;
    }

//		public void vanish() {
//			if (this.prev != null) {
//				if (this.next != null) {
//					this.prev.next = this.next;
//					this.next.prev = this.prev;
//					this.prev = null;
//					this.next = null;
//				} else {
//					// vanish() will not be called in the first place
//				}
//			} else {
//				if (this.next == null) {
//					// do nothing
//					// It means that only the head is left
//				}
//			}
//		}

    public void removeNext() {
        if (this.next != null) {
            int time = this.next.time;
            System.out.println("The TimeNode at " + time + " minutes is being removed...");
            TimeNode temp = this.next;
            this.next = this.next.next;
            temp.next = null;
        }
    }

    public String toString() {
        String string = "";
        string = string + "Time: " + this.time
                + ", \tState: " + this.state + "\n";
        return string;
    }

    public int getTime() { return this.time; }
    public void setTime(int time) { this.time = time; }

    public TimeNode getNext() { return this.next; }
    public void setNext(TimeNode next) { this.next = next; }

    public State getState() { return this.state; }
    public void setState(State state) { this.state = state; }
}
