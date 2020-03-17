package com.superdev.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

  public Team(String name) {
    this.name = name;
  }

  public Team(){}
}
