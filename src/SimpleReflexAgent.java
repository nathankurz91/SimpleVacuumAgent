// Course: CS4242ONLINE Spring 2019
// Student name: Nathan Kurz
// Student ID: 000288473
//Assignment #: #1
// Due Date: February 6, 2019

/**
 * This program will implement the simple reflex agent for the vacuum environment in exercise 2.8.
 * The SimpleReflexAgent will have features such as Sensors and Actuators.
 * Sensors will detect whether or not the room is dirty
 * If the room is dirty, the actuators will 'suck' the dirt and clean the room
 * If the room is not dirty, the vacuum will either move left or right to check the other room
 * A performance score for each configuration, and an overall average score will be kept
 *
 */

public class SimpleReflexAgent {

    // integer for score
    // 1 point for each clean square at each time step
    private int performanceMeasure = 0;

    // the agent will check the id of the environment
    // its location will mimic the id of the room it is in
    private int currentLocation = 0;

    // boolean to check the state of the environment the agent is currently in
    private boolean currentEnvState = false;

    // constructor initializes agent with either 0 or 1 location 
    // 0 is left, 1 is right
    public SimpleReflexAgent() {
        this.currentLocation = (int)Math.round(Math.random());
    }

    // getter for performance measure
    public int getPerformanceMeasure() {
        return this.performanceMeasure;
    }

    // method to increase performance measure by 1
    public void incPerformanceMeasure() {
        this.performanceMeasure += 1;
    }

    // getter for current location
    public int getCurrentLocation() {
        return this.currentLocation;
    }

    // setter for current location
    public void setCurrentLocation(Environment env) {
        this.currentLocation = env.getID();
    }

    // setter for current enviroment state
    public void setCurrentEnvState(Environment env) {
        this.currentEnvState = env.getState();
    }

    // method will move the vacuum right
    public void moveRight() {
        if (this.currentLocation == 0){
            this.currentLocation += 1;
        } else {
            System.out.println("Agent already right.");
        }

    }

    // method will move the vacuum left
    public void moveLeft() {
        if (this.currentLocation == 1) {
            this.currentLocation -= 1;
        } else {
            System.out.println("Agent already left.");
        }
    }

    // method checks if current environment is dirty,
    // returns boolean false if clean, true if dirty
    public boolean checkEnv(Environment env) {
        boolean isDirty;
        if (env.getState() == false) {
            isDirty = false;
            System.out.println("Environment " + env.getID() + " already clean. One point awarded.");
            this.incPerformanceMeasure();
        } else {
            isDirty = true;
            this.currentEnvState = true;
        }

        return isDirty;
    }

    // method cleans the room if dirty (isDirty = true)
    public void suck(Environment env) {
        env.setState(false);
        this.setCurrentEnvState(env);
        System.out.println("Room " + env.getID() + " has been cleaned.");
    }

}