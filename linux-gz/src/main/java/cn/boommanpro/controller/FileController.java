package cn.boommanpro.controller;

import cn.boommanpro.generator.TemplateGenerator;
import cn.boommanpro.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author BoomManPro
 * @mail boommanpro@gmail.com
 */
@Slf4j
@Controller
public class FileController {

    private static final String SUFFIX = ".tar";

    /**
     * test:http://10.0.75.1:8088/downloadTarGz?projectName=project-hello
     */
    @RequestMapping("downloadTarGz")
    public void downloadTarGz(@RequestParam String projectName, HttpServletResponse response) {
        // 如果文件名不为空，则进行下载
        if (StringUtils.isBlank(projectName)) {
            return;
        }
        //配置Header下载
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        // 下载文件能正常显示中文
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(projectName + SUFFIX, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            log.error("downloadTarGz Exception:", e);
        }

        // 实现文件下载
        byte[] buffer = new byte[1024];
        InputStream fis = TemplateGenerator.generator(projectName);
        try (BufferedInputStream bis = new BufferedInputStream(fis)) {
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            log.info("Download the song successfully!");
        } catch (Exception e) {
            log.error("Download fail!", e);

        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                log.error("Download fail!", e);
            }
        }
    }
}
