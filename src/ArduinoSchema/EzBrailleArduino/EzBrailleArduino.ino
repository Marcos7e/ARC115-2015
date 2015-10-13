int arduino_response; //si es 'y' El led en 11 enciende, si es 'n' lo detiene
void setup (){

  Serial.begin(9600); //abre el puerto serie a 9600 Baudios
  pinMode(11,OUTPUT); //configurando pin11 para led de muestra

}

void loop(){

if(Serial.available()>0) //si existe una conexion Serial...
{
 arduino_response = Serial.read();//leer lo que Java mande...
  delay(2); //estabilidad de las operaciones ...
  
  if(arduino_response=='y'){ //si recibo'Y' Java me indica encender el led
  delay(10);
  digitalWrite(11,HIGH);
  }
  
   if(arduino_response=='n'){ //si recibo 'n' Java me indica apagar el led
  delay(10);
  digitalWrite(11,LOW);
  }
  
}

}
