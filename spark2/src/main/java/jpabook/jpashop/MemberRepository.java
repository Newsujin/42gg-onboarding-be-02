package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }
    public Member updateById(Long id, MemberForm memberForm) {
        Member member = em.find(Member.class, id);
        member.setUsername(memberForm.getUsername());
        return member;
    }
    public Member deleteById(Long id, MemberForm memberForm) {
        Member member = em.find(Member.class, id);
        em.remove(member);
        return member;
    }
}
