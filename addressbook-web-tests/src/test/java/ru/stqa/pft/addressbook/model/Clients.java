package ru.stqa.pft.addressbook.model;
import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergei on 06.05.2016.
 */
public class Clients extends ForwardingSet <ClientData> {

private Set<ClientData> delegate;

public Clients(Clients Clients) {
        this.delegate = new HashSet<>(Clients.delegate());
        }

public Clients() {
        this.delegate = new HashSet<>();
        }

@Override
protected Set<ClientData> delegate() {
        return delegate;
        }

public Clients withAdded(ClientData client) {
        Clients Clients = new Clients(this);
        Clients.add(client);
        return Clients;
        }

public Clients without(ClientData client) {
        Clients Clients = new Clients(this);
        Clients.remove(client);
        return Clients;
        }
        }