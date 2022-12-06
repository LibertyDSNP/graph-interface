package com.unfinishedlabs.models;

import com.unfinishedlabs.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrivateGraph implements Graph {
    private int ownerMsaId;
    private List<KeyPair> ownerPriKeys;
    private List<KeyPair> pageEncryptionKeys;
    private List<Page> pages;

    public PrivateGraph(int ownerMsaId, List<KeyPair> ownerPriKeys, List<KeyPair> pageEncryptionKeys, List<Page> pages) {
        this.ownerMsaId = ownerMsaId;
        this.ownerPriKeys = ownerPriKeys;
        this.pageEncryptionKeys = pageEncryptionKeys;
        this.pages = pages;
    }

    @Override
    public void connect(List<Connection> connections) throws Error {}

    @Override
    public void disconnect(List<Integer> msaIds) throws Error {}

    @Override
    public boolean hasUpdates() {
        return false;
    }

    @Override
    public List<Page> calculateUpdates() throws Error {
        return new ArrayList<>();
    }

    @Override
    public void finalizeUpdates() throws Error {}

    @Override
    public List<Connection> getConnections(ConnectionType connectionType) {
        return new ArrayList<>();
    }

    @Override
    public List<Connection> getConnections() {
        return new ArrayList<>();
    }

    @Override
    public void updatePriKey(int pageNumber, KeyPair newPriKey) throws Error { }

    @Override
    public void updateEncryptionKey(int pageNumber, KeyPair newEncryptionKey) throws Error { }

    @Override
    public void setPriKeys(Map<Integer, Byte[]> priMap) throws Error {
    }
}
