package bysong.app.domain;

import java.util.List;

/**
 * Created by Lucas on 14/08/2016.
 */
public class Word {

    public String writing;
    public Language language;
    public List<Word> wordsTranslationList;

    public Word(String writing, Language language) {

        this.writing = writing;
        this.language = language;

    }

    public List<Word> getWordsTranslationListByLanguage(Language language) {

        // TODO: Lucas em 14/08/2016: Comentei quando migrei de C# para Java. Mas a linha abaixo deve ser reescrita em java
        //return WordsTranslationList.FindAll(p => p.Language.Equals(aoLanguage));
        return null;

    }

}
