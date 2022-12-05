package com.teahouse.inventory.teahouseinventory.services;

import java.util.List;

import com.teahouse.inventory.teahouseinventory.domain.Item;

public interface ItemEntityService extends BaseService<Item,Long>{
    List<Item> findByStatus(Boolean active);
}
