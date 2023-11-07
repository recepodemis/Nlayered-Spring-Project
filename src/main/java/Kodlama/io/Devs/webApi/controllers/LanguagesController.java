package Kodlama.io.Devs.webApi.controllers;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Language language) throws Exception {
        languageService.add(language);
        System.out.println(language.getName() + " added.");
    }

    @DeleteMapping("/delete")
    public List<Language> delete(@RequestBody Language language) throws Exception {
        return languageService.delete(language);
    }

    public void update() {

    }

    @PostMapping("/fetch")
    public String fetch(@RequestParam int id) {
        return languageService.fetch(id);
    }

}
