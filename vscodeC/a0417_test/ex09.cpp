#include <iostream>
using namespace std;

class Animal{
    public:
        void sound(){
            cout << "동물소리";
        };
};

class Dog: Animal{
    public:
        void sound(){
            cout << "멍멍";
        }
};

int main(){
    Dog dog;
    dog.sound();
    return 0;
}