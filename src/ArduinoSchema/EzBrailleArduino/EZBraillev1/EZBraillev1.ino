int serialResponse = 0;
char data[6];
char javaData;

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
   javaData = Serial.read();
 
   //data[0] = javaData.substring(0,1);
   //data[1] = javaData.substring(1,2);
   //data[2] = javaData.substring(2,3);
   //data[3] = javaData.substring(3,4);
   //data[4] = javaData.substring(4,5);
   //data[5] = javaData.substring(5,6);

   data[0] = javaData;
   data[1] = javaData;
   data[2] = javaData;
   data[3] = javaData;
   data[4] = javaData;
   data[5] = javaData;

   Serial.println("Valor Ingresado: " + javaData); 


if(data[0] == '1')
{digitalWrite(10,HIGH);}
else
{digitalWrite(10,LOW);}

if(data[1] == '1')
{digitalWrite(13,HIGH);}
else
{digitalWrite(13,LOW);}

if(data[2] == '1')
{digitalWrite(9,HIGH);}
else
{digitalWrite(9,LOW);}

if(data[3] == '1')
{digitalWrite(12,HIGH);}
else
{digitalWrite(12,LOW);}

if(data[4] == '1')
{digitalWrite(7,HIGH);}
else
{digitalWrite(7,LOW);}

if(data[5] == '1')
{digitalWrite(11,HIGH);}
else
{digitalWrite(11,LOW);}

    }

  
  

 


}
