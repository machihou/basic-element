package cn.boommanpro.ip;

import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author BoomMan
 * @mail 59232311@qq.com
 * @CreateTime 13:52 2018/11/17
 * @Param 
 * @return 
 * @Version 1.0
 * @Description City通过构造加载
 *
 **/
public class City {
    private byte[] data;

    private long indexSize;

    public City(String fileName) throws IOException {
        ClassPathResource resource = new ClassPathResource(fileName);
        InputStream in = resource.getInputStream();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = in.read(buffer))) {
            output.write(buffer, 0, n);
        }
        data = output.toByteArray();
        indexSize = IpLocalUtil.bytesToLong(data[0], data[1], data[2], data[3]);
    }


    public City(URI uri) throws IOException {
        Path path = Paths.get(uri);
        data = Files.readAllBytes(path);
        indexSize = IpLocalUtil.bytesToLong(data[0], data[1], data[2], data[3]);
    }

    public String[] find(String ips) throws IPv4FormatException {

        if (!IpLocalUtil.isIPv4Address(ips)) {
            throw new IPv4FormatException();
        }

        long val = IpLocalUtil.ip2long(ips);
        int start = 262148;
        int low = 0;
        int mid = 0;
        int high = new Long((indexSize - 262144 - 262148) / 9).intValue() - 1;
        int pos = 0;
        while (low <= high) {
            mid = new Double((low + high) / 2).intValue();
            pos = mid * 9;

            long s = 0;
            if (mid > 0) {
                int pos1 = (mid - 1) * 9;
                s = IpLocalUtil.bytesToLong(data[start + pos1], data[start + pos1 + 1], data[start + pos1 + 2], data[start + pos1 + 3]);
            }

            long end = IpLocalUtil.bytesToLong(data[start + pos], data[start + pos + 1], data[start + pos + 2], data[start + pos + 3]);
            if (val > end) {
                low = mid + 1;
            } else if (val < s) {
                high = mid - 1;
            } else {

                byte b = 0;
                long off = IpLocalUtil.bytesToLong(b, data[start + pos + 6], data[start + pos + 5], data[start + pos + 4]);
                long len = IpLocalUtil.bytesToLong(b, b, data[start + pos + 7], data[start + pos + 8]);

                int offset = new Long(off - 262144 + indexSize).intValue();

                byte[] loc = Arrays.copyOfRange(data, offset, offset + new Long(len).intValue());

                return new String(loc, Charset.forName("UTF-8")).split("\t", -1);
            }
        }

        return null;
    }

    public static void main(String[] args) throws IOException, IPv4FormatException {
        City city = new City("ip/ipdb.datx");
        String[] strings = city.find("61.48.186.52");
        String join = String.join(",", strings);
        System.out.println(join);
    }
}