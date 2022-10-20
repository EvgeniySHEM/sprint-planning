package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint {
    private int capacity;
    private int ticketsLimit;
    private Ticket[] tickets;
    int index = 0;


    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        tickets = new Ticket[ticketsLimit];
    }

    public boolean addUserStory(UserStory userStory) {
        if ( userStory == null || userStory.isCompleted() == true )
            return false;

        if ( getTotalEstimate() + userStory.getEstimate() > capacity)
            return false;

        if ( userStory.getId() > ticketsLimit )
            return false;


        if ( userStory.getDependencies().length != 0 ) {
            INNER1:
            for (int i = 0; i < userStory.getDependencies().length; i++) {
                if ( userStory.getDependencies()[i].isCompleted() == false) {
                    INNER2:
                    for (int j = 0; j < tickets.length; j++) {
                        if (tickets[j] == null) {
                            return false;
                        } else if (tickets[j] == userStory.getDependencies()[i]) {
                            if ( i != userStory.getDependencies().length - 1) {
                                continue INNER1;
                            }
                            else {
                                tickets[index] = userStory;
                                index++;
                                return true;
                            }
                        } else if (j != tickets.length -1) {
                            continue INNER2;

                        } else {
                            return false;
                        }
                    }

                }
                else {
                    return false;
                }
            }

        }

        tickets[index] = userStory;
        index++;
        return true;
    }

    public boolean addBug(Bug bugReport) {

        if (bugReport == null || bugReport.isCompleted() == true)
            return false;

        if ( getTotalEstimate() + bugReport.getEstimate() > capacity)
            return false;

        if ( bugReport.getId()-1 > ticketsLimit )
            return false;

        tickets[index] = bugReport;
        index++;
        return true;
    }


    public Ticket[] getTickets() {
        int counter = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == null)
                continue;
            else
                counter++;
        }

        Ticket[] result = new Ticket[counter];

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == null)
                continue;
            else
                result[i] = tickets[i];
        }

        return result;
    }


    public int getTotalEstimate() {
        int sumEstimate = 0;

        for (int i=0; i<tickets.length; i++) {
            if (tickets[i] == null)
                return sumEstimate;
            else
                sumEstimate += tickets[i].getEstimate();
        }

        return sumEstimate;
    }
}
