package com.superdev.jpa;

import java.util.List;
import javax.persistence.*;

public class JpaApplication {

	public static void main(String[] args) {

		//엔티티 매니저 팩토리 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

		try {


			String jpql = "select m from Member m join m.team t where t.name =:teamName";
			List<Member> resultList = em.createQuery(jpql, Member.class).setParameter("teamName", "팀1").getResultList();
			resultList.forEach(member -> {
				System.out.println("[query] member.username=" + member.getUsername());
			});

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //트랜잭션 롤백
		} finally {
			em.close(); //엔티티 매니저 종료
		}

		emf.close(); //엔티티 매니저 팩토리 종료
	}

}