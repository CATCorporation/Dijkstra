/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diksjtra.source;

/**
 *
 * @author 626
 */
public class Edge {
    public final Node target;
    public final double weight;
    public Edge(Node argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}
