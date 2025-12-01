package com.school.model;

public class Classroom {

    private String roomNumber;
    private boolean hasComputer;
    private boolean hasSmartboard;

    public Classroom(String roomNumber, boolean hasComputer, boolean hasSmartboard) {
        this.roomNumber = roomNumber;
        this.hasComputer = hasComputer;
        this.hasSmartboard = hasSmartboard;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public boolean hasComputer() {
        return hasComputer;
    }

    public boolean hasSmartboard() {
        return hasSmartboard;
    }

    @Override
    public String toString() {
        return roomNumber;
    }
}
