package guru.springframework.springaiintro.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by jt, Spring Framework Guru.
 */
@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final ChatClient chatClient;

    public OpenAIServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @Override
    public String getAnswer(String question) {
//        PromptTemplate promptTemplate = new PromptTemplate(question);
//        Prompt prompt = promptTemplate.create();
//        ChatResponse response = chatClient.call(prompt);
//
//        return response.getResult().getOutput().getContent();
        return chatClient.prompt().user(question).call().content();
    }
}
