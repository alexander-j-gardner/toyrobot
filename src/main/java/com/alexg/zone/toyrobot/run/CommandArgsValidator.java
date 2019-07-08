package com.alexg.zone.toyrobot.run;

public class CommandArgsValidator {
    public boolean validateArgs(String[] args) {
        return (args.length == 1) ? true : false;
    }
}
