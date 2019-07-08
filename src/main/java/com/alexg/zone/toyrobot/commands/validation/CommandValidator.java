package com.alexg.zone.toyrobot.commands.validation;

import java.util.List;

public interface CommandValidator {
    void validateCommandComponents(List<String> cmds);
}
