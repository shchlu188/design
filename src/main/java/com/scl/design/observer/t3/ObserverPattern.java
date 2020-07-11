package com.scl.design.observer.t3;

import javax.security.auth.kerberos.KerberosCredMessage;
import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/6
 * @Description
 **********************************/
public class ObserverPattern {
    public static void main(String[] args) throws Exception {
        TeacherAnswer teacherAnswer = new TeacherAnswer();
        teacherAnswer.submit(new PhysicalQuest());
        teacherAnswer.submit(new ChineseQuest());
        teacherAnswer.setHasTime(true);
        teacherAnswer.answer();

    }
}

interface Answer {
    void submit(Quest quest);

    void answer() throws InterruptedException;
}

class TeacherAnswer implements Answer {
    private List<Quest> quests = new ArrayList<>();
    private volatile boolean hasTime ;

    public void setHasTime(boolean hasTime) {
        this.hasTime = hasTime;
    }

    @Override
    public void submit(Quest quest) {
        quests.add(quest);
    }

    @Override
    public void answer() throws InterruptedException {
        synchronized (quests) {
            if (hasTime){
                for (Quest quest : quests) {
                    System.out.println("处理逻辑");
                    quest.hand();
                    System.out.println("处理逻辑");
                }
            }else {
                quests.wait();
            }
        }
    }
}

interface Quest {

    void hand();

}

class PhysicalQuest implements Quest{
    @Override
    public void hand() {
        System.out.println("物理问题");
    }
}
class ChineseQuest implements Quest{
    @Override
    public void hand() {
        System.out.println("语文问题");
    }
}