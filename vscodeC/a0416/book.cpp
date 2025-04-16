#include <iostream>
#include <vector>
using namespace std;

class Book{
    public:
        string title;
        bool isBorrowed;

        Book(string t)
        {
            title = t;
            isBorrowed = false;
        }
};

vector<Book> library; 
//Book 형태의 벡터 library 선언

void menu(){//기초적인 메뉴
    cout << "=== 도서 대출 프로그램 ===" << endl;
    cout << "1. 도서 목록 확인" << endl;
    cout << "2. 도서 대출" << endl;
    cout << "3. 도서 반납" << endl;
    cout << "4. 프로그램 종료" << endl;
    cout << "메뉴 선택: ";
};

void borrow(){//2번 선택시 대출함수
    int bor; //도서번호
    cout << "대출할 도서 번호를 입력하세요: ";
    cin >> bor;
    if (!library[bor-1].isBorrowed)
    { //대출 가능할 경우
        library[bor-1].isBorrowed = true;
        cout << "'" << library[bor-1].title << "' 책을 대출했습니다." << endl;
    }else if (library[bor-1].isBorrowed)
    { //대출중일 경우
        cout << "'" << library[bor-1].title << "' 책은 이미 대출중입니다." << endl;
    }else{
        cout << "잘못된 선택입니다." << endl;
    }
    
    
};

void returnBook(){//3번 선택시 반납함수
    int ret; //도서번호
    cout << "대출할 도서 번호를 입력하세요: ";
    cin >> ret;
    if (library[ret-1].isBorrowed)
    { //대출중일 경우
        library[ret-1].isBorrowed = false;
        cout << "'" << library[ret-1].title << "' 책을 반납했습니다." << endl;
    }else if (!library[ret-1].isBorrowed)
    { //대출 가능할 경우
        cout << "'" << library[ret-1].title << "' 책은 이미 반납되었습니다." << endl;
    }else{
        cout << "잘못된 선택입니다." << endl;
    }
};

int main()
{
    library.push_back(Book("C++ 입문서"));
    library.push_back(Book("자료구조론"));
    library.push_back(Book("알고리즘 기초"));
    // 벡터 library에 데이터 3개 추가
    int choice;
    while (true)
    {
        menu();
        cin >> choice;
        if (choice == 1) // 책 목록
        {                
            cout << "[도서 목록]" << endl;
            for (int i = 0; i < library.size(); i++)
            {
                if (!library.at(i).isBorrowed)
                {
                    cout << i+1 << ". " << library.at(i).title << " (대출가능)" << endl;
                }else{
                    cout << i+1 << ". " << library.at(i).title << " (대출중)" << endl;
                }
            }
        }else if (choice == 2) //책 대출
        {
            borrow();
        }else if (choice == 3) //책 반납
        {
            returnBook();
        }else if (choice == 4) //종료
        {
            cout << "프로그램을 종료합니다.";
            break;
        }else{ //메뉴에 없는 선택
            cout << "잘못된 선택입니다." << endl;
        }
    }

    return 0;
}
