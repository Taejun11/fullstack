#include <iostream>
#include <string>
using namespace std;

class myClass
{
    public:
        void myMethod();
};

void myClass::myMethod(){
    cout << "hello world";
}
// 클래스 외부에서 메서드 정의함

int main()
{
    myClass myObj;
    myObj.myMethod();
    return 0;
}
