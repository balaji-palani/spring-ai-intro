package guru.springframework.springaiintro.controller;


import guru.springframework.springaiintro.services.OpenAIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SpringAIController {

    @Autowired
    OpenAIService openAIService;

    @GetMapping("/hello")
    public String getAnswer(String question) {
        return "Welcome to Spring AI";
    }

    @PostMapping("/hello")
    public ResponseEntity<String> postAnswer(@RequestBody String question) {
     // return openAIService.getAnswer(question);

        try {
            log.info("Received question: {}", question);
            String answer = openAIService.getAnswer(question);
            return ResponseEntity.ok(answer);
        } catch (Exception e) {
            log.error("Error processing question", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing your request.");
        }
    }
}
