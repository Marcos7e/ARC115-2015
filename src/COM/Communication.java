/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM;

import GUI.Configuracion_Inicial;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import static java.awt.image.ImageObserver.ERROR;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class Communication extends Thread {
    
    private static String EncenderLED = "1";
    private static String ApagarLED = "0";
    public boolean getInfo = false;
    //Variables de conexión
    private static OutputStream output = null;
    private static BufferedReader input = null;
    DataInputStream data = null;

    SerialPort serialPort;
    CommPortIdentifier puertoID = null;

    public String puerto = "COM12";
 //   public String dir = "C:\\Users\\Marcos\\Documents\\NetBeansProjects\\dbmeter\\src";
    
    public int TIME_OUT = 0;
    public int DATA_RATE = 0;
    public char arduino_respond = 'n';
    private static String inputLine = null;
    
    public File archivo = null;
    public PrintWriter pw = null;
    public FileWriter fw = null;
    public FileReader fr = null;
    
    public Communication()
    {}
    
     public Communication(String port, int data_rate, int time_out) {
        this.puerto = port;
        this.DATA_RATE = data_rate;
        this.TIME_OUT = time_out;
     //   this.dir = "C:\\Users\\Marcos\\Documents\\NetBeansProjects\\dbmeter\\src";
      //  this.archivo = new File(dir+"\\conData.txt");
    }
     
    
     public Communication(String port, int data_rate, int time_out, String dir) {
        this.puerto = port;
        this.DATA_RATE = data_rate;
        this.TIME_OUT = time_out;
      //  this.dir = dir;
    
    }
     
      public void findPorts(JComboBox jc){
      Enumeration puertoEnum = CommPortIdentifier.getPortIdentifiers();
    
        
      
      
       while (puertoEnum.hasMoreElements()) {
       CommPortIdentifier actualPuertoID = (CommPortIdentifier) puertoEnum.nextElement();
            System.out.println("Puerto Seleccionado: "+actualPuertoID.getName());
            jc.addItem(actualPuertoID.getName());          
    }
       
       if(jc.getItemCount()==0)
       {
           this.showAlertMessage("No se encontro ningun dispositivo conectado. Por favor revise la conexion de la interfaz Braille");
           
       }
      }
   
      
      public void showAlertMessage(String msg)
      {
             Object[] options = {"OK"};
          
           int input = 0;
           input = JOptionPane.showOptionDialog(null, "Asegurese que la interfaz este debidamente conectada ","No se encontro Interfaz",
                   JOptionPane.WARNING_MESSAGE,
                   JOptionPane.WARNING_MESSAGE,
                   null,
                   options,
                   options[0]);
          
           if(input==0)
           {
               System.exit(0);
           }
          
      }

    public void InicializarConexion() {
        //identificando Puertos disponibles....
        Enumeration puertoEnum = CommPortIdentifier.getPortIdentifiers();
        while (puertoEnum.hasMoreElements()) {
            CommPortIdentifier actualPuertoID = (CommPortIdentifier) puertoEnum.nextElement();
            System.out.println("Puerto Encontrado: "+actualPuertoID.getName());
           
            //.....
            //Actualizando puerto predeterminado
            if (puerto.equals(actualPuertoID.getName())) {
                puertoID = actualPuertoID;
                break;
            }
        }
        //Si no se encontró ningun puerto disponible...
        if (puertoID == null) {
           // mostrarError("No se encontro ningun puerto disponible, Asegurese que la interfaz braille este debidamente conectada al computador");
            //System.exit(ERROR);
            return;
        }

        //Abriendo puerto para conexion
        try {
            serialPort = (SerialPort) puertoID.open(this.getClass().getName(), TIME_OUT);
            serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            //   serialPort.disableReceiveTimeout();
            //     serialPort.enableReceiveThreshold(0);
            //E/S serial ...
            output = serialPort.getOutputStream();
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));

        } catch (Exception e) {
            mostrarError(e.getMessage());
            System.exit(ERROR);
        }

    }

    public void sendData(String data) {
        try {
            System.out.println("Mandando "+data+" a Arduino...");
            output.write(data.getBytes());
        } catch (Exception e) {
            mostrarError("ERROR: " + e.getMessage());
            System.exit(ERROR);
        }

    }

    public String getData() {

        try {
            if (input.ready()) {
                inputLine = input.readLine();
            }
            else
            {inputLine = "no estoy listo";}

        } catch (Exception e) {
            System.err.println("Excepción: " + e.getMessage());
            return inputLine;
        }

        return inputLine;

    }

    public int closeConnection() {
        try {
            this.serialPort.close();
            return 1;
        } catch (Exception e) {
            System.err.println("Se produjo una Excepción al cerrar: " + e.getMessage());
            return 0;
        }

    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }



//        public void saveConData(String port, String baudio, String time_out, String directorio)
//    {
//
//        try { 
//            setDir(directorio);
//             this.archivo = new File(directorio+"\\conData.txt");
//
//             if(!archivo.exists())
//             {
//                 archivo.createNewFile();
//             }
//
//                this.fw = new FileWriter(directorio+"\\conData.txt");
//                this.pw = new PrintWriter(fw);
//
//                pw.println(port);
//                pw.println(baudio);
//                pw.println(time_out);
//                System.out.println(port+" "+baudio+" "+time_out);
//
//                fw.close();
//
//
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage()+" Error en saveConData");
//        }
//
//
//    }
//    public void getConData()
//    {
//        try {
//             this.archivo = new File(dir+"\\conData.txt");
//            fr = new FileReader(archivo);
//            BufferedReader br = new BufferedReader(fr);
//
//           this.puerto = br.readLine();
//           this.DATA_RATE = Integer.parseInt(br.readLine());
//           this.TIME_OUT = Integer.parseInt(br.readLine());
//
//           System.out.println(this.puerto+" "+this.DATA_RATE+" "+this.TIME_OUT);
//
//           fr.close();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error en getConData: "+e.getMessage());
//        }
//    }

    
}
