#include <iostream>
#include <stack>
using namespace std;

int main()
{
    stack<int> s;
    s.push(10);
    s.push(20);
    s.push(30);
    cout << "현재 스택의 맨 위 값: " << s.top() << endl;
    s.pop();
    cout << "현재 스택의 맨 위 값: " << s.top() << endl;

    if (!s.empty())
    {
        cout << "스택에 값이 있음" << endl;
    }
    cout << "현재 스택의 크기: " << s.size() << endl;

    while (!s.empty())
    {
        cout << "스택에서 꺼낸 값: " << s.top() << endl;
        s.pop();
    }
    //push: 스택 값 추가
    //pop: 스택 값 제거
    //top: 스택 맨 위 값 출력
    //empty: 스택 비어있는지 여부 확인
    //size: 스택 크기 확인
    
    return 0;
}
