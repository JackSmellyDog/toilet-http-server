package me.shaposhnikandrii.httptoilet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import me.shaposhnikandrii.httptoilet.config.AppConfig;

public class ToiletServerStarter {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new AppConfig(), new JpaPersistModule("ToiletJpaUnit"));
    injector.getInstance(ToiletServerApp.class).start();
  }
}
