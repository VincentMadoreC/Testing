package ScheduleManager;

public class TimeSlot {
    private TimeNode startNode;
    private TimeNode endNode;
//		public State state;

    public TimeSlot(int startTime, int endTime, State state) {
        TimeNode startNode = new TimeNode(startTime, null, state); // set next after initialization of endNode
        TimeNode endNode = new TimeNode(endTime, null, null);
        startNode.next = endNode;

        this.startNode = startNode;
        this.endNode = endNode;
    }

    public TimeNode getStartNode() { return this.startNode; }
    public TimeNode getEndNode() { return this.endNode; }

}
