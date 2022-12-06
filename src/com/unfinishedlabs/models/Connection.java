package com.unfinishedlabs.models;

import java.util.Optional;

public class Connection {
    private int msaId;
    private ConnectionType connectionType;
    // if connection is of type duplex, the latest PRI public key should be provided
    private Optional<Byte[]> priPublicKey;

    public Connection(int msaId, ConnectionType connectionType) {
        assert connectionType != ConnectionType.Duplex;

        this.msaId = msaId;
        this.connectionType = connectionType;
        this.priPublicKey = Optional.empty();
    }

    public Connection(int msaId, ConnectionType connectionType, Byte[] priPublicKey) {
        this.msaId = msaId;
        this.connectionType = connectionType;
        this.priPublicKey = Optional.of(priPublicKey);
    }
}
