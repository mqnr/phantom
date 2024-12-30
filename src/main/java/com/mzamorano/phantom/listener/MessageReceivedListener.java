package com.mzamorano.phantom.listener;

import com.mzamorano.phantom.str.StringReader;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageReceivedListener extends ListenerAdapter {
    private final StringReader s;

    public MessageReceivedListener(StringReader stringReader) {
        this.s = stringReader;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User author = event.getAuthor();
        if (author.isBot()) {
            return;
        }

        Message message = event.getMessage();

        if (message.getContentRaw().equals("hello")) {
            event.getChannel().sendMessage(s.read("hello.world")).queue();
        }
    }
}
