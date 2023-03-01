package jpabook.jpashop2.service;

import jpabook.jpashop2.domain.item.Book;
import jpabook.jpashop2.domain.item.Item;
import jpabook.jpashop2.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, int price, String name, int quantity){
        Item findItem = itemRepository.findOne(itemId); //id를 기반으로 실제 db에 있는 영속 상태 엔티티를 찾아옴

        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(quantity);
        //값 셋팅 후 아무것도 호출할 필요 없다
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }
}
