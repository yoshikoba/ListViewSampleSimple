package com.example.kazukoba.listviewsamplesimple;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kazukoba on 2018/01/30.
 */

public class CsvReader {
    List<ListData> objects = new ArrayList<ListData>();
    public void reader(Context context) {
        AssetManager assetManager = context.getResources().getAssets();
        try {
            // CSVファイルの読み込み
            InputStream inputStream = assetManager.open("data.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferReader.readLine()) != null) {

                //カンマ区切りで１つづつ配列に入れる
                ListData data = new ListData();
                String[] RowData = line.split(",");

                //CSVの左([0]番目)から順番にセット
                data.setId(RowData[0]);
                data.setName(RowData[1]);
                data.setYomi(RowData[2]);
                data.setKentyo(RowData[3]);
                data.setYomi_kentyo(RowData[4]);

                objects.add(data);
            }
            bufferReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}