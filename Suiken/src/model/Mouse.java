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
    private GenericNode finishFound;
    private boolean arrived = false;
    
    public Mouse(GenericNode start){
	position = start;
    }
    
    public GenericNode getPosition(){
	return position;
    }
    
    public void setPosition(GenericNode position){
	this.position = position;
    }
    
    public GenericNode getFinishFound(){
	return finishFound;
    }
    
    public void setFinishFound(GenericNode finishFound){
    	this.finishFound = finishFound;
    }
    
    public GenericNode move(){
    	GenericNode tmp = finishFound;
    	while(tmp.getPrevious() != null){
    		tmp = tmp.getPrevious();
    		System.out.println(tmp.toString());
    	}
    	
    	position = tmp;
    	if(position.equals(finishFound)) arrived = true;
    	return position;
    }
    
}
