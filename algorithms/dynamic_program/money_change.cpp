#include <iostream>

using namespace std;

int arr[101];
int res[100001];

int main() {
  // initial
  int n;
  cin >> n;
  int s;
  cin >> s;
  int maxa = 0;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    maxa = max(maxa, arr[i]);
  }
  // tham lam
  // do arr[i] max nhat la 100
  int count = 0;
  while (s >= 200) {
    s -= maxa;
    count++;
  }
  // quy hoach dong
  res[0] = 0;
  for (int i = 1; i <= s; i++) {
    res[i] = 10000007; // default
    for (int j = 0; j < n; j++) {
      if (i - arr[j] >= 0) {
        res[i] = min(res[i], res[i - arr[j]] + 1);
      }
    }
  }
  // output
  cout << res[s] + count;

  return 0;
}
