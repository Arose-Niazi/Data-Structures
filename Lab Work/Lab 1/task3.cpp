#include <iostream>
using namespace std;

int sum(int arry[], int sizeofarr)
{
    if(sizeofarr > 1)
    {
        return arry[sizeofarr-1]+sum(arry,sizeofarr-1);
    }
    else return arry[0];
}

int main()
{
    int arraysize;
    cout << "Enter array size: ";
    cin >> arraysize;
    int a[arraysize];
    for(int i=0; i<arraysize; i++)
    {
        cout << "Enter a number to store in array (" << i+1 << "/" <<arraysize <<"): ";
        cin >> a[i];
    }

    cout << "Sum is:" << sum(a,arraysize);
}

