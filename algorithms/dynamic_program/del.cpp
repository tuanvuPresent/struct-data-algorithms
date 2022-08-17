#include<iostream>

using namespace std;

int point[101];
int res[101];
int main(){
	int n; cin>>n;
	for(int i=0; i<n; i++){
		int x; cin>>x;
		point[x] += x;
	}
	//quy hoach dong
	for(int i=2; i<=100; i++){
		res[i] = max(res[i-1], res[i-2] + point[i]);
		cout<<res[i]<<" ";
	}
	
	
	return 0;
}
