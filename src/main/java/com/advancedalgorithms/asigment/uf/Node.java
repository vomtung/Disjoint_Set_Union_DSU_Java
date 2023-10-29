package com.advancedalgorithms.asigment.uf;

public class Node {

    private String name;

    private Integer id;

    private Integer rank;


    public Node(String name, Integer id, Integer rank) {
        this.name = name;
        this.id = id;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", rank=" + rank +
                '}';
    }
}
