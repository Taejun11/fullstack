#include <iostream>
#include <string>
using namespace std;

class myClass
{
    public:
        void myMethod(){
            cout << "hello world";
        }
};

int main()
{
    myClass myObj;
    myObj.myMethod();
    return 0;
}
