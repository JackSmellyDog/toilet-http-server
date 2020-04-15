package me.shaposhnikandrii.httptoilet.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Table
@Entity(name = "flushing")
public class Flushing {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "flushing_time")
  private LocalDateTime flushingTime;

  @Column(name = "request_body")
  private String requestBody;

  @ManyToOne
  @JoinColumn(name = "toilet_id")
  private Toilet toilet;

}