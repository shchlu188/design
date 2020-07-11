package com.scl.io.stream;

import lombok.SneakyThrows;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.text.ParsePosition;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description
 *          public class PipedOutputStream extends OutputStream
 *          public class PipedInputStream extends InputStream
 **********************************/

class SendThread extends Thread{
    private  PipedOutputStream pos =new PipedOutputStream();
    @SneakyThrows
    @Override
    public void run() {
       pos.write("发送 send Message.".getBytes());
       // 关闭管道 否则java.io.IOException: Write end dead
       pos.close();
    }

    public PipedOutputStream getPos() {
        return pos;
    }
}
class ReceiveThread extends Thread{
    private  PipedInputStream pis = new PipedInputStream();
    @SneakyThrows
    @Override
    public void run() {
        byte[] bytes = pis.readAllBytes();
        System.out.println("收到 "+new String(bytes,0,bytes.length));

    }

    public PipedInputStream getPis() {
        return pis;
    }
}
public class PipeStreamDemo {
    public static void main(String[] args) throws InterruptedException, IOException {
        SendThread sendThread = new SendThread();
        ReceiveThread receiveThread = new ReceiveThread();
        sendThread.getPos().connect(receiveThread.getPis());
        sendThread.start();
        Thread.sleep(2);

        receiveThread.start();


    }
}
