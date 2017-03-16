package rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yws894 on 3/10/17.
 */
@RestController
public class QAController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
