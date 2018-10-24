package com.company.interfaces;

public interface ICar {

    void tune(int tuneIndex, String tuneAddOn);

    int getOverallPerformance();

    int getEnginePerformance();

    int getSuspensionPerformance();

    String toString();
}
