# Import some necessary libraries.
import socket 
import urllib2
import requests
global count
# Some basic variables used to configure the bot        
server = "5.6.7.8" # Server
channel = "#lab8" # Channel
botnick = "Bot1" # Your bots nick
#bot2= "Bot2"

def ping(): # This is our first function! It will respond to server Pings.
  ircsock.send("PONG :pingis\n")  
  


def sendmsg(chan , msg): # This is the send message function, it simply sends messages to the channel.
  ircsock.send("PRIVMSG "+ chan +" :"+ msg +"\n") 

def joinchan(chan): # This function is used to join channels.
  ircsock.send("JOIN "+ chan +"\n")

def hello(): # This function responds to a user that inputs "Hello Mybot"
  ircsock.send("PRIVMSG "+ channel +" :Hello!\n")
  print("itworks")

#def loop():
 # count=0
#break

def website():
#  url = "http://5.6.7.8"
 # r = requests.get(url)
 # c= len(r.content) 
 # print c
 # ircsock.send(len(r.content))
  ircsock.send("PRIVMSG "+ channel +" :The site at 5.6.7.8 has been downloaded \n")
#  ircsock.send("PRIVMSG "+ channel + c)
  print("itworks")
  site = urllib2.urlopen("http://5.6.7.8") 
  output = open('index.html','wb')
  output.write(site.read())
  output.close()  
                
ircsock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
ircsock.connect((server, 6667)) # Here we connect to the server using the port 6667
ircsock.send("USER "+ botnick +" "+ botnick +" "+ botnick +" :This bot is a result of a tutoral covered on http://shellium.org/wiki.\n") # user authentication

ircsock.send("NICK "+ botnick +"\n") # here we actually assign the nick to the bot
#ircsock.send("USER "+ bot2 +" "+ bot2 +" "+ bot2 +" :This bot is a result of a tutoral covered on http://shellium.org/wiki.\n") 

joinchan(channel) # Join the channel using the functions we previously defined

count=True
while count: # Be careful with these! it might send you to an infinite loop
  ircmsg = ircsock.recv(2048) # receive data from the server
  ircmsg = ircmsg.strip('\n\r') # removing any unnecessary linebreaks.
  print(ircmsg) # Here we print what's coming from the server

  if ircmsg.find(":Hello "+ botnick) != -1: # If we can find "Hello Mybot" it will call the function hello()
    hello()

  if ircmsg.find("PING :") != -1: # if the server pings us then we've got to respond!
    ping()

  if ircmsg.find(":SiteGet") != -1: # If we can find "Hello Mybot" it will call the function hello()
  # for x in range(0, 15):
     website()

  if ircmsg.find(":StopLoop") != -1: # If we can find "Hello Mybot" it will call the function hello()
    break
