/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eew.simulator.sensor;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import com.eew.simulator.domain.Channel;

/**
 *
 * @author Santhoopa
 */
public class SensorFactory {

    private int number_of_channels;
    private String[] channel_names;
    private int no_of_data_points;
    private int data_point_lower_boundary;
    private int data_point_upper_boundary;

    public SensorFactory(int number_of_channels, String[] channel_names, int no_of_data_points, int data_point_lower_boundary, int data_point_upper_boundary) {
        this.number_of_channels = number_of_channels;
        this.channel_names = channel_names;
        this.no_of_data_points = no_of_data_points;
        this.data_point_lower_boundary = data_point_lower_boundary;
        this.data_point_upper_boundary = data_point_upper_boundary;
    }

    public ArrayList<String[]> getSensorOutput() throws InterruptedException{
        ArrayList<String[]> packets = new ArrayList<String[]>();

        for (String element : channel_names) {
            Channel channel = new Channel(element, no_of_data_points, data_point_lower_boundary, data_point_upper_boundary);
            packets.add(channel.emit_data_packet());
            TimeUnit.SECONDS.sleep(1);         
        }
        
        return packets;
    }
}
