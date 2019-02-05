// Course: CS4242ONLINE Spring 2019
// Student name: Nathan Kurz
// Student ID: 000288473
//Assignment #: #1
// Due Date: February 6, 2019

/**
 * The environment will be the possible rooms for the SimpleReflexAgent to clean
 * The rooms will have an indicator to whether or not they are clean or dirty.
 */

public class Environment {

    // Boolean value to determine if the room is clean.
    // false means room is clean
    private boolean isDirty = false;

    // id for the environment
    private int id = 0;

    // constructor for the agent
    // default state is clean
    Environment() {
        this.setState(false);
    }

    // getter for the current state
    public boolean getState() {
        return this.isDirty;
    }

    // setter for the state
    public void setState(boolean state) {
        this.isDirty = state;
    }

    // getter for id
    public int getID() {
        return this.id;
    }

    // setter for id
    public void setID(int id) {
        this.id = id;
    }
}