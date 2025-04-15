#include <iostream>
#include <vector>
using namespace std;

// 사용자로부터 정수 5개를 입력받아 vector<int> 에 저장한 후,
// 저장된 값을 모두 출력하는 프로그램을 작성하세요.


int main()
{
    vector<int> i = {0,0,0,0,0};
    cout << "숫자 5개를 입력하세요: ";
    for (int j = 0; j < i.size(); j++)
    {
        cin >> i.at(j);
    }
    

    for (int is : i)
    {
        cout << is << ", ";
    }
    
    return 0;
}
