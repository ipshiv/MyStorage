package com.example.mystorage.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mystorage.repository.ItemRepository;
import com.example.mystorage.model.Item;

import java.util.List;

public class ItemViewModel extends ViewModel {

    private MutableLiveData<List<Item>> mItems;
    private ItemRepository mRepo;
    // private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init() {
        if (mItems != null) {
            return;
        }
        mRepo = ItemRepository.getInstance();
        mItems = mRepo.getItems();
    }

    public LiveData<List<Item>> getItemsInStorage() {
        return mItems;
    }

    public void addItem(final Item item) {
        List<Item> currentPlaces = mItems.getValue();
        currentPlaces.add(item);
        mItems.postValue(currentPlaces);
    }

}
