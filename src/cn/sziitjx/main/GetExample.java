package cn.sziitjx.main;


import cn.sziitjx.http.Login;

import java.io.IOException;

public class GetExample {

    public static void main(String[] args) throws IOException {
        Login login = new Login();
        String response = login.loginInit();
        System.out.println(response);


    }
}