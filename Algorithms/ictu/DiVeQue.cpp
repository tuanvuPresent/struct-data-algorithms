#include<iostream>

using namespace std;
int a[101];
int b[101];
int f[101];

void solve(int n){
	f[0] = a[0] * b[0];
	for(int i=1;i<n;i++){
		int smin = a[i] * b[0];
		for(int j=1;j<=i;j++){
			int sum = f[j-1] + b[j] * (a[i] - a[j-1]);
			if(smin > sum){
				smin = sum;
			}
		}
		f[i] = smin;
	}
}

int main(){
	//input
	int n;cin>>n;
	for(int i=0;i<n;i++){
		cin>>a[i];
		if(i>0) a[i] += a[i-1];
	}
	for(int i=0;i<n;i++)cin>>b[i];
	//handle
	solve(n);	
	//show ouput
	cout<<f[n - 1];
	
	return 0;
}

