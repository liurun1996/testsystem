/*
package com.lr.util;



import com.lr.mapper.testPaperMapper;
import com.lr.pojo.testpaper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

public class getSubjectType{
    public static  int[] getType(ArrayList<testpaper> list){
int [] arr=new int[list.size()];
        for (int i=0;i<list.size();i++){
            arr[i]=list.get(i).getSubjectType();

        }
        return arr;
    }
public static void main(String [] args){
    ApplicationContext ac=getApplication.getApp();
    testPaperMapper mapper = ac.getBean(testPaperMapper.class);
    testpaper t=new testpaper();
    t.setTestPaperId("x100011");
    ArrayList<testpaper> testpaper = mapper.findTestpaper(t);
    int[] type = getType(testpaper);
    for (int i : type){
        System.out.println(i);
    }
}
}
*/
