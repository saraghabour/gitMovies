package com.example.ahmedsadek.movies.DataFregmant;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.ahmedsadek.movies.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class AsyncClass extends AsyncTask<String,String,ArrayList<HashMap<String,String>>> {

    private ProgressDialog dialog;
    private ListActivity listActivity;
    private ListView listView;
    private Context context;
    private String vurl = "";
    private String img , txtS ;
    private ArrayList list ;
    JSONArray jsonArray = null;

    // TextView textViewDis ,textViewURL;



    @Override
    protected void onPreExecute() {
        dialog.setMessage("progress is working");
        dialog.show();
    }
    @Override
    protected void onPostExecute(ArrayList<HashMap<String,String>> jsonList) {


    }

    @Override
    protected ArrayList<HashMap<String, String>> doInBackground(String... params) {

        Log.e("as", "apear if you work ,please :'( ");
        try {
            JsonParser parser = new JsonParser();
            JSONObject jsonObject = parser.getJsonFromURl(vurl);
            jsonArray = jsonObject.getJSONArray("Users");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String disply = object.getString("display");
                String id1 =object.getString("id");
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(img, disply);
                map.put(txtS,id1);
                list.add(map);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
            /*catch (NullPointerException e){
                e.printStackTrace();
            }*/
        return list;
    }

}
