/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM;

/**
 *
 * @author raulito
 */
public class connectionData {
    
    private  static String port = "";
    private  static int data_rate = 0;
    private  static int time_out =0;

    

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        connectionData.port = port;
    }

    public static int getData_rate() {
        return data_rate;
    }

    public static void setData_rate(int data_rate) {
        connectionData.data_rate = data_rate;
    }

public static int getTime_out() {
        return time_out;
    }

    public static void setTime_out(int time_out) {
        connectionData.time_out = time_out;
    }
    
}
