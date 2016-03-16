package sonamsinha.rssreader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class RSSActivity extends AppCompatActivity {
    List title;
    List description;
    TextView src;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);
        src = (TextView)findViewById(R.id.textFromWeb);



    }
    public void fetch(View v){
        Downloader downloader = new Downloader();
        downloader.execute("http://rss.cnn.com/rss/cnn_topstories.rss");
        try{
            src.setText(downloader.get());
        }
        catch (Exception ex){
            Log.e("Error in Thread", ex.toString());
        }
    }

}
