package com.mzamorano.phantom;

import com.mzamorano.phantom.listener.MessageReceivedListener;
import com.mzamorano.phantom.str.StringMapReader;
import com.mzamorano.phantom.str.StringReader;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.EnumSet;

public class Phantom {
    public static void main(String[] args)  {
        String token = System.getenv("PHANTOM_DISCORD_TOKEN");

        EnumSet<GatewayIntent> intents = EnumSet.of(
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.MESSAGE_CONTENT
        );

        StringReader stringReader = new StringMapReader("strings/all");

        JDA jda = JDABuilder.createLight(token, intents)
                .addEventListeners(new MessageReceivedListener(stringReader))
                .build();

        jda.getRestPing().queue(ping ->
                System.out.println("Logged in with ping: " + ping)
        );
    }
}
