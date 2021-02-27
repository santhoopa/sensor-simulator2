/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eew.simulator.domain.service;

import com.eew.simulator.sensor.SensorFactory;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Santhoopa
 */
public class SensorSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        String [] channels = {"a","b","c","d"};
        SensorFactory factory = new SensorFactory(4,channels,25,10,1000);
        
        for (int y = 0; y < 5; y++) {
            ArrayList<String[]> data = factory.getSensorOutput();

            for (int x = 0; x < data.size(); x++) {
                String[] data_packet = data.get(x);
                System.out.println(Arrays.toString(data_packet));
            }
        }
    }
    
}
