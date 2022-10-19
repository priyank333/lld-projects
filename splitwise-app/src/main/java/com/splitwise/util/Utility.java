/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.util;

/**
 *
 * @author priyank
 */
public class Utility {
    public static boolean compareDouble(double no1, double no2) {
        double epsilon = 0.000001d;
        return Math.abs(no1 - no2) < epsilon;
    }
}
