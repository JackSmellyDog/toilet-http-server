package com.shaposhnik.httptoilet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

import java.time.LocalDateTime;

public class HttpToiletApp {
  public static final Logger log = LoggerFactory.getLogger(HttpToiletApp.class);

  public static void main(String[] args) {
    Spark.post("/report", (req, res) -> {

      log.info("At: {}; Body: ({})", LocalDateTime.now(), req.body());
      return "Report was accepted!";
    });
  }
}
