package com.advancedalgorithms.asigment.uf;

import java.util.List;

public class UFPathCompression {

    int[] rank;
    Node[] parent;

    // Constructor
    public UFPathCompression(List<String> input)
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
    public Node find(int x)
    {
        System.out.println("==find x:" + x);
        System.out.println("==parent[x].getId():" + parent[x].getId());
        // Finds the representative of the set
        // that x is an element of
        if (parent[x].getId() != x) {

            Node result = find(parent[x].getId());

            // We cache the result by moving i’s node
            // directly under the representative of this
            // set
            parent[x] = result;

            // so we recursively call Find on its parent
            // and move i's node directly under the
            // representative of this set
            return result;
        }

        return parent[x];
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

// Driver code
/*public class Main {
    public static void main(String[] args)
    {
        // Let there be 5 persons with ids as
        // 0, 1, 2, 3 and 4
        int n = 5;
        DisjointUnionSets dus =
                new DisjointUnionSets(n);

        // 0 is a friend of 2
        dus.union(0, 2);

        // 4 is a friend of 2
        dus.union(4, 2);

        // 3 is a friend of 1
        dus.union(3, 1);

        // Check if 4 is a friend of 0
        if (dus.find(4) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Check if 1 is a friend of 0
        if (dus.find(1) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }*/

    public Node[] getParent() {
        return parent;
    }

    public void setParent(Node[] parent) {
        this.parent = parent;
    }
}
