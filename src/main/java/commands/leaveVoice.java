package commands;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IVoiceChannel;

import java.util.List;

/**
 * Leaves the voice channel
 * @author Preto95
 * @version 1
 */

public class leaveVoice implements CommandExecutor {

    @Override
    public boolean matchCommand(String cmdLine) {
        switch (cmdLine)
        {
            case "leavevoice":
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
        IVoiceChannel botVoiceChannel = event.getClient().getOurUser().getVoiceStateForGuild(event.getGuild()).getChannel();

        if (botVoiceChannel == null)
            return;

        botVoiceChannel.leave();
    }
}