package com.ylz.gradle.todo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lenovo
 * @date 2019/5/19
 * @description []
 */
public enum CommandLineInput {
    /**
     *
     */
    FIND_ALL('a'),
    FIND_BY_ID('f'),
    INSERT('i'),
    UPDATE('u'),
    DELETE('d'),
    EXIT('e');

    private final static Map<Character, CommandLineInput> INPUTS;

    static {
        INPUTS = new HashMap<>();
        for (CommandLineInput input : values()) {
            INPUTS.put(input.getShortCmd(), input);
        }
    }

    private final char shortCmd;

    CommandLineInput(char shortCmd) {
        this.shortCmd = shortCmd;
    }

    public char getShortCmd() {
        return shortCmd;
    }

    public static CommandLineInput getCommandLineInputForInput(char input) {
        return INPUTS.get(input);
    }
}