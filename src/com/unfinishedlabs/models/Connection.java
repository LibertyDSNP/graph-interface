package com.unfinishedlabs.models;

public class Connection {
    private int msaId;
    private ConnectionType type;

    public Connection(int msaId, ConnectionType type) {
        this.msaId = msaId;
        this.type = type;
    }
}
