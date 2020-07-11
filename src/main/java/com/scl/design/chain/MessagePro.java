package com.scl.design.chain;

import java.util.stream.IntStream;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/9
 * @Description
 **********************************/
public class MessagePro{
    public static void main(String[] args) {
        MessageHandler handler = new MessageHandler();
        IntStream.rangeClosed(1,5)
                .forEach(idx-> {
                    handler.request(new Message(String.valueOf(idx)) );
                });
    }


}


 class Message {
    String value;

     public Message(String value) {
         this.value = value;
     }
 }

class MessageHandler{
    public void request(Message message){
        new Thread(()->{
            String value = message.value;
            System.out.println(value+">>>>>>>>>"+Thread.currentThread().getName());
        }).start();
    }
}
