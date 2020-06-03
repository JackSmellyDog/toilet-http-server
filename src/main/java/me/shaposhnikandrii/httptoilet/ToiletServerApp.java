package me.shaposhnikandrii.httptoilet;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.inject.persist.PersistService;
import lombok.extern.slf4j.Slf4j;
import spark.Spark;

@Slf4j
public class ToiletServerApp {

  @Inject
  private PersistService persistService;

  @Inject @Named("port")
  private int port;

  public void start() {
    persistService.start();

    Spark.port(port);

    Spark.get("*", (req, res) -> {
      return "Get method";
    });


    Spark.post("*", (req, res) -> {
      return "Post method";
    });
  }

}
