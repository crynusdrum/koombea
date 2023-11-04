package com.tb.koombea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tb.koombea.model.Item;
import com.tb.koombea.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	
	
	public List<Item> itemList(){
		
		return itemRepository.findAll();
	}
	
	public Item getItem(Long id) {
		
		Optional<Item> item = itemRepository.findById(id);
		
		return item.isPresent() ? item.get() : null;
	
	}
	
	public Item itemUpdate(Long id, Item item) {
		
		Item itemFromDB = getItem(id);
		
		if(itemFromDB != null) {
			itemFromDB.setName(item.getName());
			itemFromDB.setOtherField(item.getOtherField());
			return itemRepository.save(itemFromDB);
		}
		
		return null;
		
		
	}
	
	public Item	itemSave(Item item) {
		
		return itemRepository.save(item);
	}
	
	public List<Item> itemsSave(List<Item> itemsList){
		
		List<Item> savedItemsList = new ArrayList<>();
		
		for (Item item : itemsList) {
			itemRepository.save(item);
			savedItemsList.add(item);
		}
		
		return savedItemsList;
	}
	
	public void itemDelete(Long id) {
		
		Optional<Item> item = itemRepository.findById(id);
		
		itemRepository.delete(item.get());
		
	}
	
	public Item findByIdAndNameAndOtherField(Item item){
		
		List<Item> itemList = itemRepository.findByIdAndNameAndOtherField(item.getId(), item.getName(), item.getOtherField());

		Optional<Item> itemObj = itemList.stream().findFirst();

		return itemObj.isPresent() ? itemObj.get() : null; 

		 
		
	}

}


