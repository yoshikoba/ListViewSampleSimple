package com.example.kazukoba.listviewsamplesimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("test",jsonString());

        try {
            parseJson();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseJson() throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString());

        JSONObject error = jsonObject.getJSONArray("data").getJSONObject(1);

        // "code" の値を取得
        System.out.println(error.getString("shopName"));
        // -> 215

        // "message" の値を取得
        System.out.println(error.getString("area"));
        // -> Bad Authentication data.
    }

    private String jsonString() {
        return "{\"data\":[{\"shopName\":\"讃岐うどん　蔵之介\",\"area\":\"東京都豊島区\"},{\"shopName\":\"讃岐うどん いわい\",\"area\":\"東京都北区\"}]}";
    }
}
