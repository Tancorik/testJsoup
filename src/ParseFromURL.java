import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ParseFromURL {
    String mURL = "https://bash.im/";
   // String mURL = "https://bash.im/index/1353";

    public void show() {
        Document document = null;
        try {
            document = Jsoup.connect(mURL).get();
        }catch(IOException e){
            e.printStackTrace();
        }

        //System.out.println(document.toString());

        //System.out.println("\n\n");

        //Elements element = document.getElementsByAttribute(".text");
        //Elements element = document.select("div.text");
        //Elements element = document.select("link[rel=next]");

        //ArrayList<Element> elementsArrayList = document.select("div.text");

        //ArrayList<Element> elementsArrayList = document.select("span[class=date]");
        ArrayList<Element> elementsArrayList = document.select("a[class=id]");

        Element element = elementsArrayList.get(40);



        //System.out.println(elementsArrayList.toString());
        //System.out.println(element);
        System.out.println(elementsArrayList.size());
        System.out.println(element);

        String str = element.toString();
        //str = str.replaceAll("<div class=\"text\">","");
        //str = str.replaceAll("</div>", "");

        str = str.substring(str.indexOf('>')+1,str.lastIndexOf('<'));
        str = str.replaceAll("<br>", "");

        System.out.println(str);
    }
}
