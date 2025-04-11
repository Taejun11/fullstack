#include <iostream>
#include <string>
using namespace std;

int main()
{
  struct
  {
    int mynum;
    string myString;
  }myStruct;

  myStruct.mynum = 1;
  myStruct.myString = "hello world";
  cout << myStruct.mynum << "\n";
  cout << myStruct.myString << "\n";
  
  return 0;
}
