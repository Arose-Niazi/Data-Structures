#include <iostream>

using namespace std;

int stack[100],n=100,top=-1;

void push(int val)
{
    if(top >= n-1)
        cout <<"Stack overflow"<<endl;
    else
        stack[++top]=val;
}

void pop()
{
    if(top == -1) cout << "Stack is Empty";
    else cout <<"The popped element is " <<stack[top--];
    cout <<endl;
}

void display()
{
    cout << "Stack elements are:";
    for(int i=top; i>=0; i--)
    {
        cout <<stack[i] <<" ";
    }
    cout <<endl;
}

bool isempty()
{
    if(top == -1) return true;
    else return false;
}

void peek()
{
    if(top == -1) cout << "Stack is Empty";
    else cout <<"The peek element is " <<stack[top];
    cout <<endl;
}

int main()
{
    cout << "1) Push in stack\n2) Pop from stack\n3) Display stack\n4) Check stack is empty\n5) Peek the stack\n6) Exit\n";
    for(;;)
    {
        cout <<"Enter choice:\n";
        int choice;
        cin >> choice;
        switch (choice)
        {
        case 1:
            {
                cout <<"Enter value to be pushed:\n";
                int pushv;
                cin >> pushv;
                push(pushv);
                break;
            }
        case 2:
            {
                pop();
                break;
            }
        case 3:
            {
                display();
                break;
            }
        case 4:
            {
                cout <<"The stack is "<< (isempty()?"":"not ") <<"empty.\n" ;
                break;
            }
        case 5:
            {
                peek();
                break;
            }
        case 6:
            {
                return 0;
            }
        }
    }
    return 0;
}



