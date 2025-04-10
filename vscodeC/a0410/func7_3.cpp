#include <stdio.h>
int x = 5;

void myfunc(){
  int x =22;
  printf("%d\n", x);
}

int main()
{
  myfunc();
  printf("%d\n", x);

  return 0;
}
