#include <iostream>
using namespace std;

int main(void)
{
    int a=0;
    int *aptr = &a;

    int c[5] = {1,2,3,4,5};
    int *cptr=c;

    int d[5] = {6,7,8,9,10};
    int e[5] = {11,12,13,14,15};

    int *deptr[2] = {d,e};

    cout <<"a = " << a<<endl;
    cout <<"*aptr = " << *aptr<<endl;
    cout <<"aptr = " << aptr<<endl<<endl;

    cout <<"c = " << c<<endl;
    cout <<"*cptr = " << *cptr<<endl;
    cout <<"cptr = " << cptr<<endl<<endl;
    for(int i=0; i<5; i++)
    {
        cout <<"c["<<i <<"]= " << c[i]<<endl;
        cout <<"*(cptr+"<<i <<") =" << *(cptr+i)<<endl;
    }


    for(int i=0; i<5; i++)
    {
        cout <<"d["<<i <<"]= " << d[i]<<endl;
        cout <<"*(deptr[0]+"<<i <<") =" << *(deptr[0]+i)<<endl;

        cout <<"e["<<i <<"]= " << e[i]<<endl;
        cout <<"*(deptr[1]+"<<i <<") =" << *(deptr[1]+i)<<endl<<endl;
    }
}
