package cn.boommanpro.controller;

import cn.boommanpro.StringUtils;
import cn.boommanpro.generator.TemplateGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class FileController {

    private static final String SUFFIX = ".tar";

    @RequestMapping("downloadTarGz")
    public String downloadTarGz(String projectName, HttpServletRequest request,
                                HttpServletResponse response) throws Exception {


        if (StringUtils.isBlank(projectName)) {
            return null;
        }


        // 如果文件名不为空，则进行下载

        //设置文件路径


        // 如果文件名存在，则进行下载


        // 配置文件下载
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        // 下载文件能正常显示中文
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(projectName + SUFFIX, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 实现文件下载
        byte[] buffer = new byte[1024];
        InputStream fis = TemplateGenerator.generator(projectName);
        BufferedInputStream bis = null;
        try {

            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            System.out.println("Download the song successfully!");
        } catch (Exception e) {
            System.out.println("Download the song failed!");
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
