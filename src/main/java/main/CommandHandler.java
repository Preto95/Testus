package main;

import commands.*;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.*;

/**
 * This class matches the arguments to the commands
 * @author Preto95
 * @version 2
 */

public class CommandHandler {

    //private AudioPlayer audioP;
    private Collection<CommandExecutor> allCommands;    //command list

    /**
     * Constructor
     */
    CommandHandler()
    {
        //Register all commands in command list
        allCommands = new ArrayList<>();
        this.allCommands.clear();
        this.allCommands.add(new testCommand());
        this.allCommands.add(new joinVoice());
        this.allCommands.add(new leaveVoice());
        this.allCommands.add(new playSong());
        this.allCommands.add(new stopSong());

    }

    /**
     * Receives the incoming messages and matches to the commands
     * @param event The fired event
     */
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] argArray = event.getMessage().getContent().split(" ");

        if (argArray.length == 0)
            return;

        if (!argArray[0].startsWith(BotUtils.bot_prefix))
            return;

        String command = argArray[0].substring(1);

        List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0);

        for (CommandExecutor exe : this.allCommands)
        {
            if (exe.matchCommand(command))
                exe.callCommand(event, argsList);
        }

    }
}
