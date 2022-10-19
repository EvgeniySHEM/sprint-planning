package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket {

    private UserStory[] dependent;

    public UserStory(int id, String name, int estimate, UserStory... dependentOn) {
        super(id, name, estimate);
        dependent = dependentOn;
    }

    @Override
    public void complete() {
        if (getDependencies().length == 0) {
            status = true;
        }
        else  {
            for (int i = 0; i < getDependencies().length; i++) {
                if (getDependencies()[i].isCompleted() == true)
                    if (i != getDependencies().length-1)
                    continue;
                    else
                        status = true;
                else
                    break;
            }
        }

    }

    public UserStory[] getDependencies() {
        return dependent.clone();
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}
