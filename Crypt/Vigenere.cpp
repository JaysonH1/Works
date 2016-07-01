//JiaH
// vigenere
#include <iostream>
#include <string>
using namespace std;

void vigenere(string&join,string& key,  string&encrypted)
{
	for(int k=0, j = 0; j <key.length(); ++j)
 {

encrypted[j] = ((join[j] -'A') + key[k]-'A') % 26 +'A';
	//cout<<encrypted[j];
//	changekey=encrypted;
		k++;

}
		//cout<<endl<<encrypted[0]<<encrypted[1]<<encrypted[2];

	//cout<<endl;
}



void paddedfunc(string &input,string padded,int i,int sizeinput,int sizekey)
{
	while (input.length()%sizekey!=0) // if not divided evenly or  multiple join with pad
	{
	input+=padded[i];
	i++;
	//output+=test;

	}

	sizeinput=input.length();

}


int main ()
{
		string input;//="CANYOUHEARMEBOWIE";
		cout<<"Enter input ";
		cin>>input;

		string key;//= "ZIGGY";
		cout<<"Enter key ";
		cin>>key;

		int sizekey=key.length();
		int sizeinput=input.length();


		string encrypted;
		string iv;//="ZIGGY";
		cout<<"Enter iv ";
		cin>>iv;

		string padded="ABCDEFGH";
		int i=0;
		paddedfunc(input,padded,i,sizeinput,sizekey);

	 cout<<"padded input is "<<input<<endl;
	// sizeinput=input.length();

	 //cout<<sizeinput;
/*
	while (input.length()%sizekey!=0) // if not divided evenly or  multiple join with pad
	{

	input+=padded[i];
	i++;
	//output+=test;

	}
	/*/
			 for (int i=0;i<sizeinput;i+=sizekey)//i+blocklength)
		 {
			 if(i==0){
			 string str2 = input.substr (i,sizekey);
			// cout<<str2<<endl;
			 encrypted=str2;
			// cout<<encrypted<<endl;
			 vigenere(str2,iv,encrypted);
			 //cout<<encrypted;
			 vigenere(encrypted,key,encrypted);
			cout<<encrypted<<'\t';
			 }

			 if(i>1){
			 string str2 = input.substr (i,sizekey);
			// cout<<str2<<endl;
			 //encrypted=str2;
			// cout<<encrypted<<endl;
			 vigenere(str2,encrypted,encrypted);
			 //cout<<encrypted;
			 vigenere(encrypted,key,encrypted);
			cout<<encrypted<<'\t';

			 }

		 }
}