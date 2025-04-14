#include <iostream>
#include <string>
using namespace std;

class MyClass
{
    public:
        void myFunc(){
            cout << "toum \n";
        }
};

class MyChild: public MyClass{

};
class MyGrandChild: public MyChild{

};

int main()
{
    MyGrandChild myObj;
    myObj.myFunc();
    return 0;
}
