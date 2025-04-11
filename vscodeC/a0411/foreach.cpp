#include <iostream>
#include <string>
using namespace std;

int main()
{
    int mynum[5] = {1,2,3,4,5};
    for (int i : mynum)
    {
        cout << i << "\n";      
    }

    return 0;
}
