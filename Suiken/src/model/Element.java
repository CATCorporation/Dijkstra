package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Suiken
 */
public class Element{

    Object value;
    Element nextElement = null;
    
    public Element(){}
    
    public Element(Element e){
	value = e.getValue();
    }

    public Element(Object value) {
        this.value = value;
    }

    public Element getNextElement() {
        return nextElement;
    }

    public void setNextElement(Element nextElement) {
        this.nextElement = nextElement;
    }

    public Object getValue() {
        return value;
    }
}
