package sonamsinha.rssreader;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sonamsinha on 3/13/16.
 */
public class Downloader extends AsyncTask<String, Void, String>{
    /**Context context;
    String address =

    public  Downloader(Context context){
        this.context = context;
    }

    @Override
    protected  void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {

    }*/

    @Override
    protected String doInBackground(String... urls) {

        String result = null;
        try{
            URL url = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = reader.readLine())!= null){
                result =result + line;
            }
            connection.disconnect();
        }
        catch (Exception ex){
            Log.e("Error Fetching",ex.toString());
        }
        return result;
    }
}
