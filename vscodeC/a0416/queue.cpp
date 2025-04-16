#include <iostream>
#include <queue>
using namespace std;

int main()
{
    queue<int> s;
    s.push(10);
    s.push(20);
    s.push(30);
    cout << "현재 큐의 맨 위 값: " << s.front() << endl;
    s.pop();
    cout << "현재 큐의 맨 위 값: " << s.front() << endl;

    if (!s.empty())
    {
        cout << "큐에 값이 있음" << endl;
    }
    cout << "현재 큐의 크기: " << s.size() << endl;

    while (!s.empty())
    {
        cout << "큐에서 꺼낸 값: " << s.front() << endl;
        s.pop();
    }
    //push: 큐 값 추가
    //pop: 큐 값 제거
    //front: 큐 맨 위 값 출력
    //empty: 큐 비어있는지 여부 확인
    //size: 큐 크기 확인
    
    return 0;
}
