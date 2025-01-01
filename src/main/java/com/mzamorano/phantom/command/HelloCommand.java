package com.mzamorano.phantom.command;

import com.mzamorano.phantom.str.StringReader;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class HelloCommand extends Command {
    public HelloCommand(StringReader s) {
        super(s);
    }

    @Override
    public void runMessage(MessageReceivedEvent event) {
        event.getChannel().sendMessage(S("hello.world")).queue();
    }
}
