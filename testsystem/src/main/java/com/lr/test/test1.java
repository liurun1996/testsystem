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

public class test1 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        File f = new File("D://aaa");
        OutputStream os = new FileOutputStream(new File("D://aa.mp4"), true);
        InputStream is = null;
        File[] files = f.listFiles();
        int len;
        byte[] arr = new byte[8192];
        byte[] all = new byte[294859241];
        int i = 0;
        int c;
        for (File f1 : files) {

            is = new FileInputStream(f1);
            while ((len = is.read(arr)) != -1) {
                for (byte b : arr) {
                    all[i] = b;
                    i++;
                }
            }
        }
        System.out.println(all);

    }


}