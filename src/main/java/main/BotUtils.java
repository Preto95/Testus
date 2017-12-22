package main;

import sx.blah.discord.api.*;
import sx.blah.discord.util.*;
import sx.blah.discord.handle.obj.*;

/**
 * Helper class with useful methods
 * @author Preto95
 * @version 1
 */

public class BotUtils {

    static String bot_prefix = "!"; //To filter the commands

    /**
     * creates the client with ClientBuilder
     * @param token Token for the bot
     * @param login login or not
     * @return The discord client
     */
    static IDiscordClient createClient(String token, boolean login)
    {
        return new ClientBuilder().withToken(token).build();
    }

    /**
     * Sends message to the defined channel
     * @param channel Channel for the message
     * @param message Message to send
     */
    public static void sendMessage(IChannel channel, String message)
    {
        RequestBuffer.request(() -> {
           try
           {
               channel.sendMessage(message);
           }
           catch (DiscordException dex)
           {
               System.err.println("Nachricht konnte nicht gesendet werden: ");
               dex.printStackTrace();
           }
        });
    }
}
