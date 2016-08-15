package bysong.app.domain;

import java.util.List;

/**
 * Created by Lucas on 14/08/2016.
 */
public class Word
{
    public String Writing;
    public Language Language;
    public List<Word> WordsTranslationList;

    public Word(String asWriting, Language aoLanguage)
    {
        Writing = asWriting;
        Language = aoLanguage;
    }

    public List<Word> GetWordsTranslationListByLanguage(Language aoLanguage)
    {
        // TODO: Lucas em 14/08/2016: Comentei quando migrei de C# para Java. Mas a linha abaixo deve ser reescrita em java
        //return WordsTranslationList.FindAll(p => p.Language.Equals(aoLanguage));
        return null;
    }

}
