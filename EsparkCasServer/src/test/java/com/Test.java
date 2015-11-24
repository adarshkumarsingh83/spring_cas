package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Adarsh on 6/12/15.
 */
public class Test {

   /* public static void main(String[] args) {
        org.jasig.cas.authentication.handler.DefaultPasswordEncoder passwordEncoder=new
                org.jasig.cas.authentication.handler.DefaultPasswordEncoder("MD5");
        System.out.println(passwordEncoder.encode("radha"));
    }*/
  /* public static void main(String[] args) {

      final Map<String,Object> objectMap=new HashMap<String, Object>(){
          {
              put("1",1);
              put("2",2);
              put("3",3);
              put("4",4);
              put(null,null);
          }
      };
      final Set<String> keySet=objectMap.keySet();
       final Iterator<String> stringIterator=keySet.iterator();
       while(stringIterator.hasNext()){
           final String key=stringIterator.next();
           final Object value=objectMap.get(key);
           System.out.println(key+" "+value);
       }
   }*/

    public static void main(String[] args) throws IOException {

        // Create ProcessBuilder.
        ProcessBuilder p = new ProcessBuilder();

        // Use command "notepad.exe" and open the file.
        p.command("notepad.exe", "d:\\file.txt");
        p.start();
    }
}
