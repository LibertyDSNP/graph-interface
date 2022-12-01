package com.unfinishedlabs.models;

public class Page {
    private int number;
    private byte[] data;

    public Page(int number, byte[] data) {
        this.number = number;
        this.data = data;
    }
}
