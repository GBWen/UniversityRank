import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by gbw on 16-10-22.
 */

public class IPSpider
{
    public void GetIP(String url,FileWriter fw)
    {
        try
        {
            Document document = Jsoup.connect(url).timeout(5000).get();
            // System.out.print(document);
            String cssQuery = "html body div div table tbody tr td";
            int size = document.select(cssQuery).size();
            int index = 0;
            while (index*8+8 <=  size)
            {
                Element ipElement = document.select(cssQuery).get(index*8);
                String ip = ipElement.text();
                // System.out.println(ip);
                Element portElement = document.select(cssQuery).get(index*8+1);
                String port = portElement.text();
                // System.out.println(port);
                index++;
                fw.write(ip + ":" + port + "\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}