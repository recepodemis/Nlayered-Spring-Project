package Kodlama.io.Devs.business.concretes;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LanguageManager implements LanguageService{

    private LanguageRepository languageRepository;

    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public void add(Language language) throws Exception {
        if (language.getName().equals(null) || language.getName().isEmpty()){
            throw new Exception("Data have to have a name");
        }
        for (Language language1: languageRepository.getAll()){
            if (Objects.equals(language1.getName(), language.getName()) ||
                    Objects.equals(language1.getId(),language.getId())) {
                throw new Exception("Data is already exist");
            }
        }
            languageRepository.add(language);
    }

    @Override
    public List<Language> delete(Language language) throws Exception  {

        return languageRepository.delete(language);

    }
    @Override
    public void update() {

    }

    @Override
    public String fetch(int id) {
        return languageRepository.fetch(id);
    }
}
