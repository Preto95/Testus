package commands;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IVoiceChannel;

import java.util.List;

/**
 * The bot joins your voice channel
 * @author Preto95
 * @version 1
 */

public class joinVoice implements CommandExecutor {

    @Override
    public boolean matchCommand(String cmdLine)
    {
        switch (cmdLine)
        {
            case "joinvoice":
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
        IVoiceChannel userVoiceChannel = event.getAuthor().getVoiceStateForGuild(event.getGuild()).getChannel();

        if (userVoiceChannel == null)
            return;

        userVoiceChannel.join();
    }
}
