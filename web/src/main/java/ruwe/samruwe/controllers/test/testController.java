package ruwe.samruwe.controllers.test;

import ruwe.samruwe.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class testController {

    // == fields ==

    // == constructors ==

    // == request methods ==

    @GetMapping(ViewNames.HOME)
    public String home() {
        return ViewNames.HOME;
    }
}
