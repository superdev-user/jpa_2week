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

			Team team = em.find(Team.class, 1L);
			List<Member> members = team.getMembers(); // 객체 그래프 탐색
			members.forEach(member -> {
				System.out.println("member.username = " + member.getUsername());
			});
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