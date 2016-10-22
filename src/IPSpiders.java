import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by gbw on 16-10-22.
 */
public class IPSpiders
{
    public void GetIPFromKDL()
    {
        IPSpider spider = new IPSpider();
        String url = null;
        try
        {
            FileWriter fw = new FileWriter("proxyIp.txt");
            for (int i = 1; i <= 10; i++)
            {
                url = "http://www.kuaidaili.com/proxylist/" + i + "/";
                spider.GetIP(url, fw);
                System.out.println(url + " down!");
                try
                {
                    Thread thread = Thread.currentThread();
                    final long time = System.currentTimeMillis();
                    final int randi = (int) (time % 10);
                    thread.sleep(1000 * randi);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
