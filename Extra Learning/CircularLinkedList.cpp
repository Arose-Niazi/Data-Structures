#include<iostream>
using namespace std;

typedef struct my_node {
    int data;
    struct my_node *next;
} node;

class CircularQueue {
    private:
        node *front, *rear;
        int size;

    public :
        CircularQueue() {
            front = rear = NULL;
            size = 0;
        }

        void enqueue(int element) {
            node *new_element = new node;
            new_element->data = element;
            new_element->next = NULL;
            if (front == NULL) {
                front = rear = new_element;
            }
            else {
                rear->next = new_element;
                rear = new_element;
            }
            rear->next = front;
            size++;
        }
        int AscDequeue() {
            sortList(true);
            return dequeue();
        }
        int DecDequeue() {
            sortList(false);
            return dequeue();
        }

        bool isEmpty()
        {
            if(size < 1) return true;
            return false;
        }

    private:
        int dequeue() {
            int element;
            if (isEmpty()) {
                return NULL;
            }
            else if (front == rear) {
                element = front->data;
                delete front;
                front = rear = NULL;
            }
            else {
                node *ptr = front;
                element = ptr->data;
                front = front->next;
                rear->next = front;
                delete ptr;
            }
            size--;
            return element;
        }

        void sortList(bool asc) {
            node *current = front, *index = NULL;
            int temp;
            if(front == NULL)
                cout << "List is empty";
            else {

                do {
                    index = current->next;
                    while(index != front) {
                        if((asc && current->data > index->data) || (!asc && current->data < index->data))
                        {
                            temp =current->data;
                            current->data= index->data;
                            index->data = temp;
                        }
                        index= index->next;
                    }
                    current =current->next;
                }
                while(current->next != front);
            }
        }
};

// main
int main() {
    CircularQueue cq;
    int toinsert[] =  {10, 90, 50, 80, 60, 70, 20, 30, 40} ;
    for (int x : toinsert)
        cq.enqueue(x);
    cout << "Dequeue using ascending order priority: ";
    for(int x=0; x<5; x++)
        cout << cq.AscDequeue () << "\t";
    cout << endl;
    cout << "Dequeue using descending order priority: ";
    while (!cq.isEmpty())
        cout << cq.DecDequeue () << "\t";
    cout << endl;
    cout<<endl;
    return 0;
}