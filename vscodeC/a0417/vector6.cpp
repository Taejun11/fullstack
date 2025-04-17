#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"Volvo", "BMW", "Ford", "Mazda"};
    auto it = cars.begin()+2; //인덱스 2번위치에 삽입(이 변수가 2번위치가 되겠다는 것)
    cars.insert(it, "hy");
    for (string car : cars)
    {
        cout << car << "\n";
    }
    return 0;
}
