package com.alexg.zone.toyrobot.commands.validation;

import java.util.List;

public class ToyRobotCommandValidator implements CommandValidator {

    @Override
    public void validateCommandComponents(List<String> cmdComponents) {

        if (cmdComponents.size() < 1 || cmdComponents.size() > 2) {
            throw new CommandValidationException("Wrong no of command params specified [ " + cmdComponents.size() +
                    " ], should be between 1 and 2");
        }
    }

}
