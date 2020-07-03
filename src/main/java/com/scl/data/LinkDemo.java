package com.scl.data;


/**
 * @author scl
 * @Date 2020/6/27
 * @Description
 */
public class LinkDemo {


}

class Stu {
    String key;
    String name;
    int age;

    public Stu(String key, String name, int age) {
        this.key = key;
        this.name = name;
        this.age = age;
    }

    public Stu(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class LinkType {
    Node root;
    Integer len; // 链表长度

    LinkType() {
        root = new Node(new Stu("", "", -1));
        this.len = 0;
    }

    int length(){
        return len;
    }
    Node find(String key){
        if (key == null){
            throw new RuntimeException("key is not null");
        }else {
          return   root.next.findNode(new Node(new Stu(key)));
        }
    }
    void insert(Node node) {
        checkNode(node);
        if (root.next == null) {
            root.next = node;
        } else {
            root.insertLast(node);

        }
        len++;
    }
    void insert(String key,Node node){
        Node target = find(key);
        insert(node);


    }

    void firstInsert(Node node){
        checkNode(node);
        if (root.next == null){
            root.next = node;
        }else {
            Node tmp = root.next;
            root.next = node;
            node.next = tmp;
        }
        len++;
    }

    Node remove(String key){
        Node node = root.removeNode(key);
        if (node!=null){
            len--;
        }
        return node;
    }

    @Override
    public String toString() {
        Node firstNode = root.next;
        if (firstNode == null){
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder("LinkType{node= ").append(firstNode);
        while (firstNode.next!=null){
            stringBuilder.append(",next="+firstNode.next);
            firstNode =firstNode.next;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void checkNode(Node node) {
        if (node == null) {
            throw new RuntimeException("数据不能为空");
        }

    }

    static class Node {
        Stu stu; // 数据
        Node next; // 指向下一个的指针

        /**
         * 尾插
         * @param node 节点
         */
        public void insertLast(Node node) {
            Node tmp = this.next;
            while (tmp != null) {
                if (tmp.next == null) {
                    tmp.next = node;
                    break;
                }
                tmp= tmp.next;
            }
        }

        public Node() {
            this(null);
        }

        public Node(Stu stu) {
            this.stu = stu;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "stu=" + stu +"}";
        }

        public Node findNode(Node node) {
            Node tmp = this;
            while (tmp != null){
                if (tmp.stu.key.equalsIgnoreCase(node.stu.key)){
                    return tmp;
                }
                tmp =tmp.next;
            }

            return new Node();
        }



        public Node removeNode(String key) {
            Node target = new Node(new Stu(key));
            Node preNode = findPreNode(target); // 删除节点的上个节点
            Node node = findNode(target); // 删除的节点
            preNode.next= node.next;
            node.next = null;
            return node;
        }

        private Node findPreNode(Node node) {
            Node tmp = this;
            while (tmp.next!=null){
                if (tmp.next.stu.key.equalsIgnoreCase(node.stu.key)){
                    break;
                }
                tmp =tmp.next;
            }
            return tmp;
        }
    }

    public static void main(String[] args) {
        LinkType linkType = new LinkType();
        Stu stu = new Stu("a", "as", 12);
        Stu stu1 = new Stu("b", "ad", 14);
        Stu stu2 = new Stu("c", "ax", 15);
        Stu stu3 = new Stu("d", "ac", 13);
        Stu stu4 = new Stu("e", "av", 11);

        Node node = new Node();
        linkType.firstInsert(new Node(stu1));
        linkType.firstInsert(new Node(stu));
        linkType.firstInsert(new Node(stu3));
        linkType.firstInsert(new Node(stu2));
        linkType.insert("d",new Node(stu4));
        Node remove = linkType.remove("d");
        System.out.println(remove);
        System.out.println(linkType.length());
        System.out.println(linkType);
    }
}