package ScheduleManager;

public class DailySchedule {

//	public enum State {
//		AVAILABLE,
//		UNAVAILABLE,
//		BOOKED
//	}

    private TimeNode head;
    private int size;


    /**
     * Empty constructor
     * Used when merging a ScheduleManager.DailySchedule with a TimeSlot and building a new ScheduleManager.DailySchedule from 0.
     */
    public DailySchedule() {
        head = new TimeNode(0, null, null);
//		head.prev = head.next = head;
        size = 0;
    }

    /**
     * Constructor
     * Creates a 4-nodes schedule using the 2 nodes from the DefaultSchedule and adding 2 extreme nodes.
     * Used to create the starting point to build the final ScheduleManager.DailySchedule.
     * @param startTime
     * @param endTime
     * @param state
     */
    public DailySchedule(int startTime, int endTime, State state) {
        head = new TimeNode(0, null, null); // set next after initialization of node1
        TimeNode node1 = new TimeNode(0, null, State.UNAVAILABLE); // set next after initialization of node2
        TimeNode node2 = new TimeNode(startTime, null, state); // set next after initialization of node3
        TimeNode node3 = new TimeNode(endTime, null, State.UNAVAILABLE); // set next after initialization of node4
        TimeNode node4 = new TimeNode(1440, null, null);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        size = 4;
    }

    public int getSize() {
        return size;
    }

//	public void add(TimeNode timeNode) {
//		head.next = timeNode;
//		head.state = timeNode.prevState;
//		size++;
//	}

//	public void append(TimeNode newTimeNode, boolean hasPriority) {
//		TimeNode last = this.head;
//		// get to the end of the list
//		while (last.next != null) {
//			last = last.next;
//		}
//		last.next = newTimeNode;
//		newTimeNode.prev = last;
//		newTimeNode.next = null;
////		newTimeNode.prevState = lat
//
//		// COME BACK LATER
//	}


    public void append(TimeNode newTimeNode) {
        TimeNode last = this.head;
        while (last.next != null) { // get to the end of the chain
            last = last.next;
        }
        last.next = newTimeNode;
        newTimeNode.next = null;
    }



//	  // add a new integer (most efficient)
//	  public boolean add(int value) {
//
//	    Node newNode= new Node(value, head, head.next);
//		head.next.prev= newNode;
//		head.next= newNode;
//
//		size++;
//
//	    return true;
//	  }





//	public TimeNode extract() {
//		if (this.head.next == null) {
//			return null;
//		} else {
//			TimeNode first = this.head.next;
//			this.head.next = first.next;
//			first.next.prev = head;
//			first.prev = null;
//			first.next = null;
//			return first;
//		}
//
//	}


//	/**
//	 * Get the first TimeNode of the ScheduleManager.DailySchedule.
//	 * @return
//	 */
//	public TimeNode getFirst() {
//		return this.head.next;
//	}

