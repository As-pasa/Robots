package models;

import models.RobotStateProvider;
import models.states.RobotState;
import models.states.RobotStateReader;

public class DummyRobotStateProvider implements RobotStateProvider {
    @Override
    public RobotStateReader getState() {
        return new RobotState(50,50,3*Math.PI/2);
    }
}
