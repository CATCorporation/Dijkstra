package dijkstra_router.model;

import java.util.ArrayList;

public class PriorityQueue {

	private boolean reversed = false;
	private Element firstElement;
	private ComparatorDistance c;

	public PriorityQueue() {
	}

	public PriorityQueue(ComparatorDistance c) {
		this.c = c;
	}

	public int size() {
		int i = 0;
		Element tmp = firstElement;
		while (tmp != null) {
			tmp = tmp.getNextElement();
			i++;
		}
		return i;
	}

	public void push(Element element) {
		if (reversed) {
			reverse();
		}
		if (firstElement != null) {
			Element tmp = firstElement;
			Element tmp2;
			boolean ajoute = false;

			// Si le premier edge est plus petit que le edge en parametre
			if (c.compare(firstElement.getValue(), element.getValue()) > 0) {
				tmp = firstElement;
				firstElement = element;
				firstElement.setNextElement(tmp);
				ajoute = true;

			} else {
				if (firstElement.getNextElement() != null) {
					if (c.compare(firstElement.getNextElement().getValue(),
							element.getValue()) >= 0) {
						tmp = firstElement.getNextElement();
						firstElement.setNextElement(element);
						tmp2 = firstElement.getNextElement();
						tmp2.setNextElement(tmp);
						ajoute = true;
					}
				}
			}

			while (tmp.getNextElement() != null && ajoute == false) {
				tmp = tmp.getNextElement();

				// Si le premier edge est vide
				if (tmp.getNextElement() == null) {
					tmp.setNextElement(element);
					ajoute = true;
				} else {

					// Tous les autres cas
					tmp2 = tmp.getNextElement();
					if (c.compare(tmp2.getValue(), element.getValue()) > 0) {
						tmp.setNextElement(element);
						element.setNextElement(tmp2);
						ajoute = true;
					}
				}
			}

			// Si le edge est le plus de grand de toute la file, on le met en
			// dernier
			if (ajoute == false) {
				tmp.setNextElement(element);
			}
		} else {
			firstElement = element;
		}
	}

	public void push(GenericNode node) {
		ArrayList<GenericEdge> edges = (ArrayList<GenericEdge>) node.getEdges();
		for (int i = 0; i < edges.size(); i++) {
			this.push(new Element(edges.get(i)));
		}
	}

	/**
	 * 
	 * @return prends le maillon qui a été ajouté en premier, le supprime de
	 *         la chaîne et le retourne
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
		if(size() >= i){
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
	 * @return Le maillon qui a été ajouté en premier, sans le supprimer de
	 *         la chaîne.
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
			if (tmp.getValue().toString().equals(value)) {
				return i;
			}
			tmp = tmp.getNextElement();
			i++;
		}
		return -1;
	}

}
