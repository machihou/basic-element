package cn.boommanpro;

import cn.boommanpro.generator.GeneratorFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * @Title: GZIPUtil.java
 * @Description: gzip文件压缩和解压缩工具类
 * @author LM
 * @date 2009-11-4 下午06:23:29
 * @version V1.0
 */
public class GzipUtil {

    /**
     *
     * @Title: pack
     * @Description: 将一组文件打成tar包
     * @param sources 要打包的原文件数组
     * @param target 打包后的文件
     * @return File    返回打包后的文件
     * @throws
     */
    public static File pack(File[] sources, File target,boolean executable){
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(target);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        TarArchiveOutputStream os = new TarArchiveOutputStream(out);
        for (File file : sources) {
            try {
                TarArchiveEntry tarArchiveEntry = new TarArchiveEntry(file);
                if (executable) {
                    // = (octal) 0100755
                    tarArchiveEntry.setMode(33261);
                }
                os.putArchiveEntry(tarArchiveEntry);
                IOUtils.copy(new FileInputStream(file), os);
                os.closeArchiveEntry();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(os != null) {
            try {
                os.flush();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return target;
    }


    public static InputStream pack(GeneratorFile[] generatorFiles){

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        TarArchiveOutputStream os = new TarArchiveOutputStream(out);
        for (GeneratorFile generatorFile : generatorFiles) {
            try {
                TarArchiveEntry tarArchiveEntry = new TarArchiveEntry(generatorFile.getFileName());


                if (generatorFile.isExecutable()) {
                    // = (octal) 0100755
                    tarArchiveEntry.setMode(33261);
                }


                byte[] bytes = new byte[]{};
                if (StringUtils.notBlank(generatorFile.getContent())) {
                    bytes = generatorFile.getContent().getBytes();
                    tarArchiveEntry.setSize(bytes.length);

                }
                os.putArchiveEntry(tarArchiveEntry);
                IOUtils.copy(new ByteArrayInputStream(bytes), os);
                os.closeArchiveEntry();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(os != null) {
            try {
                os.flush();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return IOConvertUtil.parse(out);
    }

    /**
     *
     * @Title: compress
     * @Description: 将文件用gzip压缩
     * @param  source 需要压缩的文件
     * @return File    返回压缩后的文件
     * @throws
     */
    public static File compress(File source) {
        File target = new File(source.getName() + ".gz");
        FileInputStream in = null;
        GZIPOutputStream out = null;
        try {
            in = new FileInputStream(source);
            out = new GZIPOutputStream(new FileOutputStream(target));
            byte[] array = new byte[1024];
            int number = -1;
            while((number = in.read(array, 0, array.length)) != -1) {
                out.write(array, 0, number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return target;
    }






    public static void main(String[] args) {
        //tar -vxf release_package.tar

        File[] sources = new File[] {new File("E:/startup.sh")};
        File target = new File("E:/release_package.tar");
        compress(pack(sources, target,true));
    }
}

