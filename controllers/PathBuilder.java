/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author User
 */
public class PathBuilder {
    private static final String ROOT =  "/resources";
    private static final String IMAGE = "/image";
    private static final String MUSIC = "/music";
    
    public static String getImg(String path){
        return ROOT+IMAGE + path;
    }
    
    public static String getMusic(String path){
        return ROOT + MUSIC + path;
    }
    
}
