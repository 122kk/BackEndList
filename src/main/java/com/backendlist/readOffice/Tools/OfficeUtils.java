package com.backendlist.readOffice.Tools;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.backendlist.ListTools.R;
import com.backendlist.readOffice.Entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author kj
 * @date 2023/4/28
 * @apiNote office的工具类
 */
@Slf4j
public class OfficeUtils {
        //上传文件
    public static R<String> updateFiles(MultipartFile file){
        log.info("Updating files:{}",file.getContentType());


        ExcelReader reader = null;
        try {
            reader = ExcelUtil.getReader(file.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        reader.addHeaderAlias("序号","id");
        reader.addHeaderAlias("学号","StudentId");
        reader.addHeaderAlias("姓名","name");
        reader.addHeaderAlias("班级","classes");
        reader.addHeaderAlias("校区","school");
        List<Student> students = reader.readAll(Student.class);

        for (Student s:students){
            System.out.println(s);
        }
        if (ObjectUtils.isEmpty(students)){
            return R.success(200,"导入成功");
        }
        return R.error(500,"上传失败");
    }

    public void exportStudentInfos(HttpServletResponse response){

    }

}
