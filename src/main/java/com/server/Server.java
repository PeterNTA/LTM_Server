/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.server;

/**
 *
 * @author peter
 */
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
public class Server {
    public static void main(String argv[]) throws Exception
    {
        String sentence_from_client;
        String sentence_to_client;
        
        //Tạo socket server, chờ tại cổng '6543'
        ServerSocket welcomeSocket = new ServerSocket(6543);
        
        while(true) {
            //chờ yêu cầu từ client
            Socket connectionSocket = welcomeSocket.accept();
            
            //Tạo input stream, nối tới Socket
            BufferedReader inFromClient =
                new BufferedReader(new
                    InputStreamReader(connectionSocket.getInputStream())); 
            
            //Tạo outputStream, nối tới socket
            DataOutputStream outToClient =
                new DataOutputStream(connectionSocket.getOutputStream());
            
            //Đọc thông tin từ socket
            sentence_from_client = inFromClient.readLine();
            
            sentence_to_client = sentence_from_client +" (Server accepted!)" + '\n';
            //ghi dữ liệu ra socket
            outToClient.writeBytes(sentence_to_client); 

            //return này dùng để ngắt vòng while, ngưng chạy server
            //return;
        }
        
    }
}
