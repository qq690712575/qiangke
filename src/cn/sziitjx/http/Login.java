package cn.sziitjx.http;

import okhttp3.*;

import java.io.IOException;

/**
 * use UTF-8
 * Created by lele on 2017/6/8 0008.
 * qiangke
 */
public class Login {

    //登陆前的URL、来获取VIEWSTATE
   private String loginUrl="http://jwgl.sziit.edu.cn/login.aspx";
   private String __VIEWSTATE="dDw4MTI3MTI0O3Q8O2w8aTwxPjs+O2w8dDw7bDxpPDc+Oz47bDx0PHA8O3A8bDxvbmNsaWNrOz47bDx3aW5kb3cuY2xvc2UoKVw7Oz4+Pjs7Pjs+Pjs+Pjs+dpwF25fYVHpReCC6HcYIsZpWHjU=";
        private  String postData="__VIEWSTATE=dDw4MTI3MTI0O3Q8O2w8aTwxPjs%2BO2w8dDw7bDxpPDc%2BOz47bDx0PHA8O3A8bDxvbmNsaWNrOz47bDx3aW5kb3cuY2xvc2UoKVw7Oz4%2BPjs7Pjs%2BPjs%2BPjs%2BdpwF25fYVHpReCC6HcYIsZpWHjU%3D&tbYHM=1501090103&tbPSW=chen15167108&Button1=%B5%C7++%C2%BD";


    OkHttpClient client = new OkHttpClient();

   public  String loginInit() throws IOException {
        Request request = new Request.Builder()
                .url(this.loginUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public void postData() throws IOException {
        FormBody.Builder builder=new FormBody.Builder();
        builder.add("__VIEWSTATE","dDw4MTI3MTI0O3Q8O2w8aTwxPjs%2BO2w8dDw7bDxpPDc%2BOz47bDx0PHA8O3A8bDxvbmNsaWNrOz47bDx3aW5kb3cuY2xvc2UoKVw7Oz4%2BPjs7Pjs%2BPjs%2BPjs%2BdpwF25fYVHpReCC6HcYIsZpWHjU%3D");
        builder.add("tbYHM","1501090103");
        builder.add("tbPSW","chen15167108");
        builder.add("Button1","%B5%C7++%C2%BD");
        RequestBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(this.loginUrl)
                .post(formBody)
                .build();
        Response response = client.newCall(request).execute();
        if(response.isSuccessful())
        {
            String str = response.body().string();
            System.out.println("服务器响应为: " + str);
            System.out.println("发送了: " + builder.toString());

        }
    }


}
