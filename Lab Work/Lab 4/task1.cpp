#include <iostream>

using namespace std;

#define ROWS  	2
#define COL  	3
#define SETS  	2

int add_column(int a[ROWS][COL][SETS])
{
    int sum=0;
    for(int i=0; i<COL; i++)
    {
        for(int j=0; j<SETS; j++)
            sum+=a[0][i][j];
    }
    return sum;
}

int add_row(int a[ROWS][COL][SETS])
{
    int sum=0;
    for(int i=0; i<ROWS; i++)
    {
        for(int j=0; j<SETS; j++)
        {
             sum+=a[j][0][i];
        }

    }
    return sum;
}

int getInput(int i, int j, int k)
{
    int number;
    cout << "Please enter a number["<< i <<"]["<<j << "]["<<k << "]: ";
    cin >> number;
    return number;
}

int main()
{
    int x[ROWS][COL][SETS];
    for(int i=0; i<ROWS; i++)
        for(int j=0; j<COL; j++)
            for(int k=0;k<SETS; k++)
                x[i][j][k] = getInput(i,j,k);

    cout << "Your array is: " <<endl;
    for(int i=0; i<ROWS; i++)
    {
        for(int j=0; j<COL; j++)
        {
            for(int k=0;k<SETS; k++)
                cout << x[i][j][k] << "\t";
            //cout << endl;
        }
        //cout << endl;
    }

    cout << endl;
    cout << "Result of add column: " << add_column(x) <<endl;
    cout << "Result of add row: " << add_row(x) <<endl;
    return 0;
}
