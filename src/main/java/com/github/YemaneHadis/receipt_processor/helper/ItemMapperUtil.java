package com.github.YemaneHadis.receipt_processor.helper;

import com.github.YemaneHadis.receipt_processor.dto.ItemDTO;
import com.github.YemaneHadis.receipt_processor.model.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemMapperUtil {

    public static List<Item> itemDTOMapper(List<ItemDTO> itemDTOS){
        List<Item> items = new ArrayList<>();
        for (ItemDTO itemDTO : itemDTOS){
            items.add(new Item(itemDTO.shortDescription(), itemDTO.price()));
        }
        return  items;
    }
}
