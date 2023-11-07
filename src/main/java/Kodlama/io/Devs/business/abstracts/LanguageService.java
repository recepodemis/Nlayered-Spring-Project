package Kodlama.io.Devs.business.abstracts;

import Kodlama.io.Devs.entities.concretes.Language;

import java.util.List;

public interface LanguageService {

    List<Language> getAll();
    void add(Language language) throws Exception;
    public List<Language> delete(Language language) throws Exception;
    void update();
    String fetch(int id);

}
