#include <iostream>
using namespace std;

class Car{
    public:
        int speed;
        string color;
};

int main(){
    Car car;
    car.speed = 100;
    car.color = "red";
    cout << "car speed: " << car.speed << endl << "car color: " << car.color << endl;
    return 0;
}