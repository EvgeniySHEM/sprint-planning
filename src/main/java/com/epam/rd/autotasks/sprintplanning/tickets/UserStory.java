package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket {

    private UserStory[] dependent;

    public UserStory(int id, String name, int estimate, UserStory... dependentOn) {
        super(id, name, estimate);
        dependent = dependentOn;
    }

//    @Override
//    public void complete() {
//        if( dependent == null ) {
//            status = true;
//        }
//        if ( dependent.length > 0 && dependent[0].isCompleted() == true ) {
//            this.status = true;
//        }
//        else {
//            this.status = false;
//        }
//    }

    public UserStory[] getDependencies() {
        return dependent.clone();
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}
