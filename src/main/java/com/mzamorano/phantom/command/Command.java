package com.mzamorano.phantom.command;

import com.mzamorano.phantom.str.StringReader;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public abstract class Command {
    private final StringReader s;

    public Command(StringReader s) {
        this.s = s;
    }

    public void runMessage(MessageReceivedEvent event) {
        System.out.println("Unimplemented message runner called for command");
    }

    public String S(String identifier) {
        return s.read(identifier);
    }
}
