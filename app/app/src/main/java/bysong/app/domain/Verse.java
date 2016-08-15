package bysong.app.domain;

import java.util.List;

/**
 * Created by Lucas on 14/08/2016.
 */
public class Verse
{
    private int iiVerseNumber;
    //        private string isEnglishText;
    //        private string isPortugueseText;
    private int iiStartTime;
    private int iiEndTime;
    public List<Word> WordsList;
    public List<Verse> BasicTranslations;


    public Verse(int aiVerseNumber, List<Word> aoWordsList, int aiStartTime, int aiEndTime)
    {
        iiVerseNumber = aiVerseNumber;
        WordsList = aoWordsList;
        //isPortugueseText = asPortugueseMode;
        iiStartTime = aiStartTime;
        iiEndTime = aiEndTime;

    }

    public String getOriginalWriting() {

        String lsOriginalWriting = "";
        for (Word loWord : WordsList) {
            lsOriginalWriting += loWord.Writing + " ";
        }
        lsOriginalWriting = lsOriginalWriting.trim();

        return lsOriginalWriting;

    }


    public int VerseNumber;

    public int StartTime;

    public int EndTime;

    private String getEncriptedText(String asText)
    {/*
            string lsWords[] = asText.split(" ");
            string lsNewText = "";

            for (string lsWord : lsWords)
            {
                lsWord = lsWord.replaceAll("(?s).", "*");
                lsNewText += lsWord + " ";
            }

            return lsNewText;*/
        return null;
    }
    /*
    public LyricsAnalysisResult validateEnglishInputText(string asEnglishInputText)
    {
        string lsCleanEnglishInputText = this.getCleanText(asEnglishInputText);
        string lsCleanEnglishOriginalText = this.getCleanText(isEnglishText);

        LyricsAnalysisResult loLyricsAnalysisResult = new LyricsAnalysisResult();
        loLyricsAnalysisResult.setInputVerse(asEnglishInputText);
        loLyricsAnalysisResult.setOriginalVerse(isEnglishText);
        if (!lsCleanEnglishInputText.toLowerCase().equals(lsCleanEnglishOriginalText.toLowerCase()))
        {

            List<Integer> loListWrongWords = new ArrayList<Integer>();
            loListWrongWords.add(2);
            loListWrongWords.add(4);

            loLyricsAnalysisResult.setValidationSuccess(false);
            loLyricsAnalysisResult.setListWrongWords(loListWrongWords);

            return loLyricsAnalysisResult;

        }

        loLyricsAnalysisResult.setValidationSuccess(true);
        return null;
    }

    public LyricsAnalysisResult validatePortugueseInputText(string asPortugueseInputText)
    {
        string lsCleanPortugueseInputText = this.getCleanText(asPortugueseInputText);
        string lsCleanPortugueseOriginalText = this.getCleanText(isPortugueseText);

        LyricsAnalysisResult loLyricsAnalysisResult = new LyricsAnalysisResult();
        loLyricsAnalysisResult.setInputVerse(asPortugueseInputText);
        loLyricsAnalysisResult.setOriginalVerse(isPortugueseText);
        if (!lsCleanPortugueseInputText.toLowerCase().equals(lsCleanPortugueseOriginalText.toLowerCase()))
        {

            List<Integer> loListWrongWords = new ArrayList<Integer>();
            loListWrongWords.add(2);
            loListWrongWords.add(4);

            loLyricsAnalysisResult.setValidationSuccess(false);
            loLyricsAnalysisResult.setListWrongWords(loListWrongWords);

            return loLyricsAnalysisResult;

        }

        loLyricsAnalysisResult.setValidationSuccess(true);
        return null;
    }
    */
    private String getCleanText(String asText)
    {
        String lsCleanText = asText;

        lsCleanText = lsCleanText.toLowerCase();
        lsCleanText = lsCleanText.trim();

        return lsCleanText;
    }
}
