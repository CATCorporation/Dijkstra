/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Suiken
 */
public class Mouse {
    
    private GenericNode position;
    private ArrayList<GenericNode> wayFound;
    
    public Mouse(GenericNode start){
	position = start;
    }
    
    public GenericNode getPosition(){
	return position;
    }
    
    public void setPosition(GenericNode position){
	this.position = position;
    }
    
    public ArrayList<GenericNode> getWayfound(){
	return wayFound;
    }
    
    public void setWayFound(ArrayList<GenericNode> wayFound){
	this.wayFound = wayFound;
    }
    
}
