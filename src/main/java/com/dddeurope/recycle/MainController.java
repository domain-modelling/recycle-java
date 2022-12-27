package com.dddeurope.recycle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/validate")
    public String validate() {
        return "Hi!";
    }
}
