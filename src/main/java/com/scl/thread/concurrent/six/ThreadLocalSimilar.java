package com.scl.thread.concurrent.six;

import java.util.HashMap;
import java.util.Map;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class ThreadLocalSimilar <T>{
    private final Map<Thread,T> storage = new HashMap<>();

    public void set (T t){
        synchronized (this){
            storage.put(Thread.currentThread(),t);
        }
    }

    public T get(){
      synchronized (this){
          T t = storage.get(Thread.currentThread());
          if (t== null){
              return initialValue();
          }
          return t;
      }
    }

    private T initialValue() {

        return null;
    }


}
