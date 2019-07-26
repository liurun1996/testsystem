package com.lr.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class myRunnable implements Runnable{
    static long i=0;
    @Override
    public void run() {
        try {
            URL url=new URL("http://localhost:8080/test");
            URLConnection con = url.openConnection();
            InputStreamReader isr =new InputStreamReader(con.getInputStream());

            char [] cs = new char[1024];
            int i = 0;
            long start = System.currentTimeMillis();
            while ((i = isr.read(cs)) != -1) {
                System.out.println(new String(cs, 0, i));
            }
            long end=System.currentTimeMillis();
            i+=end-start;
            System.err.println(i);
            isr.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
