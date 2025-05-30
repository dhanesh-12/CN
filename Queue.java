import java.util.Scanner;

class Queue {
    int[] q; 
    int f = 0, r = 0, size; 

    public Queue(int size) {
        this.size = size;
        q = new int[size];
    }

    public void insert(int n) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter element " + (i + 1) + ": ");
            int ele = in.nextInt();
            if (r >= size) { 
                System.out.println("\nQueue is full. Lost Packet: " + ele);
                break;
            } else {
                q[r++] = ele; 
            }
        }
    }

    public void delete() {
        if (r == f) { 
            System.out.println("\nQueue is empty.");
            return;
        }
        System.out.println("\nProcessing and leaking packets...");
        for (int i = f; i < r; i++) {
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("\nLeaked Packet: " + q[i]);
        }
        f = r = 0;
    }

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("\nEnter the queue size: ");
        int queueSize = src.nextInt();
        Queue q = new Queue(queueSize); 
        System.out.print("\nEnter the number of packets to be sent: ");
        int size = src.nextInt();
        q.insert(size); 
        q.delete(); 
    }
}
