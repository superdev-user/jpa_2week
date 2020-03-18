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
			tx.begin();

			Team team2 = new Team("팀2");
			em.persist(team2);

			Member member = em.find(Member.class, 1L);
			member.setTeam(team2);

			// 연관 관계 제거
			Member member2 = em.find(Member.class, 2L);
			member.setTeam(null);

			member.setTeam(null);
			member2.setTeam(null);
			em.remove(team2);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //트랜잭션 롤백
		} finally {
			em.close(); //엔티티 매니저 종료
		}

		emf.close(); //엔티티 매니저 팩토리 종료
	}

}