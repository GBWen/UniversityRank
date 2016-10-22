import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by gbw on 16-10-22.
 */

public class Main
{
    public static void main(String args[])
    {
//        IPSpiders ipSpiders = new IPSpiders();
//        ipSpiders.GetIPFromKDL();
        ArrayList<String> IP = new ArrayList<String>();
        ArrayList<String> Port = new ArrayList<String>();
        try
        {
            FileReader fr = new FileReader("proxyIp.txt");
            BufferedReader br = new BufferedReader(fr);
            while (br.ready())
            {
                String Str = br.readLine();
                int index = Str.indexOf(':');
                String ip = Str.substring(0,index);
                String port = Str.substring(index+1,Str.length());
                // System.out.println(ip);
                // System.out.println(port);
                IP.add(ip);
                Port.add(port);
            }
            System.setProperty("http.maxRedirects", "50");
            System.getProperties().setProperty("proxySet", "true");
            System.getProperties().setProperty("http.proxyHost", IP.get(1));
            System.getProperties().setProperty("http.proxyPort", Port.get(1));
            Document document = Jsoup.connect("http://www.baidu.com/s?pn="+10+"&wd=ip/").timeout(5000).get();
            System.out.print(document);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
