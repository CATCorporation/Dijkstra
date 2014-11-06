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
public class Stack {

    Element firstElement = null;
    boolean reversed = false;

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

    public Element pop() {
        if (!reversed) {
            reverse();
        }
        Element result;
        result = firstElement;
        remove(1);
        return result;
    }

    public void remove(int i) {
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

    public String toString() {
        if (!reversed) {
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

    public Element peek() {
        if (!reversed) {
            reverse();
        }
        return firstElement;
    }

    public int search(String value) {
        if (!reversed) {
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
