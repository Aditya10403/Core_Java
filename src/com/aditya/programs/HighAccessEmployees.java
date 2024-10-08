package com.aditya.programs;

import java.util.*;

public class HighAccessEmployees {
    public static void main(String[] args) {
        String s = String.valueOf(Integer.parseInt("01") + 1);
        System.out.println(s);
//        String[][] n = new String[][]{{"d","0002"},{"c","0808"},{"c","0829"},{"e","0215"},{"d","1508"},{"d","1444"},{"d","1410"},{"c","0809" }};
//        List<List<String >> access_times = new ArrayList<>(Arrays.asList(Arrays.copyOf(n, n.length)));
    }

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String,List<Integer>> map = new HashMap<>();
        for(List<String> a:access_times)
        {
            if(!map.containsKey(a.get(0))){
                map.put(a.get(0), new ArrayList<>());
            }
            char[] s = a.get(1).toCharArray();
            int h = (s[0]-'0')*10 + s[1]-'0';
            int m = (s[2]-'0')*10 + s[3]-'0';
            map.get(a.get(0)).add(h*60+m);
        }
        List<String> ans = new ArrayList<>();
        for(String key: map.keySet())
        {
            List<Integer> val = map.get(key);
            Collections.sort(val);
            for(int i=0;i<val.size()-2;i++)
            {
                if(val.get(i+2)-val.get(i)<=59)
                {
                    ans.add(key);
                    break;
                }
            }
        }
        return ans;
    }
}
