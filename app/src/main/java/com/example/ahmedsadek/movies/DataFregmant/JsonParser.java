package com.example.ahmedsadek.movies.DataFregmant;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonParser {


    static InputStream inputStream = null;
    static JSONObject jsonOb = null ;
    static String json ="";

    public JsonParser(){
    }

    public JSONObject getJsonFromURl(String url)  {

        try {
            Log.e("as", "apear if you work ,please  ");
            StringBuilder stringBuilder = new StringBuilder();
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpGet);
            Log.e("as","apear if you work :(  ");
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode==200) {
                Log.e("as","apear if you work :(  ");
                HttpEntity entity = response.getEntity();
                //  String var = EntityUtils.toString(entity);
                //   JSONArray jsonArray = new JSONArray(var);
                InputStream iS = entity.getContent();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(iS ,"iso-8859-1"), 8);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                iS.close();
                json = stringBuilder.toString();
            }

        } catch (ClientProtocolException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            jsonOb =new JSONObject(json);
        } catch (JSONException e) {
            //Log.e(TAG, "Error parsing data " + e.toString());
        }
        return jsonOb ;
    }
}
