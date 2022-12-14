package com.epam.rd.autotasks.sprintplanning.tickets;

public class Bug extends Ticket {

    private UserStory userStory;

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (userStory == null || userStory.isCompleted() == false) {
            return null;
        }
        else {
            return new Bug(id,name,estimate,userStory);
        }
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
    }

    @Override
    public String toString() {
        if ( this == null ) {
            return "null";
        }
        else {
            return "[Bug " + this.getId() + "] " + userStory.getName() + ": " + this.getName();
        }
    }
}
