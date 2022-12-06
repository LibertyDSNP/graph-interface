package com.unfinishedlabs;

import com.unfinishedlabs.models.Connection;
import com.unfinishedlabs.models.ConnectionType;
import com.unfinishedlabs.models.KeyPair;
import com.unfinishedlabs.models.Page;

import java.util.List;
import java.util.Map;

public interface Graph {
    /**
     * Adding new connections to existing graph
     * @param connections
     */
    void connect(List<Connection> connections) throws Error;

    /**
     * Removing existing connections from graph
     * @param msaIds
     */
    void disconnect(List<Integer> msaIds) throws Error;

    /**
     * Checks to see if there are any changes that is going to require graph updates on chain
     * @return true if there are updates
     */
    boolean hasUpdates();

    /**
     * Calculates the updated pages
     * @return a list of pages that are updated and requires to be uploaded to chain
     */
    List<Page> calculateUpdates() throws Error;

    /**
     * Finalizes applied changes in graph so that they are considered all synced with the chain.
     * Usually should only be called after uploading all changes to the chain
     */
    void finalizeUpdates() throws Error;

    /**
     * Get all connections for a specific connection type in the graph
     * @param connectionType
     */
    List<Connection> getConnections(ConnectionType connectionType);

    /**
     * Get all connections in the graph
     */
    List<Connection> getConnections();

    /**
     * Changing PRI key used in the page (should be called after PRI key rotation)
     */
    void updatePriKey(int pageNumber, KeyPair newPriKey) throws Error;

    /**
     * Changing Encryption key used in the page (should be called for rotating used encryption key)
     */
    void updateEncryptionKey(int pageNumber, KeyPair newEncryptionKey) throws Error;

    /**
     * Set PRI public keys for connections (only required for updates to graph)
     * priMap is a map between msa_id to pri public key
     */
    void setPriKeys(Map<Integer, Byte[]> priMap) throws Error;
}
