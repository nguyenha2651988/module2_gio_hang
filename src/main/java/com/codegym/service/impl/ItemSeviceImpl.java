package com.codegym.service.impl;

import com.codegym.model.Items;
import com.codegym.repository.ItemRepository;
import com.codegym.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ItemSeviceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public Page<Items> findAll(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }
}
