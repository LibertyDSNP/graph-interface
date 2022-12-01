package com.unfinishedlabs;

import com.unfinishedlabs.models.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Graph graph = new GraphBuilder()
                .withMsaId(1)
                .withPriKeys(List.of(new KeyPair(new byte[] {/* public key */}, new byte[] {/* private key */})))
                .withPageEncryptionKeys(List.of(new KeyPair(new byte[] {/* public key */}, new byte[] {/* private key */})))
                .withPages(List.of(new Page(0, new byte[] { /* page */})))
                .build();

        // get all simplex connections
        var simplexConnections = graph.getConnections(ConnectionType.Simplex);

        // adds connection to msa 2 with Duplex connection type
        graph.connect(List.of(new Connection(2, ConnectionType.Duplex)));

        // removes connection to msa 3 from  graph
        graph.disconnect(List.of(3));

        if (graph.hasUpdates()) {
            var pages = graph.calculateUpdates();

            for (Page page : pages) {
                // update chain with page
            }

            graph.finalizeUpdates();
        }

        // get all connections
        var allConnections = graph.getConnections();
    }
}

