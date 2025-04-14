#include <iostream>
#include <string>
using namespace std;

class Car
{
    public:
        string modelName;
        int speed;
        void speedUp(){
            speed += 10;
        }
        void speedDown(){
            speed -= 10;
        }
};

int main()
{
    Car car;
    car.modelName = "차이름";
    car.speed = 0;
    car.speedUp();
    cout << car.speed << "\n";
    car.speedDown();
    cout << car.speed << "\n";

    return 0;
}
