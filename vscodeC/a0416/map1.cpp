#include <iostream>
#include <map>
using namespace std;

int main()
{
    map<string, int> score;
    score["Lee"] = 5200;
    score["Choi"] = 5500;
    score["Jung"] = 6100;
    // cout << "학생 점수 목록: " << endl;

    // for (map<string, int>::iterator it = score.begin(); it != score.end(); ++it)
    // {
    //     cout << it -> first << ":" << it -> second << endl;
    // }

    // string name = "bob";
    // if (score.find(name) != score.end())
    // {
    //     cout << name << "의 점수: " << score[name] << endl;
    // }else{
    //     cout << name << "의 점수가 없음 " << endl;
    // }
    // score.erase("charile");
    // cout <<  "삭제 후 남은 학생 목록: " << endl;
    for (const auto& pair : score)
    {
        // map의 값을 pair라는 변수명으로 하나씩 가져옴
        cout << pair.first << ":" << pair.second << endl;
    }
    
    
    
    //insert: 값 추가
    //find: 값 찾기
    //erase: 값 삭제
    //size: set 크기
    //empty: set이 비어있는지 여부 확인
    //clear: set값 모두 삭제
    
    return 0;
}
