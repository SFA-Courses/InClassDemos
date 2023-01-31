import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class Favorite {
    private String videoName;
    private Date date;
    private URL url;

    public Favorite(String name, String address) throws MalformedURLException {
        this.videoName = name;
        this.url = new URL(address);
        this.date = new Date();
    }

    @Override
    public String toString() {
        String s = this.videoName + " " + this.date + " \n ";
        s = s + url;
        return s;
    }
    
}
