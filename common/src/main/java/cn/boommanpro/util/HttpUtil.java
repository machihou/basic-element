package cn.boommanpro.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil {

    private static int SUCCESS_CODE = 200;

    public static String getUrlData(String link) {
        HttpURLConnection httpUrlConnection = null;
        try {
            URL url = new URL(link);
            URLConnection urlconnection = url.openConnection();
            httpUrlConnection = (HttpURLConnection) urlconnection;
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setInstanceFollowRedirects(false);
            httpUrlConnection.setRequestProperty("Accept", "*/*");
            httpUrlConnection.setRequestProperty("Connection", "keep-alive");
            httpUrlConnection.setRequestProperty("Host", "promoprod.alipay.com");
            httpUrlConnection.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");


            httpUrlConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7");
            httpUrlConnection.setRequestProperty("Referer", "http://render.r8l7cf.com/p/f/fd-jqqeh032/pages/outside/index.html?shareid=2088232181381663&sign=q9nnSOuTruVc%2FOmFA3tsFqFyR7K3qfzPBTSvf4tQ9Vc%3D");
            httpUrlConnection.setRequestProperty("Accept-Encoding", " gzip, deflate, br");
            httpUrlConnection.setRequestProperty("Cookie", "JSESSIONID=GZ00lYlkcvi8sqDEXt595COMFIV9xrpromoprodGZ00; mobileSendTime=-1; credibleMobileSendTime=-1; ctuMobileSendTime=-1; riskMobileBankSendTime=-1; riskMobileAccoutSendTime=-1; riskMobileCreditSendTime=-1; riskCredibleMobileSendTime=-1; riskOriginalAccountMobileSendTime=-1; cna=R+anFNCFwUUCAW/Hv7z3GkS8; rtk=5DhxKzAovgp3608/aDO/umgK2iLzleMDiPWJuf/3+76UlewsumF; zone=GZ00D; spanner=x0ZHDBoCHd5R4gOG7sVwzY668IxCCGVC; JSESSIONID=3D54826D8D3C11EC1F7A764349531B46; ALIPAYJSESSIONID=GZ00naWvKMZAdIEZ8CvZBG2KYWdWUspromoprodGZ00; ctoken=w3kPIazINrteP0fm");
            httpUrlConnection.setRequestMethod("GET");
            httpUrlConnection.connect();
            if (httpUrlConnection.getResponseCode() == 200) {
              return getResult(httpUrlConnection);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (httpUrlConnection!=null){
                httpUrlConnection.disconnect();
            }

        }
        return null;
    }

    public static String getUrlDataAppenNewLine(String link){
        HttpURLConnection httpUrlConnection = null;
        try {
            URL url = new URL(link);
            URLConnection urlconnection = url.openConnection();
            httpUrlConnection = (HttpURLConnection) urlconnection;
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setInstanceFollowRedirects(false);
            httpUrlConnection.setRequestProperty("Connection", "keep-alive");
            httpUrlConnection.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36");
            httpUrlConnection.setRequestMethod("GET");
            httpUrlConnection.connect();
            if (httpUrlConnection.getResponseCode() == 200) {
                //文件写入
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(), "utf-8"));
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result.append(line+"\n");
                }
                return result.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (httpUrlConnection!=null){
                httpUrlConnection.disconnect();
            }

        }
        return null;
    }

     static String getResult(HttpURLConnection httpUrlConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(), "utf-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        System.setProperty("http.proxyHost", "127.0.0.1");
//        System.setProperty("https.proxyHost", "127.0.0.1");
//        System.setProperty("http.proxyPort", "8888");
//        System.setProperty("https.proxyPort", "8888");
        for (int i = 0; i < 1000; i++) {
            long phone=15735105220l+i;
            String json_ua = "207LCBFRucrR3Xu4OekFcmjk70=%7CL2MGo6qjbRwrMLyu93MfL791UTR3wgRqUc3pLM4=%7CLqLHYhu36cLZFZMhuARuRV1TdYfeHkB34CosryaazPxrp0KHZQ==%7CKSUjkUPHCXrDGD/drGmhzH1kSpgTzxkvHkfixLcGWjUie77o80OR4dnALN5Pi9e4iBGdustymunQyqbgkTDqibtmw7Uun0l3TpebjK8OyPRsp0Eyu3MRIbq28IMC1ryOHICN64BwkKgeRQ/rSAXnkzmhJTaXU9mXofD420CJA3PRz+WG1Bz8mSX23ut5rGZV7Pj/qrkpS39mtpIgKa0VSQ==%7CKCQCsNsK3LeZ%7CK+aDkeov85+oc127oNkPYdgEiJ9cJUdocL1YC3K21uRzfxnrGdW/jpfb/zo=%7CKuaDJi+r/ctQmjx/1noSIDkupQ==%7CJSlMbzbuuIiQXTg7oh5IfGCqrF68";
            String url = "https://promoprod.alipay.com/campaign/lotteryWithLogonInfo.json?campInfo=p1j%252BdzkZl03BbvY4ClDID7%252FGiTlLCEEq0EmyB5yLfH2lIGLw2ZgnyTMSXAcf56tw&bindMobile=" + phone + "&bizType=c2cShare&shareId=2088232181381663&snsScene=yebTrialFoundSns&sign=q9nnSOuTruVc%252FOmFA3tsFqFyR7K3qfzPBTSvf4tQ9Vc%253D&json_ua="+json_ua+"&_json_token=undefined&_callback=jsonp1547387161961";
            System.out.println(url);
            String urlData = HttpUtil.getUrlData(url);

            System.out.println(urlData);

        }

    }
    // ((*)()*(*))

}
