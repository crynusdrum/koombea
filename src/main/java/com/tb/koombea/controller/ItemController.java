package com.tb.koombea.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tb.koombea.model.Item;
import com.tb.koombea.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService itemService;

	@GetMapping
	public List<Item> itemList() {


		return itemService.itemList();

	}

	@GetMapping("/{id}")
	public ResponseEntity<Item> getItem(@PathVariable Long id) {

		return Optional.ofNullable(itemService.getItem(id)).map(item -> ResponseEntity.ok().body(item)) // 200 OK
				.orElseGet(() -> ResponseEntity.notFound().build()); // 404 Not found

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Item itemCreate(@RequestBody Item item) {

		return itemService.itemSave(item);

	}

	@PutMapping("/{itemId}")
	@ResponseStatus(HttpStatus.OK)
	public Item itemUpdate(@PathVariable Long itemId, @RequestBody Item item) {
		

		return itemService.itemUpdate(itemId, item);

	}

	@DeleteMapping("/{itemId}")
	@ResponseStatus(HttpStatus.OK)
	public boolean itemDelete(@PathVariable Long itemId) {

		boolean isDeleted = true;
		itemService.itemDelete(itemId);

		return isDeleted;

	}

	@GetMapping("/getItem")
	public ResponseEntity<Item> getItem(@RequestBody Item item) {

		return Optional.ofNullable(itemService.findByIdAndNameAndOtherField(item))
				.map(itemObj -> ResponseEntity.ok().body(itemObj)) // 200 OK
				.orElseGet(() -> ResponseEntity.notFound().build()); // 404 Not found

	}


}
