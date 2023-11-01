package com.advancedalgorithms.asigment.uf;

import java.util.List;

public class UFPathHalving {

    int[] rank;
    Node[] parent;

    // Constructor
    public UFPathHalving(List<String> input)
    {
        rank = new int[input.size()];
        parent = new Node[input.size()];
        init(input);
    }

    // Creates n sets with single item in each
    void init(List<String> input)
    {
        for (int i = 0; i < input.size(); i++) {
            // Initially, all elements are in
            // their own set.
            parent[i] = new Node(input.get(i), i, 0);
        }
    }

    // Returns representative of x's set
    public Node find(int p)
    {
        System.out.println("==find x:" + p);
        System.out.println("==parent[x].getId():" + parent[p].getId());
        // Finds the representative of the set
        // that x is an element of
        /*if (parent[x].getId() != x) {

            Node result = find(parent[x].getId());
            parent[x] = result;
            return result;
        }

        return parent[x];*/
        Node result = parent[p];
        while (p != parent[p].getId()) {
            parent[p] = parent[parent[p].getId()];    // path compression by halving
            p = parent[p].getId();
        }
        return result;
    }

    // Unites the set that includes x and the set
    // that includes x
    public void union(int x, int y)
    {
        // Find representatives of two sets
        Node xRoot = find(x);
        Node yRoot = find(y);

        System.out.println("xxRoot:" + xRoot);
        System.out.println("yxRoot:" + yRoot);

        // Elements are in the same set, no need
        // to unite anything.
        if (xRoot == yRoot)
            return;

        // If x's rank is less than y's rank
        if (xRoot.getRank() < yRoot.getRank())

            // Then move x under y  so that depth
            // of tree remains less
            parent[xRoot.getId()] = yRoot;

            // Else if y's rank is less than x's rank
        else if (yRoot.getRank() < xRoot.getRank())

            // Then move y under x so that depth of
            // tree remains less
            parent[yRoot.getId()] = xRoot;

        else // if ranks are the same
        {
            // Then move y under x (doesn't matter
            // which one goes where)
            parent[yRoot.getId()] = xRoot;

            // And increment the result tree's
            // rank by 1
            xRoot.setRank(xRoot.getRank() + 1);
        }
    }



    public Node[] getParent() {
        return parent;
    }

    public void setParent(Node[] parent) {
        this.parent = parent;
    }
}
