package com.chenrui.leecode;

import java.util.ArrayList;
import java.util.List;

public class StringFind {

    public static void main(String[] args) {


        String string[] ={"a","s","d","f","g","h","j","k","l","z","a","s","d","f","w","r"};
        String target[] ={"o","d","f"};
        int n=string.length;
        int m =target.length;
        int result =0;//匹配数
        List<Integer> targetindex =new ArrayList<Integer>();
        for(int i=0;i<n-m;){
            boolean find = true;
            for(int j=0;j<m;j++){
                if(!target[m-1-j].equals(string[i+m-1-j])){
                    find = false;
                }
            }
            if(find){
                result ++;
                targetindex.add(i);
                i++;
            }else{
                int move=1;
                boolean findInner = false;
                for(;i+m-1+move<n;move++){
                    if(target[m-1].equals(string[i+m-1+move])){
                        findInner = true;
                        break;
                    }
                }
                if(!findInner){
                    break;
                }else{
                    i+=move;
                    System.out.println("优化位移"+move);
                }
            }

        }
        System.out.println("匹配数量"+result+"匹配位置"+targetindex);
    }
}
