package Kodlama.io.Devs.dataAccess.abstracts;

import Kodlama.io.Devs.entities.concretes.Language;

import java.util.List;

public interface LanguageRepository {
    List<Language> getAll();
    void add(Language language);
    List<Language> delete(Language language) throws Exception;
    void update();
    String fetch(int id);
}
