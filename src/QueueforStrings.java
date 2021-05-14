public class QueueforStrings {
    int sizeofQueue = 6; // default Size of Circular Queue
    int front, rear;
    String[] itemsStrings = new String[sizeofQueue];

    QueueforStrings() {
        front = -1;
        rear = -1;
    }
    QueueforStrings(int sizeofQueue){
        front=-1;
        rear=-1;
        this.sizeofQueue =sizeofQueue;
    }

    // check the queue is full or not return true for full and false for otherwise
    boolean isFull() {
        if (front == 0 && rear == sizeofQueue - 1) {
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
    void sendElementToQueue(String value) {
        if (!isFull()) {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % sizeofQueue;
            itemsStrings[rear] = value;

        }
    }

    // give the element to the code at the first in queue
    String getElementByQueue() {
        String value;
        if (isEmpty()) {
            return "empty";
        } else {
            value = itemsStrings[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            }else{// check queue elements, and if it has only one element the array will reset
                front = (front + 1) % sizeofQueue;
            }
            return (value);
        }
    }


}
