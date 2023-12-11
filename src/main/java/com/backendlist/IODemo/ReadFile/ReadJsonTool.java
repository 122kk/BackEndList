package com.backendlist.IODemo.ReadFile;

import com.backendlist.IODemo.Entity.ReadJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author kj
 * @date 2023/7/7
 * @apiNote
 */
public class ReadJsonTool {


    public static void main(String[] args) {
        Gson gson = new Gson();
        String filePath = "C:\\Users\\kj\\Desktop\\桌面文件\\下载文件\\chinese-xinhua-master\\data\\word.json";

        try (FileReader reader = new FileReader(filePath)) {
            // 使用 Gson 解析 JSON 数据到 List
            Type listType = new TypeToken<List<ReadJson>>() {}.getType();
            List<ReadJson> dataList = gson.fromJson(reader, listType);

            // 打印输出列表中的数据
            // System.out.println(dataList.get(0));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
