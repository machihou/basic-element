package cn.boommanpro;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Utils {

    /**
     * tar打包压缩
     *
     * @param filesPathArray
     *            要压缩的文件的全路径(数组)
     * @param resultFilePath
     *            压缩后的文件全文件名(.tar)
     * @throws Exception
     * @DATE 2018年9月25日 下午12:39:28
     */
    public static boolean tarCompression(String[] filesPathArray, String resultFilePath) throws Exception {
        System.out.println(" tarCompression -> Compression start!");
        FileOutputStream fos = null;
        TarArchiveOutputStream taos = null;
        try {
            fos = new FileOutputStream(new File(resultFilePath));
            taos = new TarArchiveOutputStream(fos);
            for (String filePath : filesPathArray) {
                BufferedInputStream bis = null;
                FileInputStream fis = null;
                try {
                    File file = new File(filePath);
                    TarArchiveEntry tae = new TarArchiveEntry(file);
                    // 此处指明 每一个被压缩文件的名字,以便于解压时TarArchiveEntry的getName()方法获取到的直接就是这里指定的文件名
                    // 以(左边的)GBK编码将file.getName()“打碎”为序列,再“组装”序列为(右边的)GBK编码的字符串
                    tae.setName(new String(file.getName().getBytes("GBK"), "GBK"));
                    taos.putArchiveEntry(tae);
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    int count;
                    byte data[] = new byte[1024];
                    while ((count = bis.read(data, 0, 1024)) != -1) {
                        taos.write(data, 0, count);
                    }
                } finally {
                    taos.closeArchiveEntry();
                    if (bis != null)
                        bis.close();
                    if (fis != null)
                        fis.close();
                }
            }
        } finally {
            if (taos != null)
                taos.close();
            if (fos != null)
                fos.close();

        }
        System.out.println(" tarCompression -> Compression end!");
        return true;
    }

}
