package com.mzamorano.phantom.listener;

import com.mzamorano.phantom.command.Command;
import com.mzamorano.phantom.command.HelloCommand;
import com.mzamorano.phantom.str.StringReader;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;
import java.util.Map;

public class MessageReceivedListener extends ListenerAdapter {
    private final StringReader s;
    private final Map<String, Command> commands = new HashMap<>();
    private final static String prefix = "!";

    public MessageReceivedListener(StringReader s) {
        this.s = s;
        commands.put("hello", new HelloCommand(s));
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User author = event.getAuthor();
        if (author.isBot()) {
            return;
        }

        Message message = event.getMessage();
        String[] fields = message.getContentRaw().split("\\s+");
        if (fields.length == 0 || !fields[0].startsWith(prefix)) {
            return;
        }

        String invocation = fields[0].replaceFirst("^" + prefix, "");
        Command invokedCommand = commands.get(invocation);
        if (invokedCommand == null) {
            event.getChannel().sendMessage(s.read("help.command_not_recognized")).queue();
            return;
        }

        invokedCommand.runMessage(event);
    }
}
