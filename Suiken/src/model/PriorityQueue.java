/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Suiken
 */
public class PriorityQueue{
    boolean reversed = false;
    Element firstElement;
    
    public PriorityQueue(){}
    
    public PriorityQueue(PriorityQueue pq){
	Element tmp = new Element(pq.firstElement);
    	
    	while(tmp.getNextElement() != null){
    		this.push(new Element(tmp.getNextElement()));
    		tmp = tmp.getNextElement();
    	}
    }
    
    public void push(Element element) {
        if (reversed) {
            reverse();
        }
        if (firstElement != null) {
            Element tmp = firstElement;
            while (tmp.getNextElement() != null) {
                tmp = tmp.getNextElement();
            }
            tmp.setNextElement(element);
        } else {
            firstElement = element;
        }
    }

    /**
     * 
     * @return prends le maillon qui a été ajouté en premier, le supprime de la chaîne et le retourne
     */
    public Element pop() {
        if (reversed) {
            reverse();
        }
        Element result;
        result = firstElement;
        remove(1);
        return result;
    }

    private void remove(int i) {
        if (i == 1) {
            firstElement = firstElement.getNextElement();
        } else if (i > 1) {
            Element tmpf = firstElement;
            Element tmps = firstElement.getNextElement();
            Element tmpt = firstElement.getNextElement().getNextElement();

            int count = 2;
            while (tmpt.getNextElement() != null) {
                if (count == i) {
                    tmpf.setNextElement(tmpt);
                    return;
                }
                tmpf = tmps;
                tmps = tmpt;
                tmpt = tmpt.getNextElement();
                count++;
            }

            if (i == count + 1) {
                tmps.setNextElement(null);
            }
        }
    }

    @Override
    public String toString() {
        if (reversed) {
            reverse();
        }
        Element tmp = firstElement;
        String result = "";
        while (tmp != null) {
            result += tmp.getValue() + " ";
            tmp = tmp.getNextElement();
        }
        return result;
    }

    private void reverse() {
        Element tmpf = firstElement;
        Element tmps = firstElement.getNextElement();
        Element tmpt = firstElement.getNextElement().getNextElement();
        tmpf.setNextElement(null);
        while (tmpt.getNextElement() != null) {
            tmps.setNextElement(tmpf);
            tmpf = tmps;
            tmps = tmpt;
            tmpt = tmpt.getNextElement();
        }
        tmps.setNextElement(tmpf);
        tmpt.setNextElement(tmps);
        firstElement = tmpt;
        if (reversed) {
            reversed = false;
        } else {
            reversed = true;
        }
    }

    public boolean empty() {
        if (firstElement == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @return Le maillon qui a été ajouté en premier, sans le supprimer de la chaîne.
     */
    public Element peek() {
        if (reversed) {
            reverse();
        }
        return firstElement;
    }

    public int search(String value) {
        if (reversed) {
            reverse();
        }
        int i = 1;
        Element tmp = firstElement;
        while (tmp != null) {
            if (tmp.getValue().equals(value)) {
                return i;
            }
            tmp = tmp.getNextElement();
            i++;
        }
        return -1;
    }

}
