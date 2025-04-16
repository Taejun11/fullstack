#include <iostream>
#include <set>
using namespace std;

int main()
{
    set<int> s;
    s.insert(50);
    s.insert(20);
    s.insert(30);
    s.insert(20);
    cout << "set 안의 값들: ";

    for (int num : s)
    {
        cout << num << " ";
    }
    cout << endl;
    if (s.find(30) != s.end())
    {
        cout << "값 찾음" << endl;
    }else{
        cout << "값 없음" << endl;
    }

    s.erase(20);
    cout << "값 삭제 후 set 안의 값들: ";

    for (int num : s)
    {
        cout << num << " ";
    }
    
    //insert: 값 추가
    //find: 값 찾기
    //erase: 값 삭제
    //size: set 크기
    //empty: set이 비어있는지 여부 확인
    //clear: set값 모두 삭제
    
    return 0;
}
