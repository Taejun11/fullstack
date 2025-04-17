#include <iostream>
#include <vector>
using namespace std;

int main(){
    vector<int> arr;
    int select;
    while (true)
    {
        cout << "숫자입력(그만 입력하고싶으면 -1): ";
        cin >> select;
        if (select == -1)
        {
            break;
        }else{
            arr.push_back(select);
        }
    }

    for (int i = 0; i < arr.size();i++)
    {
        cout << arr.at(i) << ", ";
    }
    
    
    return 0;
}