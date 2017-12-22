package commands;

import main.BotUtils;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.List;

/**
 * This is a simple test command
 * @author Preto95
 * @version 1
 *
 */

public class testCommand implements CommandExecutor {

    @Override
    public boolean matchCommand(String cmdLine) {
        switch (cmdLine)
        {
            case "test":
            {
                return true;
            }
            default:
            {
                return false;
            }
        }

    }

    @Override
    public void callCommand(MessageReceivedEvent event, List<String> args)
    {
        BotUtils.sendMessage(event.getChannel(), "You ran this test program with the arguments: ");

        for (String s : args)
        {
            BotUtils.sendMessage(event.getChannel(), s);
        }
    }
}
