package com.example.kazukoba.listviewsamplesimple;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String JSON_FILE_NAME = "sample_json.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager assetManager = getApplicationContext().getResources().getAssets();
        try {
            // CSVファイルの読み込み
            InputStream inputStream = assetManager.open("shop.json");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            StringBuilder strbuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = bufferReader.readLine()) != null) {
                Log.v("TestData", "inputStr:" + inputStr);
                strbuilder.append(inputStr);
            }
            inputStream.close();
            bufferReader.close();

            JSONObject jsonObject = new JSONObject(strbuilder.toString());
            JSONArray datas = jsonObject.getJSONArray("data");
            Log.d("jsonObject",datas.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    /*
        CsvReader parser = new CsvReader();
        parser.reader(getApplicationContext());
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, 0, parser.objects);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(listViewAdapter);
    */
    }


}
