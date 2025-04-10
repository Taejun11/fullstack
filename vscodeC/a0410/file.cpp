#include <stdio.h>

int main() {
  FILE * fptr;
  fptr = fopen("d:\\student\\filename.txt", "w");
  fclose(fptr);
  return 0;
}