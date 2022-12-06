package com.unfinishedlabs;

import com.unfinishedlabs.models.*;

import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Graph graph = new GraphBuilder()
                .withMsaId(1)
                .withPriKeys(List.of(new KeyPair(new byte[] {/* public key */}, new byte[] {/* private key */})))
                .withPageEncryptionKeys(List.of(new KeyPair(new byte[] {/* public key */}, new byte[] {/* private key */})))
                .withPages(List.of(new Page(0, new byte[] { /* page */})))
                .build();

        // get all duplex connections
        var duplexConnections = graph.getConnections(ConnectionType.Duplex);

        // passing PRI keys for all duplex connections to graph SDK (only required for updates)
        graph.setPriKeys(new HashMap<>() {
            {
                put(5, new Byte[] {/* 5's PRI public key */});
                put(10, new Byte[] {/* 10's PRI public key */});
            }
        });

        // adds connection to msa 2 with Duplex connection type
        graph.connect(List.of(new Connection(2, ConnectionType.Duplex, new Byte[] {/* 2's PRI public key */})));

        // removes connection to msa 3 from  graph
        graph.disconnect(List.of(3));

        // updating PRI key for page number 1 with a new PRI key
        graph.updatePriKey(1, new KeyPair(new byte[] {/* public key */}, new byte[] {/* private key */}));

        // updating Encryption key for page number 0 with a new Encryption key
        graph.updateEncryptionKey(0, new KeyPair(new byte[] {/* public key */}, new byte[] {/* private key */}));

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

