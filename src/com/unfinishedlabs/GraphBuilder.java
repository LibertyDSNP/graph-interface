package com.unfinishedlabs;

import com.unfinishedlabs.models.PrivateGraph;
import com.unfinishedlabs.models.KeyPair;
import com.unfinishedlabs.models.Page;

import java.util.List;

public class GraphBuilder {
    private int msaId;
    private List<KeyPair> priKeys;
    private List<KeyPair> pageEncryptionKeys;
    private List<Page> pages;

    public GraphBuilder withMsaId(int msaId) {
        this.msaId = msaId;
        return this;
    }

    public GraphBuilder withPriKeys(List<KeyPair> priKeys) {
        this.priKeys = priKeys;
        return this;
    }

    public GraphBuilder withPageEncryptionKeys(List<KeyPair> pageEncryptionKeys) {
        this.pageEncryptionKeys = pageEncryptionKeys;
        return this;
    }

    public GraphBuilder withPages(List<Page> pages) {
        this.pages = pages;
        return this;
    }

    public Graph build() {
        return new PrivateGraph(msaId, priKeys, pageEncryptionKeys, pages);
    }
}
