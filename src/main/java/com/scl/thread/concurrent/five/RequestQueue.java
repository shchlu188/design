package com.scl.thread.concurrent.five;

import java.util.LinkedList;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class RequestQueue {
    private final LinkedList<Request> requests = new LinkedList<>();

    public Request getRequest() {
        synchronized (requests) {
            while (requests.size() <= 0) {
                try {
                    requests.wait();

                } catch (InterruptedException e) {
                    break;
                }
            }
            Request request = requests.removeFirst();
            return request;
        }
    }
    public void putRequest(Request request){
        synchronized (requests){
            requests.addLast(request);
            requests.notifyAll();
        }
    }
}
