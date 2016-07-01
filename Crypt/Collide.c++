//JiaH
#include<openssl/evp.h>
#include <iostream>
#include <string.h>
//#include <string>
#include <map>
#include <time.h>

#include<stdio.h>
#include <time.h>
#include<stdlib.h>

using namespace std;
multimap<string,string>::iterator it ,itlow,itup;
 //char data[10200004];
char test[]="DYXFOOLNOSMTEGWVMBWJZJTURNSYSYMXYMDMAQCQJQJPXIKLJIUKRPGKDYIXWXUUJZILQMDBDMSCWCNFNHPGZVRCVBBRAVNLVYW";


void mix()
	{
    
    int i=0;
	for(i = 0; i < 100; i++) {
int num = rand() % 26;
       test[i]='A'+num;
//printf("%c",test[i]);
    }
 //printf("\n");
}

// md5sum from http://stackoverflow.com/questions/29267897/md5-mismatch-between-openssl-and-linux-bash-calculation

typedef multimap<string,string >Mmid;

unsigned char *getMd5Hash(unsigned char *data, size_t dataLen, int *mdLen) {

    unsigned char *md = NULL;

    EVP_MD_CTX *ctx = NULL;

    const EVP_MD *mdType = EVP_md5();

    

    *mdLen = EVP_MD_size(mdType);

    

    md = (unsigned char *) malloc(*mdLen);


    ctx = EVP_MD_CTX_create();

    

    EVP_MD_CTX_init(ctx);

    EVP_DigestInit_ex(ctx, mdType, NULL);

    EVP_DigestUpdate(ctx, data, dataLen);

    EVP_DigestFinal_ex(ctx, md, NULL);


    EVP_MD_CTX_cleanup(ctx);

    EVP_MD_CTX_destroy(ctx);

    return md;

}



int main()
{

    int seeif=0;
   string foundpair="";
   string condition=foundpair;
    srand (time(NULL));

	Mmid pairs;


    char data[1024];
   //char data[1024];
    unsigned char *md;
    unsigned char *md2;
    int i = 0, mdLen = 0, md2Len=0;

      char mat1[8];
    char mat2[8];

     //scanf("%s", data);

    mix();
    strcpy (data,test);
    int strlength=strlen(data);
   string letter1;
    string letter2;


                  int tries=0;
                  int z=0;
                 while(z<100000)
                 {
                  mdLen = 0;
                  mix();
                  strcpy (data,test);
                  md = getMd5Hash((unsigned char *)test, strlen(test), &mdLen);

                for(i = 0; i < 2; i++)  // assign values of md to mat1
                        {
                    mat1[i]=md[i];
                          }

         //assign contents of mat1 to letter1
           
         

                        letter1=mat1;
    pairs.insert(Mmid::value_type(letter1,data));

             mdLen = 0;

    // ---------------------------------------------------------------------- part 2
         mix();
     strcpy (data,test);
    md = getMd5Hash((unsigned char *)test, strlen(test), &mdLen);


  //  printf("\n");

                 for(i = 0; i < 2; i++) 
                     {
                    mat1[i]=md[i];
                     }


         letter2=mat1;



    itlow = pairs.lower_bound (letter2);
	itup = pairs.upper_bound (letter2);

    for (it=itlow; it!=itup; ++it)
     {

          foundpair=letter2;
          if (foundpair[0]==0 && foundpair[1]==0 )
    {
    z=0;
          }
            
else
        z=100000003;
    
    }
       pairs.insert(Mmid::value_type(letter2,data));


    z++;


} // end of while ----------------------------------------------------------------------------


if(foundpair!=condition){


	itlow = pairs.lower_bound (foundpair);
	itup = pairs.upper_bound (foundpair);

    for (it=itlow; it!=itup; ++it)
   {

   //    cout << it->first << " => " << it->second << '\n';
    cout << it->second<<endl;
       }
}

                cout<<"found md5sum is ";
                for(i = 0; i < 2; i++) 
             {
             printf("%02x", (unsigned char) foundpair[i]);

              }


}