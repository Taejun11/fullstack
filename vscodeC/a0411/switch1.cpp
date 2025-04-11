#include <iostream>
#include <string>
using namespace std;

int main()
{
    int day = 4;
    switch (day)
    {
    case 1:
        cout << "월요일";
        break;
    case 2:
        cout << "화요일";
        break;
    case 3:
        cout << "수요일";
        break;
    case 4:
        cout << "목요일";
        break;
    case 5:
        cout << "금요일";
        break;
    case 6:
        cout << "토요일";
        break;
    case 7:
        cout << "일요일";
        break;
    
    default:
        break;
    }
    
    

    return 0;
}
