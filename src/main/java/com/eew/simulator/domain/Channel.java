/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eew.simulator.domain;

import java.time.Instant;

/**
 *
 * @author Santhoopa
 */
public class Channel {
    final String channelName;
    final Integer packetLength ;
    final Integer dataPointLength ;
    
    private long time_stamp;
    private String[] data_points;
    private int lower;
    private int upper;
    private String[] data_packet;

    //String[] data_points = new String[25];

    public Channel(String channel_name, int data_points_length, int lower, int upper) {
        time_stamp = Instant.now().getEpochSecond();
        dataPointLength = data_points_length;
        packetLength = (data_points_length + 2) ;
        data_points = new String[dataPointLength];
        data_packet = new String[packetLength];
        this.lower = lower;
        this.upper = upper;
        channelName = channel_name; 
        data_packet[0] = channelName;
        data_packet[1] = Long.toString(time_stamp);
        generate_data_points();

    }

    public String[] emit_data_packet() {
        //throw new UnsupportedOperationException("Not supported yet."); 
        return data_packet;
    }

    private void generate_data_points() {
        for (int x = 0; x < dataPointLength; x++) {
            int data_point = getRandomNumber(lower, upper);
            data_packet[x+2] = Integer.toString(data_point);
        }
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
