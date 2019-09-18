#include <iostream>

using namespace std;

void insertionSort(int Arr[], int n)
{
    int key, j;
    for(int i = 1; i<n; i++)
    {
        key = Arr[i];
        j=i-1;
        while(j >= 0 && Arr[j] > key)
        {
            Arr[j+1] = Arr[j--];
        }
        Arr[j+1]=key;
    }
}

int main()
{
    int Arr[] = {3,5,6,8,51,2,1,3};
    insertionSort(Arr,8);
    for(int i=0; i<8; i++)
    {
        cout << Arr[i] <<"\t";
    }

    return 0;
}
