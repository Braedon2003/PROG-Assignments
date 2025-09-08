/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ice_task4;

/**
 *
 * @author RC_Student_lab
 */

public class SeriesModel {
    public String[] seriesInfo = new String[4];

    public SeriesModel(String seriesId, String seriesName, String seriesAge, String seriesNumberOfEpisodes) {
        seriesInfo[0] = seriesId;
        seriesInfo[1] = seriesName;
        seriesInfo[2] = seriesAge;
        seriesInfo[3] = seriesNumberOfEpisodes;
    }
}


