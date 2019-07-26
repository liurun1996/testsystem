package com.lr.test;

import com.lr.mapper.UserMapper;
import com.lr.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class test1 {
    public static void main(String[] args) {

        ArrayList<Thread> arr = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            arr.add(new Thread(new myRunnable()));
        }
        for (Thread t : arr) {
            t.start();

        }

    }


}