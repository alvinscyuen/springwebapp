package com.springapp.mvc.StringComparator;

import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class StringService implements Comparator<String> {


    public int compare(String o1, String o2) {
        int result = 0;

        if(o1!=null && o2!=null){
            result =  o1.compareTo(o2);
        }
        return result;
    }

}
