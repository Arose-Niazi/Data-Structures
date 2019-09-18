#include <iostream>

using namespace std;

#define MAX_ARRAY_SIZE  50

int main()
{
    int Arr[MAX_ARRAY_SIZE];
    int current_size=0;

    while (true)
    {
        cout << "Enter array size: ";
        cin >> current_size;
        if(current_size > 50 || current_size < 0 ) cout << "Error: Invalid array size select between 0-50." <<endl;
        else break;
    }

    for(int i=0; i<current_size; i++)
    {
        cout << "Enter integer (" << i+1 << "/" << current_size << "): ";
        cin >> Arr[i];
    }

    int insertat;
    while (true)
    {
        cout << "Enter index to insert at: ";
        cin >> insertat;
        if(insertat > current_size || insertat < 0 ) cout << "Error: Invalid array index please enter between 0 - " << current_size <<"." <<endl;
        else break;
    }

    for(int i=0; i<current_size; i++)
    {
        cout << Arr[i]<<"\t";
    }

    int insertValue;
    cout << endl<<"Enter number to insert: ";
    cin >> insertValue;

    current_size++;

    for(int i=current_size; i>insertat; i--)
    {
        Arr[i]=Arr[i-1];
    }
    Arr[insertat]=insertValue;

    for(int i=0; i<current_size; i++)
    {
        cout << Arr[i]<<"\t";
    }

    return 0;
}