    /**
     * Get the last TimeNode of the ScheduleManager.DailySchedule.
     * @return
     */
    public TimeNode getLast() {
        TimeNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    public TimeNode extractFirst() {
        if (this.head.next == null) {
            return null;
        } else {
            TimeNode first = this.head.next;
            this.head.next = first.next;
            first.next = null;
            return first;
        }
    }

    public DailySchedule merge(TimeSlot timeSlot) {
        // Initialize a blank ScheduleManager.DailySchedule.
        DailySchedule newDS = new DailySchedule();

        // Append all the TimeNodes that are earlier than the startNode of the TimeSlot.
        while (this.head.next.time < timeSlot.getStartNode().time) {
//			TimeNode first = this.extractFirst();
//			newDS.append(first);
            newDS.append(this.extractFirst());

//			this.head.next = this.head.next.next;
//			this.head.next.next.prev
//			this.head.next.prev = newDS.getLast();
//			newDS.getLast().next =
        }

        // If a ScheduleManager.DailySchedule's TimeNode and a TimeSlot's TimeNode have the same time, the TimeSlot has priority
        if (timeSlot.getStartNode().time == this.head.next.time) {
            // Append the timeSlot's startNode and remove the next TimeNode of the current ScheduleManager.DailySchedule.
            newDS.append(timeSlot.getStartNode());
            this.extractFirst(); // Don't do anything with it, just remove it.
        } else {
            newDS.append(timeSlot.getStartNode());
        }

        // Ignore all subsequent TimeNodes that are earlier or equal to the TimeSlot's endTime,
        //	but copy the state of the last ignored node in the endTime TimeNode.
        TimeNode currentIgnoredNode = this.head.next;
        while (currentIgnoredNode.time <= timeSlot.getEndNode().time) {
            timeSlot.getEndNode().state = currentIgnoredNode.state; // Copy the state of the last ignored node.
            currentIgnoredNode = currentIgnoredNode.next;
        }
        newDS.append(timeSlot.getEndNode());

        // Append the rest of the TimeNodes of the ScheduleManager.DailySchedule
        while (this.head.next != null) {
            newDS.append(this.extractFirst());
        }

        newDS.cleanUp();
        return newDS;
    }

//	/**
//	 * Return the TimeNode with the earliest time. If they are equal, return the second one.
//	 * @param timeNode1
//	 * @param timeNode2
//	 * @return
//	 */
//	public TimeNode earliest(TimeNode timeNode1, TimeNode timeNode2) {
//		if (timeNode1.time == timeNode2.time) {
//			return timeNode2;
//		} else if (timeNode1.time < timeNode2.time) {
//			return timeNode1;
//		} else {
//			return timeNode2;
//		}
//	}




    public DailySchedule cleanUp() {
        TimeNode currentNode = this.head;
        TimeNode nextNode = currentNode.next;
        while (nextNode != null) {
            if (currentNode.state == nextNode.state) {
                currentNode.removeNext();
                nextNode = currentNode.next;
            } else {
                currentNode = nextNode;
                nextNode = nextNode.next;
            }
        }
        return this;
    }















//
//	   // add a new integer (least efficient)
//	  public boolean addOppositeSide(int value) {
//
//	    Node newNode= new Node(value, head.prev, head);
//		head.prev.next= newNode;
//		head.prev= newNode;
//
//		size++;
//
//	    return true;
//	  }

//	  // search if a given integer is in the array
//	  public boolean search(int value) {
//
//	    Node n= head.next;
//
//	    while (n!=head && n.element!=value)
//		  n= n.next;
//
//		if (n==head)
//		  return false;
//		else
//		  return true;
//	  }
//
//	  // remove a given integer (first occurrence of)
//	  public boolean searchAndRemove(int value) {
//
//		Node n= head.next;
//
//	    while (n!=head && n.element!=value)
//		  n= n.next;
//
//
//	    if (n!=head) {
//
//		  n.prev.next= n.next;
//		  n.next.prev= n.prev;
//		  size--;
//	      return true;
//
//		} else {
//
//		  return false;
//		}
//	  }
//
//	  // remove element at a given index
//	  public boolean removeAt(int index) {
//
//	    if (index<0 || index>=size)
//		  return false;
//
//		size--;
//
//		Node n= head.next;
//	    for (int i=0; i<index; i++)
//		  n= n.next;
//
//		n.prev.next= n.next;
//		n.next.prev= n.prev;
//
//		return true;
//	  }
//
//
//
//	  // string representation
//	  public String toString() {
//
//	    StringBuffer s = new StringBuffer("");
//
//	    for (Node node= head.next; node!= head; node= node.next) {
//		  s.append("["+node.element+"]");
//		}
//
//		s.append("("+size+")");
//
//		return s.toString();
//	  }
//
//	  public static void main(String[] args) {
//
//	    DoublyLinkedList list= new DoublyLinkedList();
//
//		list.add(34);
//		list.add(93);
//		list.add(67);
//		list.add(23);
//		list.add(51);
//		System.out.println("A:" + list);
//
//		list.addOppositeSide(33);
//		System.out.println("B:" + list);
//
//		list.searchAndRemove(51);
//		System.out.println("C:" + list);
//		list.searchAndRemove(67);
//		System.out.println("D:" + list);
//
//		System.out.println("E1:" + list.search(93));
//		System.out.println("E2:" + list.search(11));
//
//		list.removeAt(1);
//		System.out.println("F1:" + list);
//		list.removeAt(0);
//		System.out.println("F2:" + list);
//		list.removeAt(list.getSize()-1);
//		System.out.println("F3:" + list);
//
//	  }

    public String toString() {
        TimeNode timeNode = this.head.next;
        String schedule = "Schedule's size: " + this.size + "\n";
        while (timeNode != null) {
            schedule = schedule + timeNode.toString();
            timeNode = timeNode.next;
        }
        return schedule;
    }
}
