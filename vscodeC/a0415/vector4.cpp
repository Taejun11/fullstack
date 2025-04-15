#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"Volvo", "BMW", "Ford", "Mazda"};

    cout << cars.at(1) << "\n"; 
    cout << cars.at(2) << "\n";  
    // cout << cars.at(6) << "\n";  //오류 알려줌


    return 0;
}
