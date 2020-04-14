package me.shaposhnikandrii.httptoilet;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.inject.persist.PersistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

public class ToiletServerApp {
  public static final Logger log = LoggerFactory.getLogger(ToiletServerApp.class);

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
