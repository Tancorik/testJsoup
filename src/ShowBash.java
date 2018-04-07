import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class ShowBash {
    public final String URL = "https://bash.im/";
    ArrayList<Element> mElementsOfSite;
    Document mDocument=null;
    String[] mText, mDate, mNumber;

    ShowBash(){
        try {
            mDocument = Jsoup.connect(URL).get();
        }catch(IOException e){
            System.out.println("Проблемма соединения с сайтом!");
        }

        readElementsOfText();
        readElementsOfData();
        readElementsOfNumber();
    }

    private void readElementsOfText(){
        mElementsOfSite = mDocument.select("div.text");
        mText = new String[mElementsOfSite.size()];

        int i = 0;
        for (Element element:mElementsOfSite){
            String str = element.toString();
            str = str.substring(str.indexOf('>')+1, str.lastIndexOf('<'));
            str = str.replaceAll("<br>", "");
            mText[i++]=str;
        }

    }

    private void readElementsOfData(){
        mElementsOfSite.clear();
        mElementsOfSite = mDocument.select("span[class=date]");
        mDate = new String[mElementsOfSite.size()];
        int i = 0;
        for (Element element:mElementsOfSite){
            String str = element.toString();
            str = str.substring(str.indexOf('>')+1, str.lastIndexOf('<'));
            mDate[i++] = str;
        }
    }

    private void readElementsOfNumber(){
        mElementsOfSite.clear();
        mElementsOfSite = mDocument.select("a[class=id]");
        mNumber = new String[mElementsOfSite.size()];
        int i = 0;
        for (Element element: mElementsOfSite){
            String str = element.toString();
            str = str.substring(str.indexOf('>')+1, str.lastIndexOf('<'));
            mNumber[i++] = str;
        }
    }


    public void show(){
        for (int i = 0; i < mText.length; i++){

            System.out.println(mDate[i]+ "    "+ mNumber[i]);
            System.out.println(mText[i]);
        }
    }


}
