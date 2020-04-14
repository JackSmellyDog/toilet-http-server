package me.shaposhnikandrii.httptoilet.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "toilet")
public class Toilet {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "context_url")
  private String contextUrl;

  @Column(name = "status_code")
  private Integer statusCode;

  @Column(name = "response_body")
  private String responseBody;

  @OneToMany(mappedBy = "toilet")
  private List<Flushing> flushingList;

}
