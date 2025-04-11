#include <iostream>
#include <string>
using namespace std;

int main()
{
    string txt = "hello";
    cout << txt << "\n";
    cout << txt.at(0) << "\n";
    cout << txt.at(1) << "\n";
    cout << txt.at(txt.length()-1) << "\n";

    return 0;
}
