package com.chenrui.leecode;

public class LinkedReverse {
    public static void main(String[] args) {

        int i=8;
        i=i++;//i先赋值，后自增，所以i=8
        System.out.println(i);

        Node head = new Node(0);
        Node head1 = new Node(1);
        Node head2 = new Node(2);
        Node head3 = new Node(3);
        Node head4 = new Node(4);
        head3.next = head4;
        head2.next=head3;
        head1.next=head2;
        head.next  = head1;
        Node newNode = reverse(head);
        System.out.println(newNode.value+"-->"+newNode.next.value+"-->"+newNode.next.next.value+"-->"+newNode.next.next.next.value);
    }

    static Node reverse(Node head){
        if(head == null || head.next ==null){
            return head;
        }
        Node newnode = reverse(head.next);
        Node temp = head.next;
        temp.next = head;
        head.next = null;
        return newnode;
    }
}
