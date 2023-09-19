/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tcpserver;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import utility.FileUtility;

/**
 *
 * @author HP
 */
public class TCPServer {

    public static void main(String[] args)throws Exception{
       readAsByte(); 
    }
    
        public static void readAsByte() throws Exception{
        ServerSocket ourFirstServerSocket = new ServerSocket(6790);
        while(true){
            System.out.println("Yeni socket ucun gozleyirem");
            Socket connectionn = ourFirstServerSocket.accept();
            System.out.println("Data came");
           DataInputStream dataStream=new DataInputStream(connectionn.getInputStream());
           byte[] arr=readMessage(dataStream);
//            System.out.println(new String(arr));
            System.out.println("msg length2"+arr.length);
            FileUtility.writeBytes("/Users/HP/Desktop/Heyder.jpg",arr );
        
        }
    } 
        public static byte[] readMessage(DataInputStream din)throws  Exception{
            int msgLen=din.readInt();
            System.out.println("msg len"+msgLen);
            byte[] msg=new byte[msgLen];
            din.readFully(msg);
            return msg;
        }
    
    
    
    public static void readAsString() throws Exception{
        ServerSocket ourFirstServerSocket = new ServerSocket(6789);
        while(true){
            Socket connectionn = ourFirstServerSocket.accept();
            System.out.println("Data came");
            InputStream is =connectionn.getInputStream();
            InputStreamReader reader=new InputStreamReader(is);
            BufferedReader bReader=new BufferedReader(reader);
            
            String messageFromCLient=bReader.readLine();
            System.out.println("messg from client"+messageFromCLient);
        }
    }
}
