package ma.toubali.ebankbot.discord;

import com.zgamelogic.discord.annotations.DiscordController;
import com.zgamelogic.discord.annotations.DiscordMapping;
import ma.toubali.ebankbot.agents.EbankAIAgent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.ai.chat.prompt.Prompt;

@DiscordController
public class DiscordBot {
    private EbankAIAgent ebankAIAgent;


    public DiscordBot(EbankAIAgent ebankAIAgent) {
        this.ebankAIAgent = ebankAIAgent;
    }

    @DiscordMapping
    private void perform(MessageReceivedEvent event){
        if (event.getAuthor().isBot()) return;
        String query = event.getMessage().getContentRaw();
        //System.out.println("Query: " + query);
        String response = ebankAIAgent.chat(new Prompt(query));
        //System.out.println("Response: " + response);

        event.getChannel().sendMessage(response).queue();
    }
}
