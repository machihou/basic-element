package cn.boommanpro.util;

import cn.boommanpro.generator.GeneratorFile;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;

/**
 * @author BoomManPro
 * @mail boommanpro@gmail.com
 */
@Slf4j
public class GzipUtil {

    public static InputStream pack(GeneratorFile[] generatorFiles) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        TarArchiveOutputStream os = new TarArchiveOutputStream(out);
        try {
            for (GeneratorFile generatorFile : generatorFiles) {

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

            }
        } catch (IOException e) {
            log.error("Exception:",e);
        }finally {
            try {
                os.flush();
                os.close();
            } catch (IOException e) {
                log.error("os Exception:",e);
            }
        }
        return IoConvertUtil.parse(out);
    }

}

