#include <stdio.h>

int myfunc(int a, int b)
{
  return a + b;

}

int main()
{
  int r1 = myfunc(5, 3);
  int r2 = myfunc(15, 3);
  int r3 = myfunc(5, 23);
  printf("결과값: %d\n", r1);
  printf("결과값: %d\n", r2);
  printf("결과값: %d\n", r3);

  return 0;
}
