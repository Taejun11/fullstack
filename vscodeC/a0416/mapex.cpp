#include <iostream>
#include <map>
using namespace std;

int main()
{
    // 문제
    // 회사 직원들의 이름과 연봉 정보를 map에 저장하는 프로그램을 작성하세요.
    // 그리고 연봉이 5000만 원 이상인 직원들의 이름과 연봉만 출력하세요.
    //  조건:
    // map<string, int> 자료구조를 사용하여
    // 직원의 이름(string)과 연봉(int)을 저장하세요.
    // 연봉이 5000만 원 이상인 직원만 이름 : 연봉 형태로 출력하세요.
    map<string, int> score;
    score["Kim"] = 4500;
    score["Lee"] = 5200;
    score["Park"] = 4800;
    score["Choi"] = 5500;
    score["Jung"] = 6100;

    for (const auto &pair : score)
    {
        // map의 값을 pair라는 변수명으로 하나씩 가져옴
        if (pair.second >= 5000)
        {
            cout << pair.first << ":" << pair.second << endl;
        }
    }

    return 0;
}
