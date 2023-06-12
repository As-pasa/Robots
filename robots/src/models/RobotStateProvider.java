package models;

import models.states.RobotStateReader;

public interface RobotStateProvider {
    RobotStateReader getState();
}
