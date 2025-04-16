#include <iostream>
#include <deque>
using namespace std;

int main()
{
    deque<int> s;
    s.push_back(10);
    s.push_back(20);
    s.push_front(5);
    cout << "현재 큐의 맨 앞 값: " << s.front() << endl;
    cout << "현재 큐의 맨 뒤 값: " << s.back() << endl;

    s.pop_front();
    s.pop_back();
    cout << "삭제 후 앞쪽 값: " << s.front() << endl;
    cout << "현재 큐의 크기: " << s.size() << endl;

    s.push_back(20);
    s.push_front(1);
    cout << "현재 큐의 요소들: ";
    for (int num : s)
    {
        cout << num << " ";
    }
    cout << endl;

    //push: 큐 값 추가
    //pop: 큐 값 제거
    //front: 큐 맨 위 값 출력
    //empty: 큐 비어있는지 여부 확인
    //size: 큐 크기 확인
    
    return 0;
}
