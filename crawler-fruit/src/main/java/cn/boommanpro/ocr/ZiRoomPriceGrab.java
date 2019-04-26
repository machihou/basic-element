package cn.boommanpro.ocr;

import cc11001100.ocr.OcrUtil;
import cc11001100.ocr.clean.SingleColorFilterClean;
import cc11001100.ocr.split.ImageSplitImpl;
import cc11001100.ocr.util.ImageUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.JSON.parseObject;
import static java.util.stream.Collectors.joining;

/**
 * 自如的房租价格用图片显示，这是一个从图片中解析出价格的例子
 *
 *
 * <a>http://www.ziroom.com/z/vr/250682.html</a>
 *
 * @author CC11001100
 */
@Log4j2
public class ZiRoomPriceGrab {


    private static SingleColorFilterClean singleColorFilterClean = new SingleColorFilterClean(0XFFA000);
    private static ImageSplitImpl imageSplit = new ImageSplitImpl();
    private static Map<Integer, String> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put(-2132100338, "0");
        dictionaryMap.put(-458583857, "1");
        dictionaryMap.put(913575273, "2");
        dictionaryMap.put(803609598, "3");
        dictionaryMap.put(-1845065635, "4");
        dictionaryMap.put(1128997321, "5");
        dictionaryMap.put(-660564186, "6");
        dictionaryMap.put(-1173287820, "7");
        dictionaryMap.put(1872761224, "8");
        dictionaryMap.put(-1739426700, "9");
    }

    public static JSONObject getHouseInfo(String id, String houseId) {
        String url = "http://www.ziroom.com/detail/info?id=" + id + "&house_id=" + houseId;
        String respJson = downloadText(url);
        if (respJson == null) {
            throw new RuntimeException("response null, id=" + id + ", houseId=" + houseId);
        }
        return parseObject(respJson);
    }

    private static int extractPrice(JSONObject houseInfo) throws IOException {
        JSONArray priceInfo = houseInfo.getJSONObject("data").getJSONArray("price");
        String priceRawImgUrl = "http:" + priceInfo.getString(0);
//        System.out.println("priceRawImgUrl: " + priceRawImgUrl);
        JSONArray priceImgCharIndexArray = priceInfo.getJSONArray(2);
        System.out.println("priceImgCharIndexArray: " + priceImgCharIndexArray);
        BufferedImage img = downloadImg(priceRawImgUrl);
        if (img == null) {
            throw new RuntimeException("img download failed, url=" + priceRawImgUrl);
        }
        List<BufferedImage> priceCharImgList = extractNeedCharImg(img, priceImgCharIndexArray);
        String priceStr = priceCharImgList.stream().map(charImg -> {
            int charImgHashCode = ImageUtil.imageHashCode(charImg);
            return dictionaryMap.get(charImgHashCode);
        }).collect(joining());
        return Integer.parseInt(priceStr);
    }


    public static int extractPrice(String url,String priceIndex) {
        String priceRawImgUrl = "http:" + url;
//        System.out.println("priceRawImgUrl: " + priceRawImgUrl);
        BufferedImage img = null;
        try {
            img = downloadImg(priceRawImgUrl);
        } catch (IOException e) {
            System.out.println("url: "+url+" 下载失败!");
        }
        String text;
        JSONArray priceImgCharIndexArray = JSON.parseArray(priceIndex);
        if (img == null) {
            throw new RuntimeException("img download failed, url=" + priceRawImgUrl);
        }
        List<BufferedImage> priceCharImgList = extractNeedCharImg(img, priceImgCharIndexArray);
        String priceStr = priceCharImgList.stream().map(charImg -> {
            int charImgHashCode = ImageUtil.imageHashCode(charImg);
            return dictionaryMap.get(charImgHashCode);
        }).collect(joining());
        return Integer.parseInt(priceStr);
    }
    // 因为价格通常是4位数，而返回的图片有10位数（0-9），所以第一步就是将价格字符抠出来
    // （或者也可以先全部识别为字符串然后从字符串中按下标选取）
    private static List<BufferedImage> extractNeedCharImg(BufferedImage img, JSONArray charImgIndexArray) {
        List<BufferedImage> allCharImgList = imageSplit.split(singleColorFilterClean.clean(img));
        List<BufferedImage> needCharImg = new ArrayList<>();
        for (int i = 0; i < charImgIndexArray.size(); i++) {
            int index = charImgIndexArray.getInteger(i);
            needCharImg.add(allCharImgList.get(index));
        }
        return needCharImg;
    }

    // 因为价格通常是4位数，而返回的图片有10位数（0-9），所以第一步就是将价格字符抠出来
    // （或者也可以先全部识别为字符串然后从字符串中按下标选取）
    private static List<BufferedImage> extractNeedCharImg(BufferedImage img, int[] indexArray) {
        List<BufferedImage> allCharImgList = imageSplit.split(singleColorFilterClean.clean(img));
        List<BufferedImage> needCharImg = new ArrayList<>();
        for (int i = 0; i < indexArray.length; i++) {
            int index = indexArray[i];
            needCharImg.add(allCharImgList.get(index));
        }
        return needCharImg;
    }

    private static byte[] downloadBytes(String url) {
        for (int i = 0; i < 3; i++) {
            long start = System.currentTimeMillis();
            try {
                byte[] responseBody = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
                        .ignoreContentType(true)
                        .execute()
                        .bodyAsBytes();
                long cost = System.currentTimeMillis() - start;
//                log.info("request ok, tryTimes={}, url={}, cost={}", i, url, cost);
                return responseBody;
            } catch (Exception e) {
                long cost = System.currentTimeMillis() - start;
                log.error("request failed, tryTimes={}, url={}, cost={}, cause={}", i, url, cost, e.getMessage());
            }
        }
        return null;
    }

    private static String downloadText(String url) {
        byte[] respBytes = downloadBytes(url);
        if (respBytes == null) {
            return null;
        } else {
            return new String(respBytes);
        }
    }

    private static BufferedImage downloadImg(String url) throws IOException {
        byte[] imgBytes = downloadBytes(url);
        if (imgBytes == null) {
            return null;
        }
        return ImageIO.read(new ByteArrayInputStream(imgBytes));
    }

    private static void init() {
//      OcrUtil ocrUtil = new OcrUtil().setImageClean(new SingleColorFilterClean(0XFFA000));
//      ocrUtil.init("H:/test/crawler/ziroom/raw/", "H:/test/crawler/ziroom/char/");
        OcrUtil.genAndPrintDictionaryMap("H:/test/crawler/ziroom/char/", "dictionaryMap", filename -> filename.substring(0, 1));
    }

    public static void main(String[] args) throws IOException {
//      init();

        JSONObject o = getHouseInfo("61718150", "60273500");
        int price = extractPrice(o);
        System.out.println("price: " + price); // 1930

//      output:
//      2018-12-15 20:24:59.206 INFO  cc11001100.crawler.ziroom.ZiRoomPriceGrab 103 downloadBytes - request ok, tryTimes=0, url=http://www.ziroom.com/detail/info?id=61718150&house_id=60273500, cost=559
//      priceRawImgUrl: http://static8.ziroom.com/phoenix/pc/images/price/ba99db25b3be2abed93c50c7f55c332cs.png
//      priceImgCharIndexArray: [6,3,8,1]
//      2018-12-15 20:24:59.538 INFO  cc11001100.crawler.ziroom.ZiRoomPriceGrab 103 downloadBytes - request ok, tryTimes=0, url=http://static8.ziroom.com/phoenix/pc/images/price/ba99db25b3be2abed93c50c7f55c332cs.png, cost=146
//      price: 1930

    }

}