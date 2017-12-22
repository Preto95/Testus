package main;

import sx.blah.discord.api.IDiscordClient;
import java.lang.ClassLoader;
import java.io.*;
import java.util.Properties;

public class Main {

    public static void main (String[] args)
    {
        String token;

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        try
        {
            InputStream inputStream = classLoader.getResourceAsStream("discord.properties");
            Properties props = new Properties();
            props.load(inputStream);

            token = props.getProperty("token");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            token = "00000000000000000000000000000000000000000000";
        }

        IDiscordClient cli = BotUtils.createClient(token, true);

        cli.getDispatcher().registerListener(new CommandHandler());

        cli.login();
    }
}
