package com.backendlist.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.backendlist.readOffice.Entity.Student;
import com.backendlist.readOffice.Tools.OfficeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kj
 * @date 2023/4/30
 * @apiNote 读写Excel
 */
@RestController
@RequestMapping("/offices")
@Api(tags = "读取office内容接口", description = "读取office内容接口")
public class OfficeController {
    @PostMapping("upload")
    @ApiOperation("读取Excel")
    public void upFiles(MultipartFile file){
        OfficeUtils.updateFiles(file);
    }

    //表格导出接口
    @GetMapping("/export")
    @ApiOperation("导出模板Excel")
    public void export(HttpServletResponse response) throws IOException {
        //查询所有用户
        //List<User> list= userService.list();
        List<Student> list=new ArrayList<>();
        Student student=new Student();
        list.add(student);
        //在内存操作，写到浏览器
        ExcelWriter writer= ExcelUtil.getWriter(true);

        //自定义标题别名
        writer.addHeaderAlias("id","序号");
        writer.addHeaderAlias("StudentId","学号");
        writer.addHeaderAlias("name","姓名");
        writer.addHeaderAlias("classes","班级");
        writer.addHeaderAlias("school","校区");

        //默认配置
        writer.write(list,true);
        //设置content—type
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset:utf-8");

        //设置标题
        String fileName= null;
        ServletOutputStream outputStream=null;
        try {
            fileName = URLEncoder.encode("用户信息","UTF-8");
            //Content-disposition是MIME协议的扩展，MIME协议指示MIME用户代理如何显示附加的文件。
            response.setHeader("Content-Disposition","attachment;filename="+fileName+".xlsx");
            outputStream= response.getOutputStream();

            //将Writer刷新到OutPut
            writer.flush(outputStream,true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            outputStream.close();
            writer.close();
        }



    }
}
