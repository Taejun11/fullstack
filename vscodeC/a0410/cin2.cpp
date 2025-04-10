#include <stdio.h>
#include <iostream>
#include <string>
using namespace std;

int main() {
  string line;
  cout << "type a gull sentence: ";
  getline(cin, line);
  cout << "string: " << line;
  return 0;
}