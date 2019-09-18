#include <iostream>
using namespace std;

int main()
{
    int arraysize;
    cout << "Enter array size: ";
    cin >> arraysize;
    int a[arraysize];
    for(int i=0; i<arraysize; i++)
    {
        cout << "Enter a number to store in array ("<<i+1<<"/"<<arraysize<<"): ";
        cin >> a[i];
    }

    cout << "Your numbers are: ";
    for(int i=0; i<arraysize; i++)
    {
        cout << a[i] <<"\t";
    }
}
