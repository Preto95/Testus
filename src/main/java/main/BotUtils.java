package main;

import sx.blah.discord.api.*;
import sx.blah.discord.util.*;
import sx.blah.discord.handle.obj.*;



public class BotUtils {

    static String bot_prefix = "!";

    static IDiscordClient createClient(String token, boolean login)
    {
        return new ClientBuilder().withToken(token).build();
    }

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
