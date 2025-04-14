#include <iostream>
#include <string>
using namespace std;

class Car
{
    public:
        string brand;
        string model;
        int year;
        Car(string x, string y, int z){
            brand = x;
            model = y;
            year = z;
        }
};

int main()
{
    Car carObj1("BMW","X5",1999);
    cout << carObj1.brand << " " << carObj1.model << " " << carObj1.year << "\n";

    return 0;
}
