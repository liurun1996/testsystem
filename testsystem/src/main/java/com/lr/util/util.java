
package com.lr.util;

import com.lr.pojo.SubjectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class util {
    //题库管理工具
    public static List<SubjectType> sort(Integer subjectId, List<SubjectType> list) {
        for (SubjectType sub : list) {
            if (sub.getSubjectid().equals(subjectId)) {
                int i = list.indexOf(sub);
                list.add(0, sub);
                list.remove(i+1);
                break;
            }
        }
        return list;
    }
    public static String getPaperId() {
        String paperId = "x";
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int i1 = r.nextInt(10);
            paperId += i1;
        }
        return paperId;
    }
}

