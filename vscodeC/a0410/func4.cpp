#include <stdio.h>

void myfunc(int mynum[5])
{
  for (size_t i = 0; i < 5; i++)
  {
    printf("%d\n", mynum[i]);
  }
}

int main()
{
  int mynum[5] = {10, 20, 30, 40, 50};
  myfunc(mynum);

  return 0;
}
