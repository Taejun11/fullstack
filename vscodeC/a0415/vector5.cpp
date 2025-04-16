#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"Volvo", "BMW", "Ford", "Mazda"};

    // cars.push_back("re"); //추가
    // cars.pop_back();         //삭제
    for (string car : cars)
    {
        cout << car << "\n";
    }
    cout << cars.size();


    return 0;
}
