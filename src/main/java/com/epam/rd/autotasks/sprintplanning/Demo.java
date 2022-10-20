package com.epam.rd.autotasks.sprintplanning;


import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Demo {
    public static void main(String[] args) {

        int nextId = 1;
        Sprint sprint = new Sprint(40, 3);

        UserStory us1 = new UserStory(nextId++, "User Registration Entity", 8);
        UserStory us2 = new UserStory(nextId++, "User Registration Form", 16, us1);
        UserStory us3 = new UserStory(nextId++, "User Registration. Apply Captcha", 16, us1, us2);

        System.out.println(sprint.addUserStory(us2));
        System.out.println(sprint.addUserStory(us3));

        System.out.println(sprint.addUserStory(us1));
        System.out.println(sprint.addUserStory(us3));

        System.out.println(sprint.addUserStory(us2));
        System.out.println(sprint.addUserStory(us3));

        System.out.println(sprint.getTickets()[0].toString());
        System.out.println(sprint.getTickets()[1].toString());
        System.out.println(sprint.getTickets()[2].toString());
    }
}
