#include <stdio.h>

void myFunc(char name[], int age){
  printf("hello %s, you are %d\n", name, age);
}

int main()
{
  myFunc("name", 50);

  return 0;
}
