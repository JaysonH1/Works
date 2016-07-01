 #!/bin/bash 
         COUNTER=0
         while [  $COUNTER -lt 180 do
           sleep 1  
            curl 5.6.7.8
             let COUNTER=COUNTER+1 
         done
