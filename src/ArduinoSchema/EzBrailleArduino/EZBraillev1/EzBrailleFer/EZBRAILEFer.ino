int serialResponse = 0;
char data[6];
char javaData;
int i=0;
void setup() {

Serial.begin(9600);
 
 pinMode(13,OUTPUT);
 pinMode(12,OUTPUT);
 pinMode(11,OUTPUT);
 pinMode(10,OUTPUT);
 pinMode(9,OUTPUT);
 pinMode(7,OUTPUT);

}

void loop() {


 if(Serial.available()>0)
  {

    delay(20);
   javaData = Serial.read();
 //Serial.println(javaData);
   data[i] = javaData;
 i=i+1;

    }

    if(i==6)
    {
      for(int j=0;j<6;j=j+1)
      {
         Serial.println(data[j]);
      }
    

      if(data[0] == '1')
{digitalWrite(13,HIGH);}
else
{digitalWrite(13,LOW);}

if(data[1] == '1')
{digitalWrite(12,HIGH);}
else
{digitalWrite(12,LOW);}

if(data[2] == '1')
{digitalWrite(11,HIGH);}
else
{digitalWrite(11,LOW);}

if(data[3] == '1')
{digitalWrite(10,HIGH);}
else
{digitalWrite(10,LOW);}

if(data[4] == '1')
{digitalWrite(9,HIGH);}
else
{digitalWrite(9,LOW);}

if(data[5] == '1')
{digitalWrite(7,HIGH);}
else
{digitalWrite(7,LOW);}

   i=0;
    } //FIN IF


    

    

  
  

 


}

