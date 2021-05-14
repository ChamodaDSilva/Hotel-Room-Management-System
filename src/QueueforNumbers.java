public class QueueforNumbers {
    int sizeoftheQueue = 6; // default Size of Circular Queue
    int front, rear;
    int[] itemsInt = new int[sizeoftheQueue];

    QueueforNumbers() {
        front = -1;
        rear = -1;
    }
    QueueforNumbers(int sizeoftheQueue){
        front=-1;
        rear=-1;
        this.sizeoftheQueue =sizeoftheQueue;
    }

    // check the queue is full or not return true for full and false for otherwise
    boolean isFull() {
        if (front == 0 && rear == sizeoftheQueue - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    // check the queue is empty or not return true for empty and false for otherwise
    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

   //get items to the queue
    void sendElementToQueue(int value) {
        if (!isFull()) {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % sizeoftheQueue;
            itemsInt[rear] = value;
        }
    }

    // give the element to the code at the first in queue
    int getElementByQueue() {
        int value;
        if (isEmpty()) {
            return (0);
        } else {
            value = itemsInt[front];
            if (front == rear) {// check queue elements, and if it has only one element the array will reset
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % sizeoftheQueue;
            }
            return (value);
        }
    }


}
