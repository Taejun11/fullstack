#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"Volvo", "BMW", "Ford", "Mazda"};

    cout << cars.front() << "\n"; //첫번쨰요소
    cout << cars.back() << "\n";  //마지막요소


    return 0;
}
