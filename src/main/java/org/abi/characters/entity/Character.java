package org.abi.characters.entity;

public class Character {

    private String name;
    private String franchise;

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFranchise() {
        return franchise;
    }
    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    @Override
    public String toString() {
        return "Character [name=" + name + ", franchise=" + franchise + "]";
    }
    
}
