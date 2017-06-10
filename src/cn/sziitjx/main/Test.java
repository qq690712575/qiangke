package cn.sziitjx.main;

import okhttp3.*;

import java.io.IOException;

/**
 * use UTF-8
 * Created by lele on 2017/6/8 0008.
 * qiangke
 */
public class Test {

    public static void main(String args[]) throws IOException {
        OkHttpClient client = new OkHttpClient();

        //3, 发起新的请求,获取返回信息
        RequestBody body = new FormBody.Builder()

                .add("__VIEWSTATE", "dDw4MTI3MTI0O3Q8O2w8aTwxPjs%2BO2w8dDw7bDxpPDc%2BOz47bDx0PHA8O3A8bDxvbmNsaWNrOz47bDx3aW5kb3cuY2xvc2UoKVw7Oz4%2BPjs7Pjs%2BPjs%2BPjs%2BdpwF25fYVHpReCC6HcYIsZpWHjU%3D")//添加键值对
                .add("tbYHM", "1501090103")
                .add("tbPSW", "chen15167108")
                .add("Button1", "%B5%C7++%C2%BD")
                .build();
        Request request = new Request.Builder()
                .url("http://jwgl.sziit.edu.cn/login.aspx")
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        if(response.isSuccessful())
        {
            String str = response.body().string();
            System.out.println("服务器响应为: " + str);
        }
    }


}
