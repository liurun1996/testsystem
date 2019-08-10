
package com.lr.util;

import com.lr.pojo.SubjectType;

import java.util.*;

public class util{
    //题库管理工具
    public static List<SubjectType> sort(Integer subjectId, List<SubjectType> list) {
        for (SubjectType sub : list){
            if (sub.getSubjectid().equals(subjectId)) {
                int i = list.indexOf(sub);
                list.add(0, sub);
                list.remove(i + 1);
                break;
            }
        }
        return list;
    }

    public static String getPaperId() {
        String paperId = "x";
        Random r = new Random();
        for (int i = 0 ; i < 6 ; i++){
            int i1 = r.nextInt(10);
            paperId += i1;
        }
        return paperId;
    }

    //交卷时处理提交过来的答案，以题目id为见键，答案为值
    public static HashMap<Integer, String> commitTestPaperSort(String[] arr) {
        HashMap<Integer, String> hm = new HashMap<>();
        Set<Integer> keys = hm.keySet();
        String  sp1=null;
        for (String s : arr){
            String[] split = s.split("\\.");
            int i = Integer.parseInt(split[0]);

            if (split.length>1){
                  sp1=split[1];
            }
            if (!keys.contains(i)&& sp1!=null&&!"".equals(sp1)) {
                hm.put(i, sp1);
            } else {
                hm.replace(i, hm.get(i) + sp1);
            }

        }
        return hm;
    }
}

