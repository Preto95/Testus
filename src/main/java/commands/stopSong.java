package commands;

import main.BotUtils;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IVoiceChannel;
import sx.blah.discord.util.audio.AudioPlayer;

import java.util.List;

public class stopSong implements CommandExecutor {

    private AudioPlayer audioP;

    @Override
    public boolean matchCommand(String cmdLine)
    {
        switch (cmdLine)
        {
            case "stopsong":
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
        audioP = AudioPlayer.getAudioPlayerForGuild(event.getGuild());

        if (botVoiceChannel == null || audioP == null)
        {
            BotUtils.sendMessage(event.getChannel(), "Not in a voice channel!");
            return;
        }

        audioP.clear();
        BotUtils.sendMessage(event.getChannel(), "Stopped playing!");
    }
}
