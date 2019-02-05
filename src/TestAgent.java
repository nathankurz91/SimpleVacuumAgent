public class TestAgent {
    public static void main(String[] args) {

        // create two environments
        Environment leftEnv = new Environment();
        Environment rightEnv = new Environment();

        //set them to left and right
        leftEnv.setID(0);
        rightEnv.setID(1);

        // integer to count lifecycle
        int lifetime = 10;

        // create agent
        SimpleReflexAgent agent = new SimpleReflexAgent();

        // set agent to left side
        agent.moveLeft();

        // clean rooms for 1000 time steps
        // if the environment is clean, vacuum will move to other room and the environment will randomly either
        // become dirty or not
        for (int i = 0; i < lifetime; i++) {
            // if the agent is in left room and it is clean, move right
            if (agent.getCurrentLocation() == 0 && agent.checkEnv(leftEnv) == false) {
                agent.moveRight();

                // randomly assign a 0 or 1 to room after agent moves
                int rand = (int)Math.round(Math.random());
                if(rand == 0) {
                    leftEnv.setState(false);
                } else {
                    leftEnv.setState(true);
                }

                // if agent is in left room and it is dirty, suck then move right
            } else if (agent.getCurrentLocation() == 0 && agent.checkEnv(leftEnv) == true) {
                agent.suck(leftEnv);
                agent.moveRight();
                // if agent is in right room and it is clean, move left
            } else if (agent.getCurrentLocation() == 1 && agent.checkEnv(rightEnv) == false) {
                agent.moveLeft();

                // randomly assign a 0 or 1 to room after agent moves
                int rand = (int)Math.round(Math.random());
                if(rand == 0) {
                    leftEnv.setState(false);
                } else {
                    leftEnv.setState(true);
                }
                // if agent is in right room and it is dirty, suck then move left
            } else if (agent.getCurrentLocation() == 1 && agent.checkEnv(rightEnv) == true) {
                agent.suck(rightEnv);
                agent.moveLeft();
            }

        }

        // display performance score
        System.out.println("Agents performance score: " + agent.getPerformanceMeasure());




    }
}