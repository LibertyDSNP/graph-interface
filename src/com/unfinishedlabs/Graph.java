package com.unfinishedlabs;

import com.unfinishedlabs.models.Connection;
import com.unfinishedlabs.models.ConnectionType;
import com.unfinishedlabs.models.Page;

import java.util.List;

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
}
