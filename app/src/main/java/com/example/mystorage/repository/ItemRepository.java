package com.example.mystorage.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.mystorage.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemRepository {

    private static ItemRepository instance;
    private ArrayList<Item> dataset = new ArrayList<>();

    public static ItemRepository getInstance() {
        if (instance == null) {
            instance = new ItemRepository();
        }

        return instance;
    }

    public MutableLiveData<List<Item>> getItems() {
        setItems();

        MutableLiveData<List<Item>> data = new MutableLiveData<>();
        data.setValue(dataset);

        return data;
    }

    private void setItems() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        dataset.add(new Item(uuid, "Apple", "https://i5.walmartimages.ca/images/Large/094/514/6000200094514.jpg",
                "Such a tasty apple"));

        uuid = UUID.randomUUID().toString().replace("-", "");
        dataset.add(new Item(uuid, "Pen", "https://cdn.shopify.com/s/files/1/1418/8220/products/ensso-minimal-fountain-pen-black-aluminum-2_2048x.jpg?v=1521490665",
                "I have a pen, you know..."));


        uuid = UUID.randomUUID().toString().replace("-", "");
        dataset.add(new Item(uuid, "Pineapple", "https://cdn.shopify.com/s/files/1/0206/9470/products/Pineapple_Large_5052_resized_dddf2092-66c5-459f-ae9a-bf48a4eb265d_1024x1024.jpeg?v=1441108713",
                "Suitable for pen and apples"));


        uuid = UUID.randomUUID().toString().replace("-", "");
        dataset.add(new Item(uuid, "Lemon", "https://i5.walmartimages.ca/images/Large/094/504/6000200094504.jpg",
                "Fresh lemon"));


        uuid = UUID.randomUUID().toString().replace("-", "");
        dataset.add(new Item(uuid, "Grape", "https://static.vinepair.com/wp-content/uploads/2017/08/hybrid-alt-internal.jpg",
                "This sort of grape is ideal for wine"));


        uuid = UUID.randomUUID().toString().replace("-", "");
        dataset.add(new Item(uuid, "Apple", "https://sc02.alicdn.com/kf/UTB8j5Iju5aMiuJk43PTq6ySmXXaA/Singapore-Food-Manufacturers-Meiji-Chocolate-Milk-830ml.jpg_350x350.jpg",
                "Sweetest choko milk"));

    }
}
