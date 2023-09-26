package com.example.animeWorld.control;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin("http://localhost:4200/")
public class controlleuInutile {

    @GetMapping("/home")
    public ResponseEntity<String> getHome() {
        return ResponseEntity.ok("home"); // Assicurati che ci sia un template "home.html" nella cartella dei template.
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about"; // Assicurati che ci sia un template "about.html" nella cartella dei template.
    }

    @GetMapping("/help")
    public String getHelp() {
        return "help"; // Assicurati che ci sia un template "help.html" nella cartella dei template.
    }
}
