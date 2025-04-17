#include <iostream>
using namespace std;

int main(){
    string name;
    int age;
    cout << "이름: ";
    cin >> name;
    cout << "나이: ";
    cin >> age;
    cout << "\"" << name << "님은 " << age << "세입니다.\"";
    return 0;
}