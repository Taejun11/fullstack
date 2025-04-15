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
    // Car carObj1;
    // carObj1.brand = "BMW";
    // carObj1.model = "X5";
    // carObj1.year = 1999;
    // cin >> carObj1.brand;
    // cin >> carObj1.model;
    // cin >> carObj1.year;
    Car carObj1("BMW", "X5", 1999);

    // Car carObj2;
    // carObj2.brand = "Ford";
    // carObj2.model = "Mustang";
    // carObj2.year = 1969;

    cout << carObj1.brand << " " << carObj1.model << " " << carObj1.year << "\n";
    // cout << carObj2.brand << " " << carObj2.model << " " << carObj2.year << "\n";
    return 0;
}
