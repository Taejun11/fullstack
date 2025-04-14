#include <iostream>
#include <string>
using namespace std;

class myClass
{
    public:
        int myNum;
        string myString;
};

int main()
{
    myClass myObj;
    myObj.myNum = 15;
    myObj.myString = "some text";
    cout << myObj.myNum << "\n";
    cout << myObj.myString << "\n";
    return 0;
}
