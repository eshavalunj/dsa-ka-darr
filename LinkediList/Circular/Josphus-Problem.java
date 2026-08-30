import java.util.*;

public class Solution {

    // Node class for Circular Linked List
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        // Create the first node
        Node head = new Node(1);
        Node tail = head;

        // Create remaining nodes
        for (int i = 2; i <= N; i++) {
            Node newNode = new Node(i);
            tail.next = newNode;
            tail = newNode;
        }

        // Make the linked list circular
        tail.next = head;

        // Special case when only one person exists
        if (N == 1) {
            System.out.println(1);
            return;
        }

        // current points to the current person
        Node current = head;

        // previous points to the node before current
        Node previous = tail;

        // Continue until only one person remains
        while (current.next != current) {

            // Move K-1 positions to reach the K-th person
            for (int i = 1; i < K; i++) {
                previous = current;
                current = current.next;
            }

            // Remove the current person
            previous.next = current.next;

            // Move to the next person
            current = current.next;
        }

        // Print the surviving person's position
        System.out.println(current.data);
    }
}
