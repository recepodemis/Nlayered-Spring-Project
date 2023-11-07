package Kodlama.io.Devs.dataAccess.concretes;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

    private List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<>();
        languages.add(new Language(1,"C Programming"));
        languages.add(new Language(2,"Pyhton"));
        languages.add(new Language(3,"Java"));
        languages.add(new Language(4,"JavaScript"));
    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public void add(Language language) {
        languages.add(language);
    }


   @Override
   public List<Language> delete(Language language) throws Exception {
       boolean removed = false;
       for (Iterator<Language> iterator = languages.iterator(); iterator.hasNext(); ) {
           Language l = iterator.next();
           if (l.getId() == language.getId()) {
               iterator.remove();
               removed = true;
               break;
           }
       }
       if (!removed) {
           throw new Exception("There is not any language in the database with id: " + language.getId());
       }
       return languages;
   }

    @Override
    public void update() {

    }

    @Override
    public String fetch(int id) {
        for (Language l:languages) {
            if(l.getId() == id){
                return l.getName();
            }
        }
        return "there isn't any element which have that id";
    }
}
