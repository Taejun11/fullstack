#include <iostream>
#include <string>
using namespace std;

class Animal
{
    public:
        void sound(){
            cout << "animal sound \n";
        }
};

class Pig: public Animal{
    public:
        void sound(){
            cout << "pig sound \n";
        }
};
class Dog: public Animal{
    public:
        void sound(){
            cout << "dog sound \n";
        }
};


int main()
{
    Animal myAnimal;
    Pig myPig;
    Dog myDog;

    myAnimal.sound();
    myPig.sound();
    myDog.sound();
    return 0;
}
