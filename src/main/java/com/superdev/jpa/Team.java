package com.superdev.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/02/26 Time: 6:33 오후
 */
@Entity
@Table(name = "TEAM")
public class Team {

  @Id
  @Column(name = "TEAM_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "NAME")
  private String name;

  @OneToMany(mappedBy = "team")
  private List<Member> members = new ArrayList<>();

  public Team(String name) {
    this.name = name;
  }

  public Team(){}

  public List<Member> getMembers() {
    return members;
  }
}
