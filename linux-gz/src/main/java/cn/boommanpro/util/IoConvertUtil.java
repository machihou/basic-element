package cn.boommanpro.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author BoomManPro
 * @mail boommanpro@gmail.com
 */
public class IoConvertUtil {

    /**
     * ByteArrayOutputStream -> ByteArrayInputStream
     */
    public static ByteArrayInputStream parse(final ByteArrayOutputStream out) {
        return new ByteArrayInputStream(out.toByteArray());
    }
}
