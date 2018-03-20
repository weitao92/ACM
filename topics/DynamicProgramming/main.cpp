#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <cstring>

//https://pcs.cs.cloud.vt.edu/problems/224
using namespace std;

int main() {
  string A, B;
  cin >> A >> B;
  
  int prev[A.size()+1];
  int current[A.size()+1];
  for(int i = 0; i < A.size() + 1; i++)
  {
    prev[i] = 0;
    current[i] = 0;
  }
  
  for(int row = 1; row < B.size()+1; row++)
  {
      for(int col = 1; col < A.size()+1; col++)
      {
          if(row%2 == 1)
          {
            if(B[row-1] == A[col-1])
                current[col] = 1 + prev[col-1];
            else
                current[col] = max(prev[col],current[col-1]);
            prev[0] = 0;
          }
          else
          {
            if(B[row-1] == A[col-1])
                prev[col] = 1 + current[col-1];
            else
                prev[col] = max(current[col],prev[col-1]);
            current[0] = 0;
          }
      }
  }
  
  if(B.size()%2 == 1)
  {
    cout << current[A.size()] << endl;
  }
  else{
    cout << prev[A.size()] << endl;
  }
  return 0;
}