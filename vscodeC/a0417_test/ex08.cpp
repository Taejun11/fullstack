#include <iostream>
using namespace std;

class Student{
    public:
        string name;
        int id;
};

int main(){
    Student student;
    student.name = "학생이름";
    student.id = 1234;
    cout << "학생이름: " << student.name << ", 학번: " << student.id << endl;
    return 0;
}