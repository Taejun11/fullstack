#include <iostream>
#include <string>
using namespace std;

class Book
{
    public:
        string title;
        string author;
        int price;
        void printInfo(){
            cout << title << " " << author << " " << price;
        }
};

int main()
{
    Book book;
    book.title = "책이름";
    book.author = "저자";
    book.price = 10000;
    book.printInfo();
    return 0;
}
