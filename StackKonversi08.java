public class StackKonversi08 {
    int[] tumpukanBiner;
    int size;
    int top;

    public StackKonversi08() {
        this.size = 32; // asusmsi 32 bit
        tumpukanBiner = new int[size];
        top = 01;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack penuh");
        } else {
            top++;
            tumpukanBiner[top] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong");
            return -1;
        } else {
            int data = tumpukanBiner[top];
            top--;
            return data;
        }
    }
}
