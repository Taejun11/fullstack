#include <stdio.h>

int main() {
  FILE * fptr;
  fptr = fopen("d:\\student\\filename.txt", "w");
  fprintf(fptr,"1111");
  fclose(fptr);
  return 0;
}