package com.backendlist.IODemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kj
 * @date 2023/7/7
 * @apiNote
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ReadJson {
    private String word;
    private String oldword;
    private String strokes;
    private String pinyin;
    private String radicals;
    private String explanation;
    private String more;
}
