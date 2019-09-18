#include <iostream>
using namespace std;

int maxi(int arry[], int sizeofarr)
{
    if(sizeofarr ==  1)
    {
        return arry[sizeofarr-1];
    }
    else
    {
        int maxim=maxi(arry,sizeofarr-1);
        if(arry[sizeofarr-1] > maxim) return arry[sizeofarr-1];
        else return maxim;
    }
}


int mini(int arry[], int sizeofarr)
{
    if(sizeofarr ==  1)
    {
        return arry[sizeofarr-1];
    }
    else
    {
        int maxim=mini(arry,sizeofarr-1);
        if(arry[sizeofarr-1] < maxim) return arry[sizeofarr-1];
        else return maxim;
    }
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

    cout << "max is:" << maxi(a,arraysize) <<endl;
    cout << "min is:" << mini(a,arraysize);
}


