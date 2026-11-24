package ma.toubali.ebankbot.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

@Service
public class EbankAIAgent {
    private ChatClient chatClient;

    public EbankAIAgent(ChatClient.Builder chatClient,ToolCallbackProvider tools, ChatMemory chatMemory) {
        this.chatClient = chatClient
                .defaultSystem("""
                        Vous un assistant qui se charge de répondre aux question
                        de l'utilisateur à propos des clients et des comptes bancaires, en fonction du contexte fourni.
                        Si aucun contexte n'est fourni, répond avec JE NE SAIS PAS
                        """)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultTools(tools)
                .build();
    }


    public String chat(Prompt prompt){
        return chatClient.prompt(prompt)
                .advisors(a->a.param(ChatMemory.CONVERSATION_ID,"C1"))
                .call().content();
    }

    public Flux<String> chatStream(Prompt prompt){
        return chatClient.prompt(prompt)
                .advisors(a->a.param(ChatMemory.CONVERSATION_ID,"C1"))
                .stream().content();
    }
}
