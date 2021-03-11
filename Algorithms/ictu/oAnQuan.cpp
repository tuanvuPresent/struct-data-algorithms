#include<iostream>

using namespace std;
int arr[1001];
int main(){
	//input
	int n,k;cin>>n>>k;
	for(int i=0;i<n;i++)cin>>arr[i];
	//handle
	int count=arr[k-1];
	arr[k-1]=0;

	for(int i=0;i<n;i++)arr[i] += count/n;
	count %= n;
	int pos = k - 1; 
	while(count>0){
		pos = (pos + 1) % n; 
		arr[pos]++;
		
		count--;
	}
	//show ouput
	for(int i=0;i<n;i++) cout<<arr[i]<<" ";
	
	return 0;
}

