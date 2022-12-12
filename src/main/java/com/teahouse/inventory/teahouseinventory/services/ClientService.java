package com.teahouse.inventory.teahouseinventory.services;

import com.teahouse.inventory.teahouseinventory.domain.Client;

public interface ClientService extends BaseService<Client,Long>{
    Client findByContact(String mobile);
}
