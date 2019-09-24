#include <iostream>

using namespace std;

#define MAX_ARRAY_SIZE  10

class ArrayUtility {
public:
    int findMax(int A[], int i, int j)
    {
        int max_value=A[i];
        for(int loop=i+1; loop<=j; loop++)
            if(max_value < A[loop]) max_value=A[loop];
        return max_value;
    }
    int findMaxPos(int A[], int i, int j)
    {
        int max_value=findMax(A,i,j);
        for(int loop=i; loop<=j; loop++)
            if(max_value == A[loop]) return loop;
        return -1;
    }

    int findMin(int A[], int i, int j)
    {
        int min_value=A[i];
        for(int loop=i+1; loop<=j; loop++)
            if(min_value > A[loop]) min_value=A[loop];
        return min_value;
    }
    int findMinPos(int A[], int i, int j)
    {
        int min_value=findMin(A,i,j);
        for(int loop=i; loop<=j; loop++)
            if(min_value == A[loop]) return loop;
        return -1;
    }

    void swap(int A[], int i, int j)
    {
        int hold=A[i];
        A[i]=A[j];
        A[j]=hold;
    }

};

int main()
{
    int Array[MAX_ARRAY_SIZE];
    ArrayUtility arrayU;

    for(int loop=0; loop<MAX_ARRAY_SIZE; loop++)
    {
        cout << "Enter integer number (" << loop+1 << "/" << MAX_ARRAY_SIZE <<"): ";
        cin >> Array[loop];
    }

    int i,j;
    while(true)
    {
        cout << "Enter starting index to preform operations: ";
        cin >> i;
        if(i < 0 || i > MAX_ARRAY_SIZE-1) cout << "Error: Invalid value, index must be between 0 - " << MAX_ARRAY_SIZE-1;
        else break;
    }

    while(true)
    {
        cout << "Enter ending index to preform operations: ";
        cin >> j;
        if(j < i || j > MAX_ARRAY_SIZE-1) cout << "Error: Invalid value, index must be between "<< i <<" - " << MAX_ARRAY_SIZE-1;
        else break;
    }

    cout << endl;

    cout <<"Max value in array is: " << arrayU.findMax(Array,i,j)<<endl;
    cout <<"Max value index in array is: " << arrayU.findMaxPos(Array,i,j)<<endl;
    cout <<"Min value in array is: " << arrayU.findMin(Array,i,j)<<endl;
    cout <<"Min value index in array is: " << arrayU.findMinPos(Array,i,j)<<endl;\
    cout <<"Array before swap: ";
    for(int loop=0; loop<MAX_ARRAY_SIZE; loop++)
        cout << Array[loop] << "\t";

    cout << endl;

    arrayU.swap(Array,i,j);
    cout <<"Array after swap: ";
    for(int loop=0; loop<MAX_ARRAY_SIZE; loop++)
        cout << Array[loop] << "\t";

    return 0;
}
