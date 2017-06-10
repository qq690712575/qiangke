package test;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * use UTF-8
 * Created by lele on 2017/6/9 0009.
 * qiangke
 * 萌点云科技（深圳）有限公司
 */
public class Test3 {
    //1创建客户端
    OkHttpClient okHttpClient=new OkHttpClient();
  static  String baseUrl="http://jwgl.frp.sziitjx.cn:8080/login.aspx";
//  static  String baseUrl="https://service.sziitjx.cn/login.html";
    public void run() throws Exception {
        //2构造请求
        Request request = new Request.Builder()
                .url(baseUrl)
                .build();
    //3用工厂类call执行请求并返回到Request
        Response response = okHttpClient.newCall(request).execute();
        //4判断是否请求成功、成功就执行剩下的业务
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        Headers responseHeaders = response.headers();
        for (int i = 0; i < responseHeaders.size(); i++) {
            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }
//        HashSet<String> cookies = new HashSet<>();
        System.out.println("----------------------------------------------------");
        String cookie="";
        for (String header : response.headers("Set-Cookie")) {
//            cookies.add(header);
            cookie+=header;

        }
        System.out.println(cookie);

//        System.out.println(response.body().string());
    /*    System.out.println("header="+responseHeaders.get("Set-Cookie"));
        System.out.println("header="+response.header("Date"));*/
    }

    public static void main(String[] args) {
        Test3 test3=new Test3();
        try {
            test3.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

