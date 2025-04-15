#include <iostream>
#include <string>
using namespace std;

class Animal{
    public:
        void sound(){
            cout << "animal sound\n";
        }
};

class Dog: public Animal{
    public:
        void sound(){
            cout << "dog sound\n";
        }
};
class Bird: public Animal{
    public:
        void sound(){
            cout << "Bird sound\n";
        }
};
class Cat: public Animal{
    public:
        void sound(){
            cout << "Cat sound\n";
        }
};


int main()
{
    Dog dog;
    Bird bird;
    Cat cat;
    dog.sound();
    bird.sound();
    cat.sound();
    return 0;
}
