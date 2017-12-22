package commands;

import main.BotUtils;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IVoiceChannel;
import sx.blah.discord.util.audio.AudioPlayer;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Plays the defined song
 * @author Preto95
 * @version 1
 */

public class playSong implements CommandExecutor {

    private AudioPlayer audioP;

    @Override
    public boolean matchCommand(String cmdLine)
    {
        switch (cmdLine)
        {
            case "playsong":
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

        if(botVoiceChannel == null)
        {
            BotUtils.sendMessage(event.getChannel(), "Not in a voice channel!");
            return;
        }

        String search = String.join(" ", args);

        if(audioP == null)
            audioP = AudioPlayer.getAudioPlayerForGuild(event.getGuild());

        File[] songDir = new File("music")
                .listFiles( file -> file.getName().contains(search));

        if (songDir == null || songDir.length == 0)
        {
            BotUtils.sendMessage(event.getChannel(), "Can not find track!");
            return;
        }
        audioP.clear();

        try
        {
            audioP.queue(songDir[0]);
            audioP.setLoop(true);
        }
        catch (IOException | UnsupportedAudioFileException e)
        {
            BotUtils.sendMessage(event.getChannel(), "This track is not playable!");
            e.printStackTrace();
        }

        BotUtils.sendMessage(event.getChannel(), "Now playing: " + songDir[0].getName());
    }
}
