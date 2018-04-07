import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseFromString {

    String mHTML = "<html><head><title>First parse</title></head>\"\n" +
            "  + \"<body><p>Parsed HTML into a doc.</p><p>Second Text intro P</p></body></html>";

    public void show(){

        Document document = Jsoup.parse(mHTML);
        System.out.println(document);

        System.out.println("\n\n");

        Element element = document.body();
        System.out.println(element.toString());

        System.out.println("\n\n");

        Elements elementP = document.getElementsByTag("p");
        System.out.println(elementP);

        System.out.println("\n\n");

        String text = elementP.html();
        text = text.substring(0,text.indexOf('\n'));
        System.out.println(text);



    }
}
