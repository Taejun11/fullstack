#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"Volvo", "BMW", "Ford", "Mazda"};

    // cars.push_back("re"); //추가
    cars.pop_back();         //삭제
    for (string car : cars)
    {
        cout << car << "\n";
    }
    cout << cars.size() << "\n";
    cout << cars.empty(); //비어있으면 1 아니면 0


    return 0;
}
