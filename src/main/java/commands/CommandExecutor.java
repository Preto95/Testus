package commands;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.List;

/**
 * This is the Interface for all the commands this bot can execute
 * @author Preto95
 * @version 1
 */

public interface CommandExecutor {
    /**
     * Matches the input to an existing command
     * @param cmdLine The command
     *
     */
    boolean matchCommand(String cmdLine);

    /**
     * Calls the command to execute
     * @param event The fired event
     * @param args The arguments for the command
     */
    void callCommand(MessageReceivedEvent event, List<String> args);

}
