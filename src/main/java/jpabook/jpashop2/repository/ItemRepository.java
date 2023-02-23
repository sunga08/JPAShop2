package jpabook.jpashop2.repository;

import jpabook.jpashop2.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item){
        if(item.getId() == null){ //jpa에 저장하기 전까지는 id가 없으므로
            em.persist(item); //신규 등록
        } else{ //id 값이 있으면 이미 db에 있거나 어디서 가져온것
            em.merge(item); // 업데이트(와 비슷)
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
