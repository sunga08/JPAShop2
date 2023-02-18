package jpabook.jpashop2;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId(); //member id만 반환 (커맨드와 쿼리 분리를 위해)
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
