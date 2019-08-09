package com.lr.test;

import com.lr.mapper.UserMapper;
import com.lr.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class test1{
    public static void main(String[] args) throws URISyntaxException, IOException {

        File f = new File(String.valueOf(new URL("http://localhost:8080/user/toTestPage.action")));
        FileInputStream fis = new FileInputStream(f);
        int len;
        while ((len=fis.read())!=-1){
            System.out.println(len);
        }
    }


}